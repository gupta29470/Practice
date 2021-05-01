public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (A == 0){
            return res;
        }
        
        for (int index1 = 0; index1 < A; index1++){
            ArrayList<Integer> temp = new ArrayList<>();
            
            for (int index2 = 0; index2 < index1 + 1; index2++){
                if (index2 == 0 || index1 == index2){
                    temp.add(1);
                }
                else{
                    temp.add(res.get(index1 - 1).get(index2 - 1) + res.get(index1 - 1).get(index2));
                }
            }
            res.add(temp);
        }
    return res;
  }
}



import java.util.*;

public class vit {
    
    public static void main(String[] args) throws Exception {
        int n = 5;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (n == 0) {
            System.out.println(res);
        }
        for (int index1 = 0; index1 < n; index1++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            for (int index2 = 0; index2 < index1 + 1; index2++) {
                if (index2 == 0 || index2 == index1) {
                    temp.add(1);
                } else {
                    temp.add(res.get(index1 - 1).get(index2 - 1)
                            + res.get(index1 - 1).get(index2));
                }
            }
            res.add(temp);
        }
        System.out.println(res);
    }
    
}
