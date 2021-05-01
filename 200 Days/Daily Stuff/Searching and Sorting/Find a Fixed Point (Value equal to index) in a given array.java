class FixedPoint{
    public static void main(String[] args) {
        
        int array[] = {-10, -5, 0, 3, 7};
        System.out.println(fixedPoint(array));
    }
    
    public static int fixedPoint(int array[]){
        for (int index = 0; index < array.length; index++){
            if (array[index] == index){
                return index;
            }
        }
        return -1;
    }
}


/*
Using Binary Search assume key as mid... and mid changes every time
*/
class FixedPoint{
    public static void main(String[] args) {
        
        int array[] = {-10, -5, 0, 3, 7};
        System.out.println(fixedPoint(array));
    }
    
    public static int fixedPoint(int array[]){
        int low = 0, high = array.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (mid == array[mid]){
                return mid;
            }
            else if (mid > array[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}