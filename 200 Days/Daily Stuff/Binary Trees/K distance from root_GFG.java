import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
		          6
		        /   \
		       /     \
		      23       8
		            /   \
		           /     \
		          4       2
		        /   \      \
		       /     \      \
		      1       7      3
         */

        Nodes root = new Nodes(6);
        root.left = new Nodes(23);
        root.right = new Nodes(8);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);
        root.right.right.right = new Nodes(3);

        findDistance(root, 1);

    }

    public static void findDistance(Nodes root, int distance) {
        if (root == null){
            return;
        }
        Set<Integer> set = new HashSet<>();
        
        findDistance(root, distance, set);
        
        System.out.println(set);
    }
    
    public static void findDistance(Nodes root, int distance, Set<Integer> set){
        if (root == null){
            return;
        }
        if (distance == 0){
            set.add(root.data);
            return;
        }
        findDistance(root.left, distance - 1, set);
        findDistance(root.right, distance - 1, set);
    }

    public static boolean isLeafNode(Nodes root) {
        return (root.left == null && root.right == null);
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


// Time --> O(n)    Space --> O(h)



class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          if (root == null){
              return new ArrayList<>();
          }
          ArrayList<Integer> result = new ArrayList<>();
          Set<Integer> storeNodes = new HashSet<>();
          
          Kdistance(root, k, result, storeNodes);
          
          return result;
     }
     
     public static void Kdistance(Node root, int k, ArrayList<Integer> result, Set<Integer> storeNodes){
         if (root == null){
             return;
         }
         if (k == 0){ // if found distance
             result.add(root.data);
             return;
         }
         
         Kdistance(root.left, k - 1, result, storeNodes);
         Kdistance(root.right, k - 1, result, storeNodes);
     }
}
