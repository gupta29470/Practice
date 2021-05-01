class AdjacentDiffer{
    public static void main(String[] args) {
        int array[] = {4, 5, 6, 7, 6 };
		int k = 2;
        int key = 6;
        
        System.out.println(adjacent(array, key));
    }
    
    public static int adjacent(int array[], int key){
        for (int index = 0; index < array.length; index++){
            if (key == array[index]){
                return index;
            }
        }
        return -1;
    }
}


/*
The above solution can be Optimized using the fact that difference 
between all adjacent elements is at most k. 
The idea is to start comparing from the leftmost element and 
find the difference between current array element and x. 
Let this difference be ‘diff’. From the given property of array, 
we always know that x must be at-least ‘diff/k’ away, so instead of 
searching one by one, we jump ‘diff/k’.


*/
class AdjacentDiffer{
    public static void main(String[] args) {
        int array[] = {4, 5, 6, 7, 6 };
        int k = 2;
        int key = 6;
        
        System.out.println(adjacent(array, key, k));
    }
    
    public static int adjacent(int array[], int key, int k){
        int index = 0;
        
        while (index < array.length){
            if (array[index] == key){
                return index;
            }
            
            index = index + Math.max(1, Math.abs(array[index] - key) / k);
        }
        return -1;
    }
}