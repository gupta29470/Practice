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
        
        System.out.println(add_AllNodes(roots));
    }

    public static int add_AllNodes(Nodes root){
        if (root == null){
            return 0;
        }
        int sum = root.data + add_AllNodes(root.left) + add_AllNodes(root.right);
        
        return sum;
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
// Time --> O(n)  Space --> O(h)



// Iterative
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

        System.out.println(add_AllNodes(roots));
    }

    public static int add_AllNodes(Nodes root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            Nodes current = queue.poll();
            
            sum += current.data;
            
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return sum;
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