package nyansa;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parse {
	private Map<String, Map<String, Integer>> map;
	private String fileName;
	
	public Parse(String name) {
		map = new TreeMap<>();
		fileName = name;
	}
	
	/*
	 * get ascending timestamp and corresponding value from treemap
	 * restore wesite information and hit count in heap
	 * compare based on hit count and website string
	 * poll and print each item out from heap
	 */
	public void parseString() {
		
		readInput();
		
		for(String k: map.keySet()) {
			String[] strs = k.split("\\/");
			
			// print timestamp first
			System.out.println(strs[1] + "/" + strs[2] + "/" + strs[0] + " GMT");	
			
			// build up priority queue
			// first compare hit count 
			// then compare website string
			PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
					int ret = Integer.compare(e2.getValue(), e1.getValue());
					if(ret == 0) return e1.getKey().compareTo(e2.getKey());
					return ret;					
				}
			});
			pq.addAll(map.get(k).entrySet());
			
			// print website and hit count information
			while(!pq.isEmpty()) {
				Map.Entry<String, Integer> entry = pq.poll();
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			
		}
	}
	
	/*
	 * read data line by line from input file
	 * parse and restore it in treemap
	 * key: formatted timestamp, value: map(key: website name, value: hit count) 
	 * treemap is ordered by ascending timestamp
	 */
	private void readInput() {
		
		try {
			
			Scanner scanner = new Scanner(new FileReader(fileName));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] strs = line.split("\\|");				
			    String time = format(Long.valueOf(strs[0]));
			    if(!map.containsKey(time)) 
			    	map.put(time, new HashMap<>());
			    map.get(time).put(strs[1], map.get(time).getOrDefault(strs[1], 0) + 1);
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * change timestamp format to yyyy/MM/dd
	 */
	private String format(long time) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time * 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	    return sdf.format(calendar.getTime());
	    
	}
	
	/*
	 * set command line: input.txt
	 * then run main function
	 * see output in console
	 */
	public static void main(String[] args) {
		
		System.out.println("Input file: " + args[0]);
		
		// initialize treemap
		// set filename 
		Parse parse = new Parse("src/nyansa/" + args[0]);

		parse.parseString();
	}
}
