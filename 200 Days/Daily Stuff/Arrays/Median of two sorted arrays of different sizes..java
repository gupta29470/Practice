/*
create a merge array of size(m + n -> size of two given arrays).
fill merge array in sorted manner.
if merge array length is odd then return merge[middle] : 
else if merge array length is even then return 
(merge[middle - 1] + merge[middle]) / 2 
*/

class MedianOfSortedArraysDifferentSize {

    public static void main(String[] args) {

        int A[] = {1, 3, 8, 9, 15};
        int B[] = {7, 11, 18, 19, 21, 25};

        System.out.println(medianDifferentSize(A, B));
    }

    public static double medianDifferentSize(int A[], int B[]) {

        int len1 = A.length;
        int len2 = B.length;
        
        int merge[] = new int[len1 + len2];
        int index1 = 0, index2 = 0, index = 0;
        
        while (index1 < len1 && index2 < len2){
            
            if (A[index1] <= B[index2]){
                merge[index++] = A[index1++];
            }
            else{
                merge[index++] = B[index2++];
            }
        }
        
        while (index1 < len1){
            merge[index++] = A[index1++];
        }
        
        while (index2 < len2){
            merge[index++] = B[index2++];
        }
        
        for (int data : merge){
            System.out.print(data + " ");
        }
        System.out.println("");
        
        int middle = merge.length / 2;
        
        System.out.println(middle);
        
        if (merge.length % 2 == 0){
            double median = (merge[middle - 1] + merge[middle]) / 2;
            return median;
        }
        else{
            double median = merge[middle];
            return median;
        }
    }

}
/* Time --> O(n + m)   Space --> O(n + m), where n and m are sizes
of two given arrays.
*/



/*
*********************** USING BINARY SEARCH ****************************
We divide the array in two halfs i.e both halfs contains equal amount
of array 1 and array 2 elements
Eg : {a1, a2,    and  {a3, a4, a5, 
	b1, b2, b3}  		b4, b5}
	
	-> if a2 <= b4 and b3 <= a3 means 
	1. left max A is less than equals to right min B and
	2. left max B is less than equals to right min A then
	
	if both array size is even then:
	return max(a2, b3) + min(a3, b4) / 2
	
	if both array size is odd then:
	return max(a2, a3)
	
	
	-> else if a2 > b4 then we move more on right side we have to shift 
	left
	
	-> else if b3 > a3 then we move more on left we have to shift 
	right
	
*/

package com.interview.binarysearch;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */
public class MedianOfTwoSortedArrayOfDifferentLength {

    public double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        MedianOfTwoSortedArrayOfDifferentLength mm = new MedianOfTwoSortedArrayOfDifferentLength();
        mm.findMedianSortedArrays(x, y);
    }
}
// Time --> O(logn)   Space --> O(1)


// Same as above code
class MedianOfSortedArraysDifferentSize {

    public static void main(String[] args) {

        int A[] = {1, 3, 8, 9, 15};
        int B[] = {7, 11, 18, 19, 21, 25};

        System.out.println(medianDifferentSize(A, B));
    }

    public static double medianDifferentSize(int A[], int B[]) {

        int len1 = A.length;
        int len2 = B.length;
        int low = 0; 
        int high = len1;
        
        while (low <= high){
            int partitionA = (low + high) / 2;
            int partitionB = (len1 + len2 + 1) / 2 - partitionA;
            
            int maxLeftA = partitionA == 0? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = partitionA == len1? Integer.MAX_VALUE: A[partitionA];
            
            int maxLeftB = partitionB == 0? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = partitionB == len2? Integer.MAX_VALUE : B[partitionB];
            
            if (maxLeftA <= minRightB && maxLeftB <= minRightA){
                if ((len1 + len2) % 2 == 0){
                    return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                }
                else{
                    return (double) Math.max(maxLeftA, maxLeftB);
                }
            }
            else if (maxLeftA > minRightB){
                high = partitionA - 1;
            }
            else{
                low = partitionA + 1;
            }
        }
        return -1;
    }

}
