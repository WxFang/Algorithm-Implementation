// O(N^2)
// iterate throught each row, column and cube in one loop
// three hashsets for row, column and cube
public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	
    	if(board == null || board.length == 0)
    		return false;

    	Set<Character> setRow = new HashSet<>();
    	Set<Character> setCol = new HashSet<>();
    	Set<Character> setCube = new HashSet<>();

    	for(int i = 0; i < 9; i++){
    		setRow.clear();
    		setCol.clear();
    		setCube.clear();
    		for(int j = 0; j < 9; j++){
    			if(board[i][j] != '.'){
    				if(setRow.contains(board[i][j]))
    					return false;
    				else
    					setRow.add(board[i][j]);
    			}
    			if(board[j][i] != '.'){
    				if(setCol.contains(board[j][i]))
    					return false;
    				else
    					setCol.add(board[j][i]);
    			}
    			char cube = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + (j % 3)];
    			if(cube != '.'){
    				if(setCube.contains(cube))
    					return false;
    				else
    					setCube.add(cube);
    			}
    		}
    	}

    	return true;
    }
}

// O(N^2)
// less extra space
public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	
    	if(board == null || board.length == 0)
    		return false;

    	for(int i = 0; i < 9; i++){
    		if(check(board, i, 0, i, 8) == false)
    			return false;
    		if(check(board, 0, i, 8, i) == false)
    			return false;
    	}

    	for(int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
    			if(check(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2) == false)
    				return false;
    		}
    	}

    	return true;
    }

	private boolean check(char[][] board, int x1, int y1, int x2, int y2){
		Set<Character> set = new HashSet<>();
		for(int i = x1; i <= x2; i++){
			for(int j = y1; j <= y2; j++){
				if(board[i][j] != '.'){
                    if(set.contains(board[i][j]))
					    return false;
                    else
				        set.add(board[i][j]);
                }
			}
		}
		return true;
	}
}