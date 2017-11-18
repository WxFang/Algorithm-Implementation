public class Solution {

    public static String removeVowels(String s){
    	if(s == null || s.length() == 0) return s;

    	Character[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    	List<Character> list = Arrays.asList(arr);

    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(i < s.length()){
    		if(!list.contains(s.charAt(i)))
    			sb.append(s.charAt(i++));
    		else{
    			int j = i; 
	    		while(j < s.length() && list.contains(s.charAt(j))) j++;
	    		if(j > i + 1){
	    			sb.append(s.substring(i, j));
	    			i = j;
	    		}
	    		else
	    			i++;
    		}
    		
    	}
    	return sb.toString();
    }

    public static void main(String[] args){
    	String s = "qwerttyyyuttrsaaetehi";
    	System.out.println(s);
    	String res = removeVowels(s);
    	System.out.println(res);
    }

}
