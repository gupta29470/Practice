public class Solution {
    public int solve(ArrayList<String> A) {
        int size = A.size();
        double temp[] = new double[size];
        int ind = 0;
        for (String ele : A){
            temp[ind] = Double.parseDouble(ele); 
            ind ++;
        }
        
        double first = temp[0], second = temp[1], third = temp[2];
        
        for (int index = 3; index < size + 1; index++){
            double sum = first + second + third;
            
            if (sum > 1 && sum < 2){
                return 1;
            }
            if (index >= size){
                break;
            }
            
            double curr = temp[index];
            double check = sum > 2? Math.max(first, Math.max(second, third)) :
                           sum <= 1? Math.min(first, Math.min(second, third)) : -1;
            
            if (check == first) first = curr;
            else if (check == second) second = curr;
            else if (check == third) third = curr;
        }
        return 0;
    }
}

Time --> O(n)