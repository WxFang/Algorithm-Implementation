// specific case
// greedy
public class Solution {

    public static int solution(double[] arr, double target){
        int res = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            res += target / arr[i];
            target %= arr[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        double[] arr = {0.01, 0.05, 0.10, 0.25};
        System.out.println(solution(arr, 1.37));
    }
}

// normal case
// dp O(MN)
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++)
            for(int j = coins[i]; j <= amount; j++)
                if(dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
    }
}