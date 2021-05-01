import java.util.*;

public class print_diagonal_element {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int a[][] = new int[row][col];
        int b[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==j){
                    System.out.print(a[i][j]+" ");
                }
            }
            
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i+j)==col-1){
                    System.out.print(a[i][j]+" ");
                }
            }
            
        }
		}
		}
