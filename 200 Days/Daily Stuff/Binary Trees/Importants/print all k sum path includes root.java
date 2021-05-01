import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class vit {

    static int sum = 0;
    static int result = 0;

    public static void main(String[] args) {

        /* Construct below BST
                  1
                /    \
               /      \
              2        3
             /  \       \
            /    \       \
           4      5       2
    
         */
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.right = new Nodes(2);
        
        printKPaths(root, 6);

    }

    public static void printKPaths(Nodes root, int k) {
        if (root == null) {
            return;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        printKPathsUtil(root, k, deque);
    }

    public static void printKPathsUtil(Nodes root, int k, Deque<Integer> deque) {
        if (root == null) {
            return;
        }

        sum += root.data;

        deque.addLast(root.data);

        if (sum == k) {
            printDeque(deque);
        }

        printKPathsUtil(root.left, k, deque);
        printKPathsUtil(root.right, k, deque);

        int last = deque.removeLast();
        sum -= last;
    }

    public static void printDeque(Deque<Integer> deque) {
        System.out.println(deque);
    }

}

class LeafLevel {

    int leafLevel = 0;
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
