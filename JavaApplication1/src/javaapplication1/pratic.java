/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;
import java.lang.*;

public class pratic {

    public static void main(String args[]) {
        int a[] = {900, 940, 950, 1100, 1500, 1800};
        int d[] = {910, 1200, 1120, 1130, 1900, 2000};
        Arrays.sort(a);
        Arrays.sort(d);
        int max_platform = 1, result = 1, i = 1, j = 0, n = a.length;
        while (i < n && j < n) {
            if (a[i] <= d[j]) {
                max_platform++;
                i++;
            } else if (a[i] > d[j]) {
                max_platform--;
                j++;
            }
            if (max_platform > result) {
                result = max_platform;
            }
        }
        System.out.println(result);
    }

}
