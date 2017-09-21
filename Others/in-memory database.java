import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    // HashMap update to store current state
    private static Map<String, Integer> update = new HashMap<>();
    // HashMap count to store count of values
    private static Map<Integer, Integer> count = new HashMap<>();
    // use String to store reverse command; save space compared to LinkedList
    private static String command = "";
    
    public static void main(String args[] ) throws Exception {
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            int val;
            String name;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                // select command using first word
                select(line.split(" "), false);
            }
        }
        finally{
            if(scanner != null)
                scanner.close();
        }
    }
    
    /*
    input: 
    String[] cmd
    boolean flag | true: rollback mode, do not append reverse command to command string
                 | false: normal mode, append each command to command string
    */
    private static void select(String[] cmd, boolean flag){
        String name;
        int val;
        switch(cmd[0]){
            case "SET": 
                name = cmd[1];
                val = Integer.parseInt(cmd[2]);
                set(name, val, flag);
                break;
            case "GET": 
                name = cmd[1];
                get(name);
                break;
            case "UNSET": 
                name = cmd[1];
                unset(name, flag);
                break;
            case "NUMEQUALTO": 
                val = Integer.parseInt(cmd[1]);
                equalTo(val);
                break;
            case "END": 
                end();
                break;
            case "BEGIN": 
                begin();
                break;
            case "ROLLBACK": 
                rollback();
                break;
            case "COMMIT": 
                commit();
                break;
            default: break;
        }
    }
    
    private static void set(String name, Integer val, boolean flag){
        count.put(update.get(name), count.getOrDefault(update.get(name), 1) - 1);
        count.put(val, count.getOrDefault(val, 0) + 1);
        if(flag == false){
            if(update.get(name) != null) command = "SET " + name + " " + update.get(name) + "," + command;
        else command = "UNSET " + name + "," + command;
        }
        update.put(name, val);
    }
    
    private static void get(String name){
        if(update.containsKey(name)) System.out.println("> " + update.get(name));
        else System.out.println("> " + "NULL");
    }
    
    private static void unset(String name, boolean flag){
        count.put(update.get(name), count.getOrDefault(update.get(name), 1) - 1);
        if(flag == false)
            command = "SET " + name + " " + update.get(name) + "," + command;
        update.remove(name);
    }
    
    private static void equalTo(int val){
        if(count.containsKey(val)) System.out.println("> " + count.get(val));
        else System.out.println("> " + "0");
    }
    
    private static void end(){
        update.clear();
        update.clear();
        command = "";
    }
    
    private static void begin(){
        command = "|" + command;
    }
    
    private static void rollback(){
        if(command.length() == 0 || command.indexOf("|") < 0){
            System.out.println("> NO TRANSACTION");
            return;
        }
        int idx = command.indexOf("|");
        String cmd = command.substring(0, idx);
        command = command.substring(idx + 1, command.length());
        
        for(String s: cmd.split(",")){
            select(s.split(" "), true);
        }
    }
    
    private static void commit(){
        if(command.length() == 0) System.out.println("> NO TRANSACTION");
        else command = "";
    }
}