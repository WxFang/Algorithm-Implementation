class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int minPro = prices[0], maxPro = prices[prices.length - 1];
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            minPro = Math.min(minPro, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPro);
        }
        for(int i = prices.length - 2; i >= 0; i--){
            maxPro = Math.max(maxPro, prices[i]);
            right[i] = Math.max(right[i + 1], maxPro - prices[i]);
        }
        int res = 0;
        for(int i = 0; i < prices.length; i++)
            res = Math.max(res, left[i] + right[i]);
        return res;
    }
}