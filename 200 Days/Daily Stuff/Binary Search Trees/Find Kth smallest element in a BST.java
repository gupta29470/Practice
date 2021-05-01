/*
kthSmallest function:
	-> create array list to store elements till k
	-> pass to kthSmallestInorder function(root, k, array list)
		-> traverse left
		-> add data in array list and check if array list size == k if yes then 
		return(because last element of array list is kthSmallest element)
		-> traverse right
*/

import java.util.*;

public class vit {

    static int count = 0;

    public static void main(String[] args) {

        /* Construct below tree
		          50
		        /   \
		       /     \
		      30      70
		     /\       / \
		    /  \     /   \
		   20   40  60    80
		              		                     
         */
        Nodes root = new Nodes(50);
        root.left = new Nodes(30);
        root.right = new Nodes(70);
        root.left.left = new Nodes(20);
        root.left.right = new Nodes(40);
        root.right.left = new Nodes(60);
        root.right.right = new Nodes(80);

        System.out.println(kthSmallest(root, 6));
    }

    public static int kthSmallest(Nodes root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        ArrayList<Integer> list = new ArrayList<>();
    
        kthSmallestInorder(root, k, list);

        return list.get(list.size() - 1);
    }

    public static void kthSmallestInorder(Nodes root, int k,
            ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        kthSmallestInorder(root.left, k, list);
        list.add(root.data);
        if (list.size() == k) {
            return;
        }
        kthSmallestInorder(root.right, k, list);

    }
}

class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}


// Time --> O(k)    Space --> O(h) + O(k)



/*
**************************** APPROACH 2 **********************************
The Inorder Traversal of a BST traverses the nodes in increasing order. 
So the idea is to traverse the tree in Inorder. While traversing, keep track of 
the count of the nodes visited. If the count becomes k, print the node. 
*/

import java.util.*;

public class vit {

    static int count = 0;

    public static void main(String[] args) {

        /* Construct below tree
		          50
		        /   \
		       /     \
		      30      70
		     /\       / \
		    /  \     /   \
		   20   40  60    80
		              		                     
         */
        Nodes root = new Nodes(50);
        root.left = new Nodes(30);
        root.right = new Nodes(70);
        root.left.left = new Nodes(20);
        root.left.right = new Nodes(40);
        root.right.left = new Nodes(60);
        root.right.right = new Nodes(80);

        System.out.println(kthSmallest(root, 6));
    }

    // Function to find k'th largest element in BST
	public static int kthSmallest(Nodes root, int k) {
        if (root == null) {
            return -1;
        }

        Nodes result = kthSmallestInorder(root, k);
        
        if (k > count || root == null){
            return -1;
        }

        return result.data;
    }
	
	// Function to find k'th largest element in BST
    // Here count denotes the number 
    // of nodes processed so far
    public static Nodes kthSmallestInorder(Nodes root, int k) {
        // base case
        if (root == null)
            return null;
      
        // search in left subtree
        Nodes left = kthSmallestInorder(root.left, k);
      
        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;
      
        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;
      
        // else search in right subtree
        return kthSmallestInorder(root.right, k);
    }

}

class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}

// Time --> O(n)   Space --> O(h)


/*
************************* APPROACH 3 Using Morris Traversal **********************

1. in KSmallestUsingMorris function:
	-> create count = 0, ksmall = min value
	-> apply morrris traversal: 
		-> when ever turning right, increment count and check if count is equal
		to k if yes then ksmall = current.data
	-> at last return ksmall
*/

// Java program to find k'th largest element in BST  
import java.util.*; 
class GfG { 
  
// A BST node  
static class Node  
{  
    int key;  
    Node left, right;  
} 
  
// A function to find  
static int KSmallestUsingMorris(Node root, int k)  
{  
    // Count to iterate over elements till we  
    // get the kth smallest number  
    int count = 0;  
  
    int ksmall = Integer.MIN_VALUE; // store the Kth smallest  
    Node curr = root; // to store the current node  
  
    while (curr != null)  
    {  
        // Like Morris traversal if current does  
        // not have left child rather than printing  
        // as we did in inorder, we will just  
        // increment the count as the number will  
        // be in an increasing order  
        if (curr.left == null)  
        {  
            count++;  
  
            // if count is equal to K then we found the  
            // kth smallest, so store it in ksmall  
            if (count==k)  
                ksmall = curr.key;  
  
            // go to current's right child  
            curr = curr.right;  
        }  
        else
        {  
            // we create links to Inorder Successor and  
            // count using these links  
            Node pre = curr.left;  
            while (pre.right != null && pre.right != curr)  
                pre = pre.right;  
  
            // building links  
            if (pre.right== null)  
            {  
                //link made to Inorder Successor  
                pre.right = curr;  
                curr = curr.left;  
            }  
  
            // While breaking the links in so made temporary  
            // threaded tree we will check for the K smallest  
            // condition  
            else
            {  
                // Revert the changes made in if part (break link  
                // from the Inorder Successor)  
                pre.right = null;  
  
                count++;  
  
                // If count is equal to K then we found  
                // the kth smallest and so store it in ksmall  
                if (count==k)  
                    ksmall = curr.key;  
  
                curr = curr.right;  
            }  
        }  
    }  
    return ksmall; //return the found value  
}  
  
// A utility function to create a new BST node  
static Node newNode(int item)  
{  
    Node temp = new Node();  
    temp.key = item;  
    temp.left = null; 
    temp.right = null;  
    return temp;  
}  
  
/* A utility function to insert a new node with given key in BST */
static Node insert(Node node, int key)  
{  
    /* If the tree is empty, return a new node */
    if (node == null) return newNode(key);  
  
    /* Otherwise, recur down the tree */
    if (key < node.key)  
        node.left = insert(node.left, key);  
    else if (key > node.key)  
        node.right = insert(node.right, key);  
  
    /* return the (unchanged) node pointer */
    return node;  
}  
  
// Driver Program to test above functions  
public static void main(String[] args)  
{  
    /* Let us create following BST  
            50  
        /     \  
        30     70  
        / \ / \  
    20 40 60 80 */
    Node root = null;  
    root = insert(root, 50);  
    insert(root, 30);  
    insert(root, 20);  
    insert(root, 40);  
    insert(root, 70);  
    insert(root, 60);  
    insert(root, 80);  
  
    for (int k=1; k<=7; k++)  
    System.out.print(KSmallestUsingMorris(root, k) + " ");  
  
} 
}  