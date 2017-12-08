// Given a 2-d array of "sharpness" values. Find a path from the leftmost column to the rightmost column which has the highest minimum sharpness.
// Output the highest minimum sharpness. Each move can only move to the top right, right or bottom right grid..
// Example: 3*3 matrix
// 5 7 2
// 7 5 8
// 9 1 5
// The path with highest minimum sharpness is 7-->7-->8, because 7 is the highest minimum value in all the paths.. 
// Idea: Use DP dp[r][c] = min(max(dp[r-1][c-1], dp[r][c-1], dp[r+1][c-1]), grid[r][c])

public class Solution{
	public static void main(String[] args){
		int[][] arr = {{5, 7, 1}, {7, 5, 8}, {9, 1, 5}};
		System.out.println(minSharpness(arr));
	}

	public static int minSharpness(int[][] arr){
		int res = Integer.MIN_VALUE;
		for(int c = 1; c < arr[0].length; c++){
			for(int r = 0; r < arr.length; r++){
				int max = arr[r][c - 1];
				if(r + 1 < arr.length)
				    max = Math.max(arr[r][c - 1], arr[r + 1][c - 1]);
				if(r - 1 >= 0)
				    max = Math.max(arr[r][c - 1], arr[r - 1][c - 1]);
				arr[r][c] = Math.min(max, arr[r][c]);
			}
		}
		for(int i = 0; i < arr.length; i++)
			res = Math.max(res, arr[i][arr[0].length - 1]);
		return res;
	}
}

// followup: large array
// read column by column each time
// if memory is still not enough, then read cube by cude
// cause each time we actually only need to caulate min(max(dp[r-1][c-1], dp[r][c-1], dp[r+1][c-1]), grid[r][c])
// and it's like a rolling rectangle