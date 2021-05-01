/*
Given an array arr[] of n integers, construct a Product Array prod[] 
(of same size) such that prod[i] is equal to the product of all the elements 
of arr[] except arr[i]. Solve it without division operator in O(n) time.
Example : 

Input: arr[]  = {10, 3, 5, 6, 2}
Output: prod[]  = {180, 600, 360, 300, 900}
3 * 5 * 6 * 2 product of other array 
elements except 10 is 180
10 * 5 * 6 * 2 product of other array 
elements except 3 is 600
10 * 3 * 6 * 2 product of other array 
elements except 5 is 360
10 * 3 * 5 * 2 product of other array 
elements except 6 is 300
10 * 3 * 6 * 5 product of other array 
elements except 2 is 900
*/


/*
Using two loops and one variable to keep track of index which we want to skip
*/

class ProductArrayPuzzle{
    public static void main(String[] args) {
        
        int array[] = {10, 3, 5, 6, 2};
        
        productArrayPuzzle(array);
    }
    
    public static void productArrayPuzzle(int array[]){
        int product[] = new int[array.length];
        int except = 0;
        for (int index1 = 0; index1 < array.length; index1++){
            int currentProduct = 1;
            for (int index2 = 0; index2 < array.length; index2++){
                if (except != index2){
                    currentProduct = currentProduct * array[index2];
                }
            }
            except++;
            product[index1] = currentProduct;
        }
        for (int data : product){
            System.out.print(data + " ");
        }
    }
} 
// Time --> O(n^2)     Space --> O(n) (output array)



/*
Loop the array and store product of all array elements in product variable.
Again loop and divide the product with current element and quotient will be 
product array puzzle for current element .
*/
class ProductArrayPuzzle{
    public static void main(String[] args) {
        
        int array[] = {10, 3, 5, 6, 2};
        
        productArrayPuzzle(array);
    }
    
    public static void productArrayPuzzle(int array[]){
        int product = 1;
        int productArray[] = new int[array.length];
        
        for (int data : array){
            product = product * data;
        }
        
        for (int index = 0; index < array.length; index++){
            productArray[index] = product / array[index];
        }
        
        for (int data : productArray){
            System.out.print(data + " ");
        }
    }
}
// Time --> O(2n)     Space --> O(n) (output array)



/*
Approach: Create two extra space, i.e. two extra arrays to store the product of 
all the array elements from start, up to that index and another array to store 
the product of all the array elements from the end of the array to that index. 

To get the product excluding that index, multiply the prefix product up to index 
i-1 with the suffix product up to index i+1.


Algorithm: 

1. Create two array prefix and suffix of length n, i.e length of the original 
array, initilize prefix[0] = first element of input array and 
suffix[n-1] = last element of input array and also another array to store 
the product.


2. Traverse the array from second index to end.
For every index i update prefix[i] as prefix[i] = prefix[i-1] * array[i], i.e 
store the product upto i-1 index from the start of array.

3. Traverse the array from second last index to start.
For every index i update suffix[i] as suffix[i] = suffix[i+1] * array[i], 
i.e store the product upto i+1 index from the end of array

4. Traverse the array from start to end.
	-> for first element the product array puzzle will be suffix[1] 
	-> for last element the product array puzzle will be prefix[n - 2]
For every index i the output will be prefix[i - 1] * suffix[i + 1], the product of 
the array element except that element.
*/

class ProductArrayPuzzle{
    public static void main(String[] args) {
        
        int array[] = {10, 3, 5, 6, 2};
        
        productArrayPuzzle(array);
    }
    
    public static void productArrayPuzzle(int array[]){
        
        int size = array.length;
        int prefixProduct[] = new int[size];
        int suffixProduct[] = new int[size];
        int product[] = new int[size];
        
        prefixProduct[0] = array[0];
        suffixProduct[size - 1] = array[size - 1];
        
        for (int index = 1; index < size; index++){
            prefixProduct[index] = prefixProduct[index - 1] * array[index];
        }
        for (int index = size - 2; index >= 0; index--){
            suffixProduct[index] = suffixProduct[index + 1] * array[index];
        }
        
        product[0] = suffixProduct[1];
        product[size - 1] = prefixProduct[size - 2];
        for (int index = 1; index < size - 1; index++){
            product[index] = prefixProduct[index - 1] * suffixProduct[index + 1];
        }
        
        for (int data : product){
            System.out.print(data + " ");
        }
    }
}

// Time --> O(3n)  Space --> O(3n) (output array)



/*
Approach: In the previous solution, two extra arrays were created to store the 
prefix and suffix, in this solution store the prefix and suffix product in the 
output array (or product array) itself. Thus reducing the space required.

Algorithm:
1. Create an output array of length n, i.e length of the original 
array, initilize prefix[0] = first element of input array

2. Create variable product and store last element of array to keep track of 
suffix product

3. Product Array Puzzle of last element is its previous prefix 
prodcut.(for last element - all left side product)

4. Traverse second last to start the product array puzzle will be product * 
output[index - 1] and product will be update to = prodcut * array[index]
*/
class ProductArrayPuzzle{
    public static void main(String[] args) {
        
        int array[] = {10, 3, 5, 6, 2};
        
        productArrayPuzzle(array);
    }
    
    public static void productArrayPuzzle(int array[]){
        
        int size = array.length;
        int productArray[] = new int[size];
        int product = 1;
    
        productArray[0] = array[0];
        for (int index = 1; index < size; index++){
            productArray[index] = productArray[index - 1] * array[index];
        }
        
        productArray[size - 1] = productArray[size - 2];
        product = array[size - 1];

        for (int index = size - 2; index > 0; index--){
             productArray[index] = productArray[index - 1] * product;
             product = product * array[index];
        }
        
        productArray[0] = product; 
                
        for (int data : productArray){
            System.out.print(data + " ");
        }
    }
}

// Time --> O(2n)    Space --> O(n) (output array)