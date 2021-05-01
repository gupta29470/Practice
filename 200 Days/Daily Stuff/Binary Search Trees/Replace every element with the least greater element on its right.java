/*
************************* BRUTE FORCE ****************************
Uisng two loops we can convert an array to next greater element on its right array
1. 1st loop is current element
2. create int nextGreater = Integer.MAX_VALUE to find next greater element 
for current element
3. 2nd loop will traverse array on right side of current element
4. if right side element is greater than current and right side element is less 
than nextGreater variable than nextGreater = right side element
5. out of 2nd loop check if nextGreater = Integer.MAX_VALUE than replace current 
element with - 1, else replace current element with nextGreater.
*/

public class vit {

    static int count = 0;

    public static void main(String[] args) {
        int array[] = {17, 18, 5, 4, 6, 1};

        nextGreaterOnRight(array);
    }

    public static void nextGreaterOnRight(int[] array) {

        for (int index1 = 0; index1 < array.length; index1++) {
            int nextGreater = Integer.MAX_VALUE;
            for (int index2 = index1 + 1; index2 < array.length; index2++) {
                if (array[index1] < array[index2] && array[index2] < nextGreater) {
                    nextGreater = array[index2];
                }
            }

            if (nextGreater == Integer.MAX_VALUE) {
                array[index1] = -1;
            } else {
                array[index1] = nextGreater;
            }
        }

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

}

// Time --> O(n^2)  Space O(1)




/*
************************* Using BST ******************************
A tricky solution would be to use Binary Search Trees. We start scanning the array 
from right to left and insert each element into the BST. For each inserted element, 
we replace it in the array by its inorder successor in BST. If the element 
inserted is the maximum so far (i.e. its inorder successor doesn’t exist), 
we replace it by -1.

1. create global root and successor of node type
2. replace function:
	-> traverse array from right because we have to find next greater on right
	so it is important to insert right elements in BST
	-> initialize successor = null
	-> inserting current element using insert function
	-> insert function:
		-> if root is null then assign current element as root and return
		-> if current element is less than root than store root in successor and
		move left
		-> if current element is greater than root than move right
	-> if successor is null then update current element with -1
	-> if successor is not null then update current element with successor.data
	-> print array
*/

// Java program to replace every element with 
// the least greater element on its right
import java.io.*;
 
class BinarySearchTree{
     
// A binary Tree node
class Node
{
    int data;
    Node left, right;
 
    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
 
// Root of BST
static Node root;
static Node succ;
 
// Constructor
BinarySearchTree()
{
    root = null;
    succ = null;
}
 
// A utility function to insert a new node with
// given data in BST and find its successor 
Node insert(Node node, int data)
{
     
    // If the tree is empty, return a new node 
    if (node == null)
    {
        node = new Node(data);
    }
 
    // If key is smaller than root's key,
    // go to left subtree and set successor
    // as current node
    if (data < node.data) 
    {
        succ = node;
        node.left = insert(node.left, data);
    }
 
    // Go to right subtree
    else if (data > node.data)
        node.right = insert(node.right, data);
         
    return node;
}
 
// Function to replace every element with the
// least greater element on its right
static void replace(int arr[], int n)
{
    BinarySearchTree tree = new BinarySearchTree();
 
    // start from right to left
    for(int i = n - 1; i >= 0; i--) 
    {
        succ = null;
         
        // Insert current element into BST and
        // find its inorder successor
        root = tree.insert(root, arr[i]);
 
        // Replace element by its inorder
        // successor in BST
        if (succ != null)
            arr[i] = succ.data;
             
        // No inorder successor
        else
            arr[i] = -1;
    }
}
 
// Driver code
public static void main(String[] args)
{
    int arr[] = new int[] { 8, 58, 71, 18, 31, 
                            32, 63, 92, 43, 3,
                            91, 93, 25, 80, 28 };
    int n = arr.length;
 
    replace(arr, n);
 
    for(int i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
}
}

// Time --> O(n^2)   Space --> O(h)