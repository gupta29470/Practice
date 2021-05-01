/*
Input: [2, 3, 3, 1]
->Index 0:
    Absolute value = 2
    Put a minus sign to a[2] => [2, 3, -3, 1]
-> Index 1:
    Absolute value = 3
    Put a minus sign to a[3] => [2, 3, -3, -1]
-> Index 2:
    Absolute value = 3
    As a[3] is already negative, it means 3 is a duplicate
*/


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int index = 0; index < n; index++){
            int abs = Math.abs(arr[index]);
            
            if (arr[abs] < 0){
                result.add(abs);
            }
            arr[abs] = -arr[abs];
        }
        
        if (result.size() == 0){
            result.add(-1);
            return result;
        }
        Collections.sort(result);
        return result;
    }
}
