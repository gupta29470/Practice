/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Aakash
 */
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.IntStream;
import javafx.util.Pair;

public class vita {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = {
            {15, 9, 84, 33},
            {46, 44, 33, 70},
            {56, 94, 24, 42},
            {52, 64, 87, 62}
        };
        int m = 4, n = 4;
        int i, row = 0, col = 0;
        int last_row = m - 1, last_col = n - 1;
        while (row <= last_row && col <= last_col) {
            for (i = col; i <= last_col; i++) {
                System.out.print(a[row][i] + " ");
            }
            row++;
            for (i = row; i <= last_row; i++) {
                System.out.print(a[i][last_col] + " ");
            }
            last_col--;
            if (row <= last_row) {
                for (i = last_col; i >= col; i--) {
                    System.out.print(a[last_row][i] + " ");
                }

            }
            last_row--;
            if (col <= last_col) {
                for (i = last_row; i >= row; i--) {
                    System.out.print(a[i][col] + " ");
                }
            }
            col++;
        }
        System.out.println("");

    }
}
