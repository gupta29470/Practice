/*
commonElements function:
	-> create 3 variables index1, index2, index3 and initialize with 0
	fro 3 arrays
	-> while index1 < A.length and index2 < B.length and index3 < C.length
		-> if all three elements are same than print current element and
		increment index1, index2 and index3
		
		-> if A's element is less than B's and C's element than increment 
		index1
		
		-> else if B's element is less than A's and C's element than
		increment index2
		
		-> else increment index3
*/


class CommonElementsIn3SortedArrays {

    public static void main(String[] args) {

        int A[] = {1, 5, 10, 20, 40, 80};
        int B[] = {6, 7, 20, 80, 100};
        int C[] = {3, 4, 15, 20, 30, 70, 80, 120};

        commonElements(A, B, C);
    }
    
    public static void commonElements(int A[], int B[], int C[]){
        int index1 = 0, index2 = 0, index3 = 0;
        
        while (index1 < A.length && index2 < B.length && index3 < C.length){
            if (A[index1] == B[index2] && A[index1] == C[index3]){
                System.out.print(A[index1]+" ");
                index1++;
                index2++;
                index3++;
            }
            else if (A[index1] < B[index2] && A[index1] < C[index3]){
                index1++;
            }
            else if (B[index2] < A[index1] && B[index2] < C[index3]){
                index2++;
            }
            else{
                index3++;
            }
        }
    }

}
