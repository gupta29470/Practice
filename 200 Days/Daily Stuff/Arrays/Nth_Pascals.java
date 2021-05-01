import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int index = 1; index <= n; index++){
            arr.add(arr.get(index - 1) * (n - index + 1) / index);
        }
        System.out.println(arr);
    }
}


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (numRows == 0){
            return res;
        }
        
        for (int index1 = 0;  index1 < numRows; index1++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            for (int index2 = 0; index2 < index1 + 1; index2++){
                if (index2 == 0 || index1 == index2){
                    temp.add(1);
                }
                else{
                    temp.add(res.get(index1 - 1).get(index2 - 1) + 
                            (res.get(index1 - 1).get(index2)));
                }
            }
            res.add(temp);
        }
        return res;
    }
}