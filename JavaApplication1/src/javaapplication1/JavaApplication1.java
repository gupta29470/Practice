/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;
import java.io.*;

public class JavaApplication1 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(5);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(3);
        b.add(4);
        arr.add(a);
        arr.add(b);
        System.out.println(arr);
        int n=arr.get(0).get(0);
        arr.get(0).set(0, arr.get(1).get(1));;
        System.out.println(arr);
        arr.get(1).set(1, n);;
        System.out.println(arr);
        for(int i=arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i)+" ");
        }
        Collections.rotate(arr, 2);
       
        
        System.out.println("");
        System.out.println(a);
        // Collections.rotate(a, 2);
         System.out.println(a);
    }
}
//1 4 6 2 3 8 7 5
