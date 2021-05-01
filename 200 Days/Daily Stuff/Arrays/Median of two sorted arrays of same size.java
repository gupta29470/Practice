/*
create a merge array of size(m + n -> size of two given arrays).
fill merge array in sorted manner.
as merge array length is even so return 
(merge[middle - 1] + merge[middle]) / 2 
*/

class MedianOfSortedArraysSameSize {

    public static void main(String[] args) {

        int A[] = {1, 12, 15, 26, 38};
        int B[] = {2, 13, 17, 30, 45};

        System.out.println(medianSameSize(A, B));
    }

    public static int medianSameSize(int A[], int B[]) {
        int merge[] = new int[A.length + B.length];

        int index = 0, index1 = 0, index2 = 0;

        while (index1 < A.length && index2 < B.length) {
            if (A[index1] <= B[index2]) {
                merge[index++] = A[index1++];
            } else {
                merge[index++] = B[index2++];
            }
        }

        int middle = (merge.length) / 2;

        int median = (merge[middle - 1] + merge[middle]) / 2;

        return median;

    }

}
/* Time --> O(n + m)   Space --> O(n + m), where n and m are sizes
of two given arrays.
*/



/*
Method 1 (Simply count while Merging) 
Use the merge procedure of merge sort. Keep track of count while 
comparing elements of two arrays. If count becomes n(For 2n elements), 
we have reached the median. Take the average of the elements at indexes 
n-1 and n in the merged array. See the below implementation. 

medianSameSize function:
	-> as arrays length is same so instead of traversing 2n we will traver 
	n and once we will reached n we found median
	
	-> initialize index1 for array1 and array2 for index2 and count 
	for traversing n-1
	
	-> while  count <= n
		-> if all the elements in array2 is greater than all 
		elements in array 1 return last element of array1 as median1
		and first element of array2 as median2
		
		-> if all the elements in array 1 is greater than all 
		elements in array 2 return last element of array2 as median1
		and first element of array1 as median2
		
		-> if current element of array 1 is less than equal to 
		current element of array2 then store current median in
		median 1 and median 2 will be current element of array1 and
		increment index1
		
		-> else if current element of array 2 is less than equal to 
		current element of array 1 then store current median in
		median 1 and median 2 will be current element of array 2 and
		increment index2
		
	-> return (median1 + median2) / 2
*/

class MedianOfSortedArraysSameSize {

    public static void main(String[] args) {

        int A[] = {1, 12, 15, 26, 38};
        int B[] = {2, 13, 17, 30, 45};

        System.out.println(medianSameSize(A, B));
    }

    public static int medianSameSize(int A[], int B[]) {
       
        int index1 = 0, index2 = 0, median1 = -1, median2 = -1, count = 0;
        
        int len = A.length;
        
        while (count <= len){
            
            /*Below is to handle case where all elements of ar1[] are 
          smaller than smallest(or first) element of ar2[]*/
			if (index1 == len){
                median1 = median2;
                median2 = B[0];
                break;
            }
            
            /*Below is to handle case where all elements of ar2[] are 
          smaller than smallest(or first) element of ar1[]*/
			else if (index2 == len){
                median1 = median2;
                median2 = A[0];
                break;
            }
            
            /*Below is to handle case where all elements of ar2[] are 
          smaller than smallest(or first) element of ar1[]*/
			if (A[index1] <= B[index2]){
                median1 = median2; /* Store the prev median */
                median2 = A[index1];
                index1++;
            }
            
            else{
                median1 = median2; /* Store the prev median */
                median2 = B[index2];
                index2++;
            }
            count+= 1;
        }
        return (median1 + median2) / 2;
    }

}
// Time --> O(n)  Space --> O(1)
