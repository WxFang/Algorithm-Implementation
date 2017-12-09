/*
给定一个数组，其中有一或者多个出现频率最大的数字，比如[1,1,2,2,1,2]中1，2都是出现频率最高的,且频率为2，则这个array的degree就是2。
要求找出长度最短的subarray，这个subarray的degree等于原array的degree，最后输出这个subarray的长度。
example: [1,2,2,1,3]，1，2都是频率最高的数，degree为2。[1,2,2,1], [2,2,], [1,2,2,1,3], [1,2,2], [2,2,1], [2,2,1,3]
都是degree为2的subarray。其中[2，2]是长度最短的，包含所有2，所以return 2。
*/

import java.util.*;

class Subarray{
	public int freq;
	public  int start;
	public int end;
	public Subarray(int start, int end){
		this.start = start;
		this.end = end;
		this.freq = 1;
	}
	public Subarray update(int end){
		this.end = end;
		this.freq++;
		return this;
	}
	public int getLen(){
		return this.end - this.start + 1;
	}
}

public class Solution{
	public static void main(String[] args){
		int[] arr = {1, 2, 2, 1, 3};
		System.out.println(degreeSubarray(arr));
	}

	private static int degreeSubarray(int[] arr){
		Map<Integer, Subarray> map = new HashMap<>();
		int max = 0, minLen = arr.length;
		for(int i = 0; i < arr.length; i++){
			int n = arr[i];
			if(!map.containsKey(n))
				map.put(n, new Subarray(i, i));
			else
				map.put(n, map.get(n).update(i));
			max = Math.max(max, map.get(n).freq);
		}
		for(Subarray sub: map.values()){
			if(sub.freq == max)
				minLen = Math.min(minLen, sub.getLen());
		}
		return minLen;
	}
}