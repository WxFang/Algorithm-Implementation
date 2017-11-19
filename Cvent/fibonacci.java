class Solution{

	// recursion
	// time O(2^N) space O(N) considering function call stack size
	public static int fibonacci(int n){
		if(n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}


	// DP
	// time O(N) space O(N)
	public static int fibonacci(int n){
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++){
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	// DP
	// optimize space
	// time O(N) space O(1)     
    public static int fibonacci(int n){
		int[] dp = new int[n + 1];
		int a = 0, b = 1;
		for(int i = 2; i <= n; i++){
		    int temp = a + b;
		    a = b;
		    b = temp;
		}
		return b;
	}
}