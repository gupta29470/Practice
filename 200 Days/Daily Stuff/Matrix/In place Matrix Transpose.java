class MatrixTranspose {

    public static void main(String[] args) {

        int mat[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        matrixTranspose(mat);
    }

    public static void matrixTranspose(int matrix[][]) {
        int rows = matrix.length;
        int column = matrix[0].length;

        for (int index1 = 0; index1 < rows; index1++) {
            for (int index2 = index1; index2 < column; index2++) {
                swap(matrix, index1, index2);
            }
        }

        for (int index1 = 0; index1 < rows; index1++) {
            for (int index2 = 0; index2 < column; index2++) {
                System.out.print(matrix[index1][index2] + " ");
            }
            System.out.println("");
        }
    }

    public static void swap(int matrix[][], int index1, int index2) {
        int temp = matrix[index1][index2];
        matrix[index1][index2] = matrix[index2][index1];
        matrix[index2][index1] = temp;
    }
}
