class SpiralTraversal {

    public static void main(String[] args) throws Exception {
        int array[][] = {{1, 2, 3, 4},{5, 6, 7, 8}, {9, 10, 11, 12},
        {13, 14, 15, 16}};

        spiralTraversal(array);
    }
    
    public static void spiralTraversal(int array[][]){
        int row = 0, col = 0, maxRow = array.length - 1, 
                maxCol = array[0].length - 1;
        
        while (row <= maxRow && col <= maxCol){
            for (int index = col; index <= maxCol; index++){
                System.out.print(array[row][index]+" ");
            }
            row++;
            
            for (int index = row; index <= maxRow; index++){
                System.out.print(array[index][maxCol]+" ");
            }
            maxCol--;
            
            if (row <= maxRow){
                for (int index = maxCol; index >= col; index--){
                    System.out.print(array[maxRow][index]+" ");
                }
            }
            maxRow--;
            
            if (col <= maxCol){
                for (int index = maxRow; index >= row; index--){
                    System.out.print(array[index][col]+" ");
                }
            }
            col++;
        }
    }
}
