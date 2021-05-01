import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int a[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int shell = sc.nextInt();
        int rotate = sc.nextInt();
        shellRotate(a, shell, rotate);
        display(a);

    }

    // All in one function
    public static void shellRotate(int a[][], int shell, int rotate) {
        int oneD[] = fill1D(a, shell);
        rotate(oneD, rotate);
        fill2D(a, oneD, shell);
    }

    // making 2D array to 1D w.r.t shell
    public static int[] fill1D(int a[][], int shell) {
        int minrow = shell - 1;
        int mincol = shell - 1;
        int maxrow = a.length - shell;
        int maxcol = a[0].length - shell;

        int size = 2 * (maxrow - minrow + maxcol - mincol);
        int oneD[] = new int[size];
        int index = 0;
        // left wall
        for (int i = minrow; i <= maxrow; i++) {
            oneD[index] = a[i][mincol];
            index++;
        }

        // below wall
        for (int i = mincol + 1; i <= maxcol; i++) {
            oneD[index] = a[maxrow][i];
            index++;
        }

        // right wall
        for (int i = maxrow - 1; i >= minrow; i--) {
            oneD[index] = a[i][maxcol];
            index++;
        }

        // top wall
        for (int i = maxcol - 1; i >= mincol + 1; i--) {
            oneD[index] = a[minrow][i];
            index++;
        }
        return oneD;
    }

    // Rotating 1D array
    public static void reverse(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int a[], int rot) {
        rot = rot % a.length;
        if (rot < 0) {
            rot = rot + a.length;
        }
        reverse(a, 0, a.length - rot - 1);
        reverse(a, a.length - rot, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    // Putting rotated shell to 2d array 
    public static void fill2D(int a[][], int oneD[], int shell) {
        int minrow = shell - 1;
        int mincol = shell - 1;
        int maxrow = a.length - shell;
        int maxcol = a[0].length - shell;

        int index = 0;
        // left wall
        for (int i = minrow; i <= maxrow; i++) {
            a[i][mincol] = oneD[index];
            index++;
        }

        // below wall
        for (int i = mincol + 1; i <= maxcol; i++) {
            a[maxrow][i] = oneD[index];
            index++;
        }

        // right wall
        for (int i = maxrow - 1; i >= minrow; i--) {
            a[i][maxcol] = oneD[index];
            index++;
        }

        // top wall
        for (int i = maxcol - 1; i >= mincol + 1; i--) {
            a[minrow][i] = oneD[index];
            index++;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
