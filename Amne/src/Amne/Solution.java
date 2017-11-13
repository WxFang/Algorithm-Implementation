package Amne;

import java.util.*;
import java.time.*;
import java.io.*;

public class Solution {
	
	private static int[] trackTrends(int[] arr, int k){
	
	    if(arr.length < k) return null;
	
	    // use doubly linked list to save increasing and decreasing subarray index
	    // int[0]: start index, int[1]: end index, int[2]: flag for inc or dec
	    Deque<int[]> dq = new LinkedList<>();
	    int[] res = new int[arr.length - k + 1];
	    
	    // use two pointers to compute for first window res[0]
	    // add index information to doubly linked list
	    // time complexity for first window: O(n)
	    int left = 0;
	    while(left < k - 1){
	        int right = left + 1;
	        if(arr[left] > arr[right]){ // decreasing
	            while(right < k && arr[right - 1] > arr[right])
	                right++;
	            dq.addLast(new int[]{left, right - 1, -1});
	            res[0] -= (right - left) * (right - left - 1) / 2; // after simplifying math computation
	            left = right - 1;
	        }
	        else if(arr[left] < arr[right]){ // increasing
	            while(right < k && arr[right - 1] < arr[right])
	                right++;
	            dq.addLast(new int[]{left, right - 1, 1});
	            res[0] += (right - left) * (right - left - 1) / 2;
	            left = right - 1;
	        }
	        else
	            left++;
	    }
	    
	    // use doubly linked list to compute for rest windows res[1] -> res[n - k]
	    // for each window i: 
	    // 1. refresh index information in doubly linked list (last i - 1 and first i + k - 1)
	    // 2. compute change of # of subarrays based on last window i -1
	    
	    for(int i = 1; i < arr.length - k + 1; i++){
	        res[i] = res[i - 1];
	        int[] temp = new int[3];
	        if(!dq.isEmpty() && dq.peekFirst()[0] == i - 1){
	            temp = dq.pollFirst();
	            res[i] -= temp[2] * (temp[1] - temp[0]);
	            if(temp[1] > i)
	                dq.addFirst(new int[]{i, temp[1], temp[2]});
	        }
	        int j = i + k - 1;
	        if(arr[j] == arr[j - 1]) continue;
	        if(!dq.isEmpty() && dq.peekLast()[1] == j - 1){
	            if(dq.peekLast()[2] * (arr[j] - arr[dq.peekLast()[1]]) > 0){
	                temp = dq.pollLast();
	                res[i] += temp[2] * (j - temp[0]);
	                dq.addLast(new int[]{temp[0], j, temp[2]});
	                continue;
	            }       
	        }
	        dq.addLast(new int[]{j - 1, j, (arr[j] > arr[j - 1] ? 1 : -1)});
	        res[i] += (arr[j] > arr[j - 1] ? 1 : -1);
	    }
	    return res;
	}




	public static void main(String []args) throws FileNotFoundException{
		
		// extract data from input file
	    File file = new File("src/inputs/input.txt");
	    Scanner sc = new Scanner(file);
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	
	    int[] arr = new int[n];
	    int i = 0;
	    while(sc.hasNextInt())
	    	arr[i++] = sc.nextInt();
	    
	    LocalTime sTime = LocalTime.now();
	
	    // save function result to array
	    int[] res = trackTrends(arr, k);
	    
	    // print start and end time
	    System.out.println("Start time:  " + sTime);
	    System.out.println("End Time:    " + LocalTime.now());
	    
	    // write output to txt file
	    PrintWriter out = new PrintWriter("src/output.txt");
	    for(int j = 0; j < res.length; j++)
	    	out.println(res[j]);
	    out.close();
	}


}