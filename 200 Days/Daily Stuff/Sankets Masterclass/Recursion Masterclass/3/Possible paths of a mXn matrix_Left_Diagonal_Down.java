/*
Count all possible paths from top left to bottom right of a mXn matrix.
You have to only move in two directions: Left Diagonal and Down
*/
public class Practice {
    static int totalWays = 0;
    public static void main(String[] args) {
        int row = 3, column = 3, index1 = 0, index2 = 0;
        String outputPath = "";
        
        mazePath(index1, index2, row, column, outputPath);
        
        System.out.println(totalWays);
    }
    
    public static void mazePath(int index1, int index2, int row, int column, 
            String outputPath){
        
        // base cases
        if (index1 == row - 1 && index2 == column - 1){
            // we reach to destination
            totalWays++;
            System.out.println("[" + outputPath + "]");
            return;
        }
        
        if (index1 >= row || index2 >= column){
            return;
        }
      
        // move right
        mazePath(index1, index2 + 1, row, column, outputPath + "Right ");
        
        // move diagonal
        mazePath(index1 + 1, index2 + 1, row, column, outputPath + "Diagonal ");
        
        // move down
        mazePath(index1 + 1, index2, row, column, outputPath + "Down ");
    }

}
