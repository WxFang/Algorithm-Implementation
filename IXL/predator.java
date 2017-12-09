/*
有0 - (n-1) 总共n个物种，每个物种可以是捕食第k个物种，也可以什么不吃（-1）,这个信息用predator数组记录，每个物种最多捕食一种物种，不存在A吃B，B吃A这种情况
A吃B，这种叫直接捕食；A吃B，B吃C，A对C是间接捕食
题目要求是让你把这些species分组，每一组内不存在捕食和间接捕食关系，问最少可以分几组
举个简单例子就是 1，-1，3，1， 0号物种、3号物种捕食1，2号物种捕食3.... 最终答案是3，{1}，{0，3}，{2}这样的分组
总结就是：如果一个物种什么都不吃，标为1，捕食者比被捕食者高1，最后求这一系列中的最大level（因为一个物种最多吃一个，难度也不大，主要是理解题意）
*/

import java.util.*;
public class Solution{

	public static void main(String[] args){
		int[] arr = {1, -1, 3, 1, 0};
		System.out.println(predator(arr));
	}

	public static int predator(int[] arr){
		if(arr.length == 0) return 0;
		int[] res = new int[arr.length];
		Arrays.fill(res, 1);
		for(int i = 0; i < arr.length; i++){
			int cur = arr[i], prev = i;
			if(cur == -1) continue;
			while(cur != -1){
				res[cur] = Math.max(res[cur], res[prev] + 1);
				prev = cur;
				cur = arr[cur];
			}
		}
		int max = 0;
		for(int n: res)
			max = Math.max(max, n);
		return max;
	}

}