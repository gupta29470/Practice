/*
unionIntersection function:

	-> create two hash set union set and intersection set for stroing union and
	intersection 
	-> put all elements of array1 in union set
	-> traversing array2 
		-> if unique element then put in union set
		-> if duplicate element put in intersection set
*/

import java.util.*;

class UnionIntersection {

    public static void main(String[] args) {

        int array1[] = {1, 3, 4, 5, 7};
        int array2[] = {2, 3, 5, 6};

        unionIntersection(array1, array2);
    }

    public static void unionIntersection(int array1[], int array2[]) {

        Set<Integer> unionSet = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();
		
		// put all elements of array1 in union set
        for (int index = 0; index < array1.length; index++) {
            unionSet.add(array1[index]);
        }
		
		// traversing array2 
        for (int index = 0; index < array2.length; index++) {
			// if unique element then put in union set
            if (!unionSet.contains(array2[index])) {
                unionSet.add(array2[index]);
            } 
			// if duplicate element put in intersection set
			else {
                intersectionSet.add(array2[index]);
            }
        }
        System.out.println(unionSet);
        System.out.println(intersectionSet);
    }

}
// Time --> O(n + m) where n and m are length of two arrays
// Space --> O(n + m) 


/*
unionIntersection function
	-> create two hash set union set and intersection set for stroing union and
	intersection
	-> create index1 and index2 for traversing array
	-> while index1 < array1.length and index2 < array2.length
		-> if array1 element is smaller add in union set and increment
           index1
		-> if array2 element is smaller add in union set and increment
           index1
		-> if array1 and array2 element are same add in union set and 
           intersection se increment index1 and index2
		-> put remaining element for array1 in union set and increment
           index1
		-> put remaining element for array2 in union set and increment
           index2
*/

import java.util.*;

class UnionIntersection {

    public static void main(String[] args) {

        int array1[] = {1, 3, 4, 5, 7};
        int array2[] = {2, 3, 5, 6};

        unionIntersection(array1, array2);
    }

    public static void unionIntersection(int array1[], int array2[]) {

        // for stroing union and intersection
        Set<Integer> unionSet = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        // for traversing array
        int index1 = 0, index2 = 0;
		
        while (index1 < array1.length && index2 < array2.length) {
            
            // if array1 element is smaller add in union set and increment
            // index1
            if (array1[index1] < array2[index2]) {
                unionSet.add(array1[index1]);
                index1++;
            } 
            
            // if array2 element is smaller add in union set and increment
            // index2
            else if (array1[index1] > array2[index2]) {
                unionSet.add(array2[index2]);
                index2++;
            } 
            
            // if array1 and array2 element are same add in union set and 
            // intersection se increment index1 and index2
            else {
                unionSet.add(array1[index1]);
                unionSet.add(array2[index2]);
                intersectionSet.add(array2[index2]);
                index1++;
                index2++;
            }
        }

        // remaining element for array1
        while (index1 < array1.length) {
            unionSet.add(array1[index1]);
            index1++;
        }
        // or remaining element for array2
        while (index2 < array2.length) {
            unionSet.add(array2[index2]);
            index2++;
        }
        System.out.println(unionSet);
        System.out.println(intersectionSet);
    }

}




