
/*

*************************** FAIL IN SOME CASES **************************
The idea used here is simple, we check every cell. If cell has first character, 
then we one by one try all 8 directions from that cell for a match. 
Implementation is interesting though. We use two arrays x[] and y[] 
to find next move in all 8 directions.
*/

class FindWord {

    public static void main(String[] args) {

        char[][] grid = {{'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'},
        {'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K'},
        {'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E'}};

        findWord(grid, "GEEKS");
    }

    public static void findWord(char[][] grid, String word) {

        // Rows and columns length in the given grid
        int rowLen = grid.length;
        int colLen = grid[0].length;

         // For searching in all 8 direction 
        int xDirection[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int yDirection[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        int flag = 0;

        // Consider every point as starting 
        // point and search given word 
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (findWordUtil(grid, row, col, rowLen, colLen, word,
                        xDirection, yDirection)) {
                    System.out.println("Found at index : " + row + " " + col);
                    flag++;
                }
            }
        }

        if (flag == 0) {
            System.out.println("Word is not found in grid");
        }
    }

    public static boolean findWordUtil(char[][] grid, int row, int col,
            int rowLen, int colLen, String word, int xDirection[],
            int yDirection[]) {

        
        // If first character of word 
        // doesn't match with 
        // given starting point in grid. 
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        // Search word in all 8 directions 
        // starting from (row, col) 
        for (int direction = 0; direction < 8; direction++) {
            
            // Initialize starting point 
            // for current direction 
            int temp, rowDirection = row + xDirection[direction],
                    colDirection = col + yDirection[direction];

            // First character is already checked, 
            // match remaining characters
            for (temp = 1; temp < word.length(); temp++) {
                
                // If out of bound break 
                if (rowDirection >= rowLen || rowDirection < 0
                        || colDirection >= colLen || colDirection < 0) {
                    break;
                }

                // If not matched, break 
                if (grid[rowDirection][colDirection] != word.charAt(temp)) {
                    break;
                }

                // if character matched moving in same direction 
                rowDirection += xDirection[direction];
                colDirection += yDirection[direction];
            }

            // If all character matched, 
            // then value of must 
            // be equal to length of word 
            if (temp == word.length()) {
                return true;
            }
        }
        return false;
    }
}

/*
Complexity Analysis:

Time complexity: O(R*C).
All the cells will be visited and traversed in all 8 directions, 
where R and C is side of matrix so time complexity is O(R*C).
Auxiliary Space: O(1).
As no extra space is needed.
*/


/*
***************************** BEST SOLUTION *****************************
*/

class FindWord {

    public static void main(String[] args) {

        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        System.out.println(findWord(grid, "ABCCED"));
    }

    public static boolean findWord(char[][] grid, String word) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        int count = 0;
        
		// for every character in grid
        for (int row = 0; row < rowLen; row++){
            for (int col = 0; col < colLen; col++){
				
				// if first character matches then only
				// check for remaining characters
                if (grid[row][col] == word.charAt(0) && dfs(grid, row, col, 
                        rowLen, colLen, word, count)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean dfs(char grid[][], int row, int col, int rowLen,
            int colLen, String word, int count){
		
		// if count becomes of word length means found word
        if (count == word.length()){
            return true;
        }
        
		// if not match remaining character or out of bound cases
        if (row >= rowLen || row < 0 || col >= colLen || col < 0 ||
                grid[row][col] != word.charAt(count)){
            return false;
        }
		
		// mark as visited 
        char temp = grid[row][col];
        grid[row][col] = '*';
        
		// check for remaining characters in 4 direction
		// up - down - right - left
        boolean found = dfs(grid, row + 1, col, rowLen, colLen, word, 
		count + 1)
                || dfs(grid, row - 1, col, rowLen, colLen, word, count + 1)
                || dfs(grid, row, col + 1, rowLen, colLen, word, count + 1)
                || dfs(grid, row, col - 1, rowLen, colLen, word, count + 1);
        
		// while backtracking again mark as unvisited
        grid[row][col] = temp;
        
        return found;
    }

}


