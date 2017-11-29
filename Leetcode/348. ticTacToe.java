// O(1)
class TicTacToe {
    private int n;
    private int[] rows;
    private int[] cols;
    private int dial1 = 0;
    private int dial2 = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if(row == col)
            dial1 += toAdd;
        if(row + col == n - 1)
            dial2 += toAdd;
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(dial1) == n || Math.abs(dial2) == n)
            return player;
        return 0;
    }

}


// O(n)
class TicTacToe {
    private int[][] board;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
        for(int[] arr: this.board)
            Arrays.fill(arr, 0);
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(checkRow(row, player) || checkCol(col, player))
            return player;
        if((row == col || row + col == n - 1) && checkDia(row, player))
            return player;
        return 0;
    }
    
    private boolean checkRow(int row, int player){
        for(int i = 0; i < n; i++)
            if(board[row][i] != player)
                return false;
        return true;
    }
    
    private boolean checkCol(int col, int player){
        for(int i = 0; i < n; i++)
            if(board[i][col] != player)
                return false;
        return true;
    }
    
    private boolean checkDia(int row, int player){
        boolean res = true;
        if(board[0][0] == player){
            for(int i = 0; i < n; i++)
                if(board[i][i] != player)
                    res = false;
            if(res == true)
                return true;
        }
        
        res = true;
        if(board[0][n - 1] == player){
            for(int i = 0; i < n; i++)
                if(board[i][n - 1 - i] != player)
                    res = false;
            if(res == true)
                return true;
        }
        
        return false;
    }
}