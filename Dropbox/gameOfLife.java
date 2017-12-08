/*
	Game of Life, 0 -> X, 1 -> -
	requirement: in-place
	followup:
	1. board is big, like 1Million*1Million?
	2. What if memory is not enough or over memory?
*/

public class Solution {

	// in-place
	// Time O(MN), Space O(1)
    public static void gameOfLife1(char[][] board) {
        // X: X -> X
        // -: - -> -
        // 2: - -> X
        // 3: X -> -
    public static void gameOfLife1(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int sum = 0;
                for(int r = Math.max(i - 1, 0); r <= Math.min(i + 1, board.length - 1); r++){
                    for(int c = Math.max(j - 1, 0); c <= Math.min(j + 1, board[0].length - 1); c++){
                        if(r == i && c == j) continue;
                        sum += (board[r][c] == 'X' || board[r][c] == '3') ? 1 : 0;
                    }
                }
                if(board[i][j] == 'X' && (sum > 3 || sum < 2)) board[i][j] = '3';
                else if(board[i][j] == '-' && sum == 3) board[i][j] = '2';
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '2') board[i][j] = 'X';
                else if(board[i][j] == '3') board[i][j] = '-';
            }
        }
    }
    
    // using bit if board is int array
    public void solveInplaceBit(int[][] board){
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = 0;
                // 累加上下左右及四个角还有自身的值
                for(int y = Math.max(i - 1, 0); y <= Math.min(i + 1, m - 1); y++){
                    for(int x = Math.max(j - 1, 0); x <= Math.min(j + 1, n - 1); x++){
                        // 累加bit1的值
                        lives += board[y][x] & 1;
                    }
                }
                // 如果自己是活的，周边有两个活的，lives是3
                // 如果自己是死的，周边有三个活的，lives是3
                // 如果自己是活的，周边有三个活的，lives减自己是3
                if(lives == 3 || lives - board[i][j] == 3){
                    board[i][j] |= 2;
                }
            }
        }
        // 右移就是新的值
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>>= 1;
            }
        }
	}

    /* followup: infinite board
    	if board is too large, then memory might not be enough and also the speed would be slow
    	step 1: estimate memory cost of matrix
			if we dont consider the overhead like number of dimensions and how long it can be,
			then we can have below. (Java, 24bytes array overhead, 8 bytes for actual array object)
			Base byte and size of Byte: according to 64-bit memory model (1 Byte = 8 bits)
			boolean 1, char 2, int 4
			if it is int array, all elements would be 4*M*N. So total 4*10^6*10^6 = 
			10^12 bytes -> kilobyte 1024Byte -> Megabyte 1024kB -> Gigabyte 1024MB -> Terabyte 1024GB
			-> 1TB
		step 2: save in disk and read by three lines each time
			So if machine memory is under 1TB, we can save it in the disk or database. 
			And we can read three lines at one iteration. 
			We first save the current state of middle line. Like build up a list of live cells to 
			be used in the next iteration.
			Then calculate the next state of middle line and save it to disk. 
			After that we go to next iteration and use the list saved to update the next line. 
			In this case, we only need to handle three lines, so memory size would be reduced 
			to only 10^6 = 1MB
    */


    public static void main(String[] args){
        char[][] board = {{'-', 'X', '-', '-'}, {'-', '-', 'X', '-'}, 
        {'X', '-', '-', 'X'}, {'-', '-', '-', '-'}};
        print(board);
        gameOfLife1(board);
        System.out.println("====================");
        print(board);
        
    }
    
    private static void print(char[][] board){
        for(char[] row: board){
            for(char i: row)
                System.out.print(i);
            System.out.println(" ");
        }
    }
}
