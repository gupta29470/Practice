/*
**************************RECURSIVE**********************************

1. Create a global level variable to keep a record of level of tree
2. create templevel(_level) which traverse through out the tree
3. Pass(root, level) to another function
4. Another function
	-> We traverse in preorder fashion
	-> if current node is leaf then check if global level == 0? if yes then 
	global level = temp level : else check if global level == level? 
	return true: return false
	-> traverse left
	-> traverse right
	-> return left && right
*/
public class vit {

    static int level = 0;

    public static void main(String[] args) {

        /* Construct below BST
                  5
                /    \
               /      \
              3        8
             /  \     /  \
            /    \   /    \
           4      2  6    10
         */
        Nodes root = new Nodes(5);
        root.left = new Nodes(3);
        root.right = new Nodes(8);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(2);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(10);

        System.out.println(sameLevel(root));

    }

    public static boolean sameLevel(Nodes root) {

        int _level = 0;

        return sameLevel(root, _level);
    }

    public static boolean sameLevel(Nodes root, int _level) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (level == 0) {
                level = _level;
            }

            return (level == _level);
        }

        return sameLevel(root.left, _level + 1)
                && sameLevel(root.right, _level + 1);
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
// Time ---> O(n)   Space ---> O(h)




/*
**************************ITERATIVE**********************************

1. create level = 0 and temp level = 0
2. Create Queue of Nodes type
3. add root in queue
4. traverse level order fashion 
5. while queue is not empty
	-> size = queue.size
	-> increment level
	-> while size is not zero
		-> poll element from queue
		-> if current node of left is not empty add in queue
		-> if current node is leaf then check if level = 0? if yes then level =
		temp level : else check else if level != temp level return false
		-> if current node of right is not empty add in queue
		-> if current node is leaf then check if level = 0? if yes then level =
		temp level : else check else if level != temp level return false 		
*/


// Java program to check if all leaf nodes are at  
// same level of binary tree
import java.util.*;
 
// User defined node class
class Node {
      int data;
      Node left, right;
       
      // Constructor to create a new tree node
      Node(int key) {
           int data = key;
           left = right = null;
      }
}
 
class GFG {
 
      // return true if all leaf nodes are 
      // at same level, else false 
      static boolean checkLevelLeafNode(Node root)
      {
             if (root == null)
                 return true;
 
             // create a queue for level order traversal
             Queue<Node> q = new LinkedList<>();
             q.add(root);
          
             int result = Integer.MAX_VALUE;
             int level = 0;
 
             // traverse until the queue is empty
             while (q.size() != 0) {
                    int size = q.size();
                    level++;
 
                    // traverse for complete level
                    while (size > 0) {
                         Node temp = q.remove();
 
                         // check for left child
                         if (temp.left != null) {
                             q.add(temp.left);
 
                              // if its leaf node
                              if (temp.left.left == null && temp.left.right == null) {
                                  
                                  // if it's first leaf node, then update result
                                  if (result == Integer.MAX_VALUE)
                                      result = level;
 
                                  // if it's not first leaf node, then compare  
                                  // the level with level of previous leaf node.
                                  else if (result != level)
                                       return false; 
                              }
                         }
                          
                          // check for right child 
                          if (temp.right != null) {
                             q.add(temp.right);
 
                              // if its leaf node
                             if (temp.right.left == null && temp.right.right == null) {
                                  
                                  // if it's first leaf node, then update result
                                  if (result == Integer.MAX_VALUE)
                                      result = level;
 
                                  // if it's not first leaf node, then compare  
                                  // the level with level of previous leaf node.
                                  else if (result != level)
                                       return false; 
                              }
                         }
                         size--;
                    }
 
             }
             return true;
      }
 
      // Driver code
      public static void main(String args[])
      {
             // construct a tree 
             Node root = new Node(1);
             root.left = new Node(2);
             root.right = new Node(3);
             root.left.right = new Node(4);
             root.right.left = new Node(5);
             root.right.right = new Node(6);
 
             boolean result = checkLevelLeafNode(root);
             if (result == true)
                 System.out.println("All leaf nodes are at same level");
             else
                 System.out.println("Leaf nodes not at same level");  
      }
}