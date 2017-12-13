class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        if(k >= len / 2){
            int res = 0;
            for(int i = 1; i < len; i++)
                res += Math.max(0, prices[i] - prices[i - 1]);
            return res;
        }
        
        int[][] dp = new int[k + 1][len];
        // dp[i][j] - max profit until prices[j] when there are i transactions
        // dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][jj] + prices[j] - prices[jj]) for jj in [0, j - 1]
        for(int i = 1; i <= k; i++){
            int localMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < len; j++){
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
}