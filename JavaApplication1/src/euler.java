/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aakash
 */
import java.io.*;
import java.util.*;

public class euler {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int arraySize = Integer.parseInt(br.readLine());
            String stringInput[] = br.readLine().split(" ");
            ArrayList<Integer> inputList = new ArrayList<>(arraySize);
            for (int index = 0; index < arraySize; index++) {
                inputList.add(Integer.parseInt(stringInput[index]));
            }
            finalSolution(arraySize, inputList);
        }

    }

    static void separateRemainder(ArrayList<Integer> arr, int c0, int c1, int c2, Stack<Integer> zero,
            Stack<Integer> one, Stack<Integer> two, Stack<Integer> onlyZero) {
        for (int index = 0; index < arr.size(); index++) {
            if(arr.get(index)==0){
                zero.add(arr.get(index));
                onlyZero.add(arr.get(index));
            }
            if (arr.get(index) % 3 == 0) {
                c0++;                
                zero.add(arr.get(index));
            } else if (arr.get(index) % 3 == 1) {
                c1++;
                one.add(arr.get(index));
            } else {
                c2++;
                two.add(arr.get(index));
            }
        }
        if (onlyZero.size() == arr.size()) {
            System.out.println("Yes");
            return;
        }

        if ((c0 == 0 && c1 != 0 && c2 != 0) || c0 >= (c1 + c2 + 1)) {
            System.out.println("No");
            return;
        } else {
            System.out.println("Yes");
            return;
        }
    }

    static void finalSolution(int arraySize, ArrayList<Integer> arr) {
        Stack<Integer> zero = new Stack<>();
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        Stack<Integer> onlyZero = new Stack<>();

        int c0 = 0, c1 = 0, c2 = 0;

        separateRemainder(arr, c0, c1, c2, zero, one, two, onlyZero);

    }
}
