/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Arrays;

public class foss {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = { 5,9,12,13,4};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    static void sort(int a[]) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {//i start from last subtree i==last parent{
            heapify(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }

    }

    static void heapify(int[] a, int n, int i) {
        int largest = i;// root element
        int left = 2 * i + 1;// left child
        int right = 2 * i + 2;// right child

        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            System.out.println(largest);
            heapify(a, i, largest);
        }
    }

}
