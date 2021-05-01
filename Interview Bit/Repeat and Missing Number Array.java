import java.util.*;
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = a.size();
        
        int max = Collections.max(a);
        int hash[] = new int[max + 1];
        for (int index = 0; index < n; index++){
            hash[a.get(index)]++;
        }
        for (int index = 0; index < max + 1; index++){
            if (hash[index] > 1){
                res.add(index);
                break;
            }
        }
        
        for (int index = 1; index < max + 1; index++){
            if (hash[index] == 0){
                res.add(index);
            }
        }
        
        return res;
    }
}







import java.util.*;
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = a.size();
        
        long sumOfN = ((long) n) * ((long) n + 1) / 2;
        long sumOfNSquare = ((long) n) * ((long) n + 1) * 
        ((long) 2 * n + 1) / 6;
        
        for (int index = 0; index < n; index++){
            sumOfN = sumOfN - (long)a.get(index);
            sumOfNSquare = sumOfNSquare - (long) a.get(index) * 
            (long) a.get(index); 
        }
        
        long sumNum = sumOfNSquare / sumOfN;
        
        int missing = (int)(sumNum + sumOfN) / 2;
        int repeated = (int) (sumNum - missing);
        
        res.add(repeated);
        res.add(missing);
        return res;
    }
}
