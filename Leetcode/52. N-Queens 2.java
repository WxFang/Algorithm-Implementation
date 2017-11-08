class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        helper(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return res;
    }
    
    private void helper(int n, int row, boolean[] cols, boolean[] dial1, boolean[] dial2){
        if(row == n){
            res++;
            return;
        }
        for(int i = 0; i < n; i++){
            int d1 = row + i, d2 = row - i + n;
            if(cols[i] || dial1[d1] || dial2[d2]) continue;
            cols[i] = true;
            dial1[d1] = true;
            dial2[d2] = true;
            helper(n, row + 1, cols, dial1, dial2);
            cols[i] = false;
            dial1[d1] = false;
            dial2[d2] = false;
        }
    }
}