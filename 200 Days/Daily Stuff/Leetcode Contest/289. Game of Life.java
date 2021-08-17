class Solution {
    public void gameOfLife(int[][] board) {
        int directionX[] = {1, 1, 0, -1, -1, -1, 0, 1};
        int directionY[] = {0, 1, 1, 1, 0, -1, -1, -1};
        
        int rowLen = board.length;
        int colLen = board[0].length;
        
        for(int index1 = 0; index1 < rowLen; index1++) {
            for(int index2 = 0; index2 < colLen; index2++) {
                int livesCount = 0;
                for(int index3 = 0; index3 < 8; index3++) {
                    int _index1 = index1 + directionX[index3];
                    int _index2 = index2 + directionY[index3];
                    if(isSafeCell(_index1, _index2, rowLen, colLen) && 
                      Math.abs(board[_index1][_index2]) == 1) {
                        livesCount++;
                    }
                }
                
                if(board[index1][index2] == 0 && livesCount == 3) {
                    board[index1][index2] = 2;
                }
                if(board[index1][index2] == 1 && (livesCount < 2 || livesCount > 3)) {
                    board[index1][index2] = -1;
                }
            }
        }
        
        for(int index1 = 0; index1 < rowLen; index1++) {
            for(int index2 = 0; index2 < colLen; index2++) {
                if(board[index1][index2] > 0) {
                    board[index1][index2] = 1;
                }
                else {
                    board[index1][index2] = 0;
                }
            }
        }
    }
    
    public boolean isSafeCell(int index1, int index2, int rowLen, int colLen) {
        return ((index1 >= 0) && (index2 >= 0) && (index1 < rowLen) && (index2 < colLen));
    }
}
