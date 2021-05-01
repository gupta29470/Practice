import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
		          6
		        /   \
		       /     \
		      23      8
		     /       /   \
		    /       /     \
		   5       4       2
		        /   \      \
		       /     \      \
		      1       7      3
         */

        Nodes root = new Nodes(6);
        root.left = new Nodes(23);
        root.left.left = new Nodes(5);
        root.right = new Nodes(8);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);
        root.right.right.right = new Nodes(3);
        
        printCorner(root);
        
    }
    
    public static void printCorner(Nodes root){
        if (root == null){
            return;
        }
        
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            int index = 0;
            
            while (index < size){
                Nodes current = queue.poll();
                
                if (index == 0){
                    System.out.print(current.data+" ");
                }
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
                index++;
            }
        }
    }
}

//6 23 8 4 1 7 2 3
class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}




import java.util.*;

public class vit {

    static Nodes root;

    public static void main(String[] args) {
        root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);

        LeftView_of_Tree(root);
        LeftView_of_Tree(roots);

    }

    public static void LeftView_of_Tree(Nodes root) {

        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;

            while (temp++ < size) {
                Nodes current = queue.poll();
                if (temp == 1) {
                    System.out.print(current.data + " ");
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        System.out.println("");
    }
}

class Nodes {

    int data;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        left = right = null;
    }
}





// Using Hashing
import java.util.*;

public class vit {
    
    static Nodes root;
    
    public static void main(String[] args) {
        root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);
        
        LeftView_of_Tree(root);
        
    }
    
    public static void LeftView_of_Tree(Nodes root) {
        
        if (root == null) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int level = 1;
        
        storeInToMap(root, map, level);
        
        for (int index = 1; index <= map.size(); index++) {
            System.out.println(map.get(index));
        }
        
    }

    public static void storeInToMap(Nodes root, Map<Integer, Integer> map,
            int level) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, root.data);
        
        storeInToMap(root.left, map, level + 1);
        storeInToMap(root.right, map, level + 1);
    }
}

class Nodes {
    
    int data;
    Nodes left, right;
    
    public Nodes(int data) {
        this.data = data;
        left = right = null;
    }
}
// Time Complexity --> O(n)   Space --> O(n)




// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Recursive function to print left view of given binary tree
    public static int leftView(Node root, int level, int lastLevel)
    {
        // base case: empty tree
        if (root == null) {
            return lastLevel;
        }
 
        // if current node is first node of current level
        if (lastLevel < level)
        {
            // print the node's data
            System.out.print(root.key + " ");
 
            // update last level to current level
            lastLevel = level;
        }
 
        // recur for left and right subtree by increasing level by 1
        lastLevel = leftView(root.left, level + 1, lastLevel);
        lastLevel = leftView(root.right, level + 1, lastLevel);
 
        return lastLevel;
    }
 
    // Function to print left view of given binary tree
    public static void leftView(Node root) {
        leftView(root, 1, 0);
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        leftView(root);
    }
}
// Time Complexity --> O(n)   Space --> O(h)