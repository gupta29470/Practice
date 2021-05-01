public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(5);
        root.left = new Nodes(1);
        root.right = new Nodes(1);
        root.left.left = new Nodes(2);
        root.right.right = new Nodes(2);

        Nodes roots = new Nodes(5);
        roots.right = new Nodes(1);
        roots.left = new Nodes(1);
        roots.right.right = new Nodes(2);
        roots.left.left = new Nodes(2);

        boolean result = checkMirror(root, roots);
        if (result) {
            System.out.println("One Tree is mirror of another");
        } else {
            System.out.println("One Tree is not mirror of another");
        }

    }

    public static boolean checkMirror(Nodes root1, Nodes root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return checkMirror(root1.left, root2.right)
                    && checkMirror(root1.right, root2.left);
        }
        return false;
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





// Java implementation to check whether the two  
// binary tress are mirrors of each other or not 
import java.util.*; 
class GfG {  
  
// structure of a node in binary tree  
static class Node  
{  
    int data;  
    Node left, right;  
} 
  
// Utility function to create and return  
// a new node for a binary tree  
static Node newNode(int data)  
{  
    Node temp = new Node();  
    temp.data = data;  
    temp.left = null; 
    temp.right = null;  
    return temp;  
}  
  
// function to check whether the two binary trees  
// are mirrors of each other or not  
static String areMirrors(Node root1, Node root2)  
{  
    Stack<Node> st1 = new Stack<Node> (); 
    Stack<Node> st2  = new Stack<Node> ();  
    while (true)  
    {  
        // iterative inorder traversal of 1st tree and  
        // reverse inoder traversal of 2nd tree  
        while (root1 != null && root2 != null)  
        {  
            // if the corresponding nodes in the two traversal  
            // have different data values, then they are not  
            // mirrors of each other.  
            if (root1.data != root2.data)  
                return "No";  
                  
            st1.push(root1);  
            st2.push(root2);  
            root1 = root1.left;  
            root2 = root2.right;      
        }  
          
        // if at any point one root becomes null and  
        // the other root is not null, then they are  
        // not mirrors. This condition verifies that  
        // structures of tree are mirrors of each other.  
        if (!(root1 == null && root2 == null))  
            return "No";  
              
        if (!st1.isEmpty() && !st2.isEmpty())  
        {  
            root1 = st1.peek();  
            root2 = st2.peek();  
            st1.pop();  
            st2.pop();  
              
            /* we have visited the node and its left subtree.  
            Now, it's right subtree's turn */
            root1 = root1.right;  
              
            /* we have visited the node and its right subtree.  
            Now, it's left subtree's turn */
            root2 = root2.left;  
        }      
          
        // both the trees have been completely traversed  
        else
            break;  
    }  
      
    // tress are mirrors of each other  
    return "Yes";  
}  
  
// Driver program to test above  
public static void main(String[] args)  
{  
    // 1st binary tree formation  
    Node root1 = newNode(1);         /*         1         */                    
    root1.left = newNode(3);         /*     / \     */
    root1.right = newNode(2);         /*     3     2     */
    root1.right.left = newNode(5);     /*         / \     */
    root1.right.right = newNode(4); /*         5     4 */
      
    // 2nd binary tree formation      
    Node root2 = newNode(1);         /*         1         */                    
    root2.left = newNode(2);         /*     / \     */
    root2.right = newNode(3);         /*     2     3     */
    root2.left.left = newNode(4);     /* / \         */
    root2.left.right = newNode(5);     /* 4 5         */
          
    System.out.println(areMirrors(root1, root2));  
} 
} 


// Time --> O(n)  Space --> O(n)