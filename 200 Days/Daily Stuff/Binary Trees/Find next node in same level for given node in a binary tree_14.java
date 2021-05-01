import java.util.*;
import java.util.Map.Entry;

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

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);
        
        next_RightNode(roots, 8);

    }

    public static void next_RightNode(Nodes root, int key) {
        if (root == null) {
            return;
        }
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            if (current.data == key && !queue.isEmpty()) {
                System.out.println(queue.peek().data);
                return;
            }
            else if (current.data == key && queue.isEmpty()){
                System.out.println(key + " has no next");
                return;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
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
// Time --> O(n)    Space --> O(n)







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

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);
        next_RightNode(roots, 4);
        
    }
    
    public static void next_RightNode(Nodes root, int key){
        if (root == null){
            return;
        }
        
        Nodes result = return_Next(root, key);
        
        if (result == null){
            System.out.println(key + "'s has no next right node");
        }
        else{
            System.out.println(key +"'s next right node is : "+result.data);
        }
    }
    public static Nodes return_Next(Nodes root, int key){
        if (root == null){
            return null;
        }
        int level = 1;
        ValueLevel valueLevel = new ValueLevel();
        
        Nodes result = find_next(root, key, level, valueLevel);
        
        return result;
    }
    
    public static Nodes find_next(Nodes root, int key, int level, 
            ValueLevel valueLevel){
        if (root == null){
            return null;
        }
        
        if (root.data == key){
            valueLevel.valueLevel = level;
            return null;
        }
        else if (valueLevel.valueLevel != 0 && valueLevel.valueLevel == level){
            return root;
        }
        
        Nodes leftNode = find_next(root.left, key, level + 1, valueLevel);
        
        if (leftNode != null){
            return leftNode;
        }
        
        return find_next(root.right, key, level + 1, valueLevel);
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

class ValueLevel{
    int valueLevel = 0;
}


//Time --> O(n)  Space -->O(h)


/* Java program to find next right of a given key  
using preorder traversal */
import java.util.*; 
class GfG { 
      
static class V { 
    int value_level = 0; 
} 
  
// A Binary Tree Node  
static class Node {  
    Node left, right;  
    int key;  
} 
  
// Utility function to create a new tree node  
static Node newNode(int key)  
{  
    Node temp = new Node();  
    temp.key = key;  
    temp.left = null; 
    temp.right = null;  
    return temp;  
}  
  
// Function to find next node for given node  
// in same level in a binary tree by using  
// pre-order traversal  
static Node nextRightNode(Node root, int k, int level, V value)  
{  
    // return null if tree is empty  
    if (root == null)  
        return null;  
  
    // if desired node is found, set value_level  
    // to current level  
    if (root.key == k) {  
        value.value_level = level;  
        return null;  
    }  
  
    // if value_level is already set, then current  
    // node is the next right node  
    else if (value.value_level != 0) {  
        if (level == value.value_level)  
            return root;  
    }  
  
    // recurse for left subtree by increasing level by 1  
    Node leftNode = nextRightNode(root.left, k, level + 1, value);  
  
    // if node is found in left subtree, return it  
    if (leftNode != null)  
        return leftNode;  
  
    // recurse for right subtree by increasing level by 1  
    return nextRightNode(root.right, k, level + 1, value);  
}  
  
// Function to find next node of given node in the  
// same level in given binary tree  
static Node nextRightNodeUtil(Node root, int k)  
{  
    V v = new V(); 
  
    return nextRightNode(root, k, 1, v);  
}  
  
// A utility function to test above functions  
static void test(Node root, int k)  
{  
    Node nr = nextRightNodeUtil(root, k);  
    if (nr != null)  
        System.out.println("Next Right of " + k + " is "+ nr.key);  
    else
        System.out.println("No next right node found for " + k); 
}  
  
// Driver program to test above functions  
public static void main(String[] args)  
{  
    // Let us create binary tree given in the  
    // above example  
    Node root = newNode(10);  
    root.left = newNode(2);  
    root.right = newNode(6);  
    root.right.right = newNode(5);  
    root.left.left = newNode(8);  
    root.left.right = newNode(4);  
  
    test(root, 10);  
    test(root, 2);  
    test(root, 6);  
    test(root, 5);  
    test(root, 8);  
    test(root, 4);  
}  
}


//Time --> O(n)  Space -->O(h)
