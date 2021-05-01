/*
The idea is to compare the sum of each stack, if they are not same, remove the top element 
of the stack having the maximum sum.
Algorithm for solving this problem: 

Find the sum of all elements of in individual stacks.
If the sum of all three stacks is the same, then this is the maximum sum.
Else remove the top element of the stack having the maximum sum among three of stacks. 
Repeat step 1 and step 2.
*/

public class prat {

    public static void main(String[] args) {
        int stack1[] = {3, 2, 1, 1, 1};
        int stack2[] = {4, 3, 2};
        int stack3[] = {1, 1, 4, 1};
        
        System.out.println(maxSum(stack1, stack2, stack3));

    }

    public static int maxSum(int stack1[], int stack2[], int stack3[]) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Finding the initial sum of stack1.
        for (int data : stack1) {
            sum1 += data > 0 ? data : 0;
        }

        // Finding the initial sum of stack2.
        for (int data : stack2) {
            sum2 += data > 0 ? data : 0;
        }

        // Finding the initial sum of stack3.
        for (int data : stack3) {
            sum3 += data > 0 ? data : 0;
        }

        if (sum1 == sum2 && sum2 == sum3) {
            return sum1;
        }
        
        // As given in question, first element is top
      // of stack..
        int top1 = 0, top2 = 0, top3 = 0;

        while (true) {
            
            // If any stack is empty
            if (top1 == stack1.length || top2 == stack2.length || top3 == stack3.length) {
                return 0;
            }

            // If sum of all three stack are equal.
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            // Finding the stack with maximum sum and
          // removing its top element.
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stack1[top1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stack2[top2++];
            } else {
                sum3 -= stack3[top3++];
            }
        }
    }
}

// Time --> O(n1 + n2 + n3)
