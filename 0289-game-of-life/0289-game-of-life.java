class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);
            
                if (board[i][j] == 1) { 
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; 
                    }
                    
                } else { // abhi dead hai
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead tha, live ho raha hai
                    }
                    // else: dead hi rahega (state 0 hi rahega)
                }
            }
        }
        
        // Step 2: Final pass — encoded states ko decode karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // live tha, ab dead
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // dead tha, ab live
                }
                // 0 aur 1 already sahi hain, unhe touch nahi karna
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        // 8 directions: up, down, left, right, 4 diagonals
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        
        for (int d = 0; d < 8; d++) {
            int newRow = row + dx[d];
            int newCol = col + dy[d];
            
            // Boundary check
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                // 1 (abhi live) ya 2 (tha live, ab dead ho raha) dono count honge
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                    count++;
                }
            }
        }
        
        return count;
    }
}