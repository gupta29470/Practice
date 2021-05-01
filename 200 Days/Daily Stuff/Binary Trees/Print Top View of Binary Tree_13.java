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
        printTop(roots);
    }

    public static void printTop(Nodes root) {

        if (root == null) {
            return;
        }

        int distance = 0, level = 0;
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

        storeTop(root, level, distance, map);

        for (Pair<Integer, Integer> iterator : map.values()) {
            System.out.print(iterator.first + " ");
        }

    }

    public static void storeTop(Nodes root, int level, int distance,
            Map<Integer, Pair<Integer, Integer>> map) {

        if (root == null) {
            return;
        }

        if (!map.containsKey(distance) || level < map.get(distance).second) {
            map.put(distance, Pair.of(root.data, level));
        }

        storeTop(root.left, level + 1, distance - 1, map);
        storeTop(root.right, level + 1, distance + 1, map);
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

class Pair<U, V> {

    U first;
    V second;

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public static <U, V> Pair<U, V> of(U first, V second) { //can give any method name
        return new Pair(first, second);
    }
}




import java.util.Queue; 
import java.util.TreeMap; 
import java.util.LinkedList; 
import java.util.Map; 
import java.util.Map.Entry; 
  
// class to create a node 
class Node { 
    int data; 
    Node left, right; 
  
    public Node(int data) { 
        this.data = data; 
        left = right = null; 
    } 
} 
  
// class of binary tree 
class BinaryTree { 
    Node root; 
  
    public BinaryTree() { 
        root = null; 
    } 
      
    // function should print the topView of 
    // the binary tree 
    private void TopView(Node root) { 
        class QueueObj { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
        if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
  
        System.out.println("The top view of the tree is : "); 
          
        // count function returns 1 if the container  
        // contains an element whose key is equivalent  
        // to hd, or returns zero otherwise. 
        while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            if (!topViewMap.containsKey(tmpNode.hd)) { 
                topViewMap.put(tmpNode.hd, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
            } 
  
        } 
        for (Entry<Integer, Node> entry : topViewMap.entrySet()) { 
            System.out.print(entry.getValue().data); 
        } 
    } 
      
    // Driver Program to test above functions 
    public static void main(String[] args)  
    {  
        /* Create following Binary Tree  
            1  
        / \  
        2 3  
        \  
            4  
            \  
            5  
            \  
                6*/
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.right = new Node(5); 
        tree.root.left.right.right.right = new Node(6); 
        System.out.println("Following are nodes in top view of Binary Tree");  
        tree.TopView(tree.root);  
    }  
      
} 



// Recommendedd
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {
     
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);

        bottomView(root);
    }

    public static void bottomView(Nodes root) {

        if (root == null) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();

        int distance = 0;

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        root.distance = distance;

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            distance = current.distance;

            map.putIfAbsent(distance, current.data);

            if (current.left != null) {
                current.left.distance = distance - 1;
                queue.add(current.left);
            }
            if (current.right != null) {
                current.right.distance = distance + 1;
                queue.add(current.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> top = iterator.next();
            System.out.print(top.getValue() + " ");
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