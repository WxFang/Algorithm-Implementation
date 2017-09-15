package amazon;

import java.util.*;

public class windowSum {

	public static List<Integer> _windowSum(List<Integer> input, int k){
		
		List<Integer> res = new ArrayList<>();
		if(input == null || input.size() == 0 || k <= 0 || k > input.size()) return res;
		int sum = 0;
		
		for(int i = 0; i <= k - 1 && i < input.size(); i++)
			sum += input.get(i);
		
		res.add(sum);
		
		int slow = 0, fast = k;
		while(fast < input.size()){
			sum -= input.get(slow++);
			sum += input.get(fast++);
			res.add(sum);
		}
		
		return res;
	}
	
	public static void main(String[] args){
		List<Integer> input = new ArrayList<>();
		input.addAll(Arrays.asList(2,3,4,2,5,7,8,9,6));
		List<Integer> output = _windowSum(input, 5);
		for(int i: output)
			System.out.println(i + " ");
	}
	
}
