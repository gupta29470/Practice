class FindWord {

    public static void main(String[] args) {

        int ar[] = {1, 3, 2, 6, 1, 2};
        int n = 6, k = 3;

        System.out.println(divisibleSumPairs(n, k, ar));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int[] bucket = new int[k];
        int count = 0;
        for (int value : ar) {
            int modValue = value % k;

            count += bucket[(k - modValue) % k]; // adds # of elements in complement bucket

            bucket[modValue]++;                  // saves in bucket

        }
        return count;
    }

}

/*
Sample Bucket placement
For the following sample input

6 3
1 3 2 6 1 2
We have

Bucket   Integers    Count
------   --------    -----
  0        3, 6        2
  1        1, 1        2
  2        2, 2        2
*/