package amazon;

import java.util.*;

class Result{
	int id;
	int value;
	public Result(int id, int value){
		this.id = id;
		this.value = value;
	}
}

public class getHighFive {

	public static Map<Integer, Double> _getHighFive(Result[] arr){
		Map<Integer, Double> res = new HashMap<>();
		
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for(Result stu: arr){
			if(map.containsKey(stu.id)){
				map.get(stu.id).offer(stu.value);
				if(map.get(stu.id).size() > 5) map.get(stu.id).poll();
			}
			else{
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.offer(stu.value);
				map.put(stu.id, pq);
			}
		}
		
		for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()){
			double temp = 0.0;
			while(entry.getValue().size() > 0) 
				temp += entry.getValue().poll();
			temp /= 5;
			res.put(entry.getKey(), temp);
		}
		
		return res;
	}
	
    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);
 
        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = _getHighFive(arr);
 
        System.out.println(res.get(1) + " " +res.get(2));
    }
	
}
