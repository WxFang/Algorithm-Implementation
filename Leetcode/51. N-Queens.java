class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(res, n, new ArrayList<>(), 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return res;
    }
    
    private void helper(List<List<String>> res, int n, List<String> board, int row, boolean[] cols, boolean[] dial1, boolean[] dial2){
        if(row == n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int i = 0; i < n; i++){
            int d1 = row + i, d2 = row - i + n;
            if(cols[i] || dial1[d1] || dial2[d2]) continue;
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[i] = 'Q';
            board.add(new String(c));
            cols[i] = true;
            dial1[d1] = true;
            dial2[d2] = true;
            helper(res, n, board, row + 1, cols, dial1, dial2);
            board.remove(board.size() - 1);
            cols[i] = false;
            dial1[d1] = false;
            dial2[d2] = false;
        }
    }
}