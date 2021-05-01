// Recursive
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
        printVertical(roots);
    }

    public static void printVertical(Nodes root) {

        if (root == null) {
            return;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int level = 0;

        storeVertical(root, level, map);

        Set<Entry<Integer, List<Integer>>> set = map.entrySet();

        Iterator<Entry<Integer, List<Integer>>> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
        iterator = set.iterator();
        System.out.println("");
        System.out.println("With Key");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void storeVertical(Nodes root, int level,
            Map<Integer, List<Integer>> map) {
        
        if (root == null){
            return;
        }

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.data);

        storeVertical(root.left, level - 1, map);
        storeVertical(root.right, level + 1, map);

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

// Time --> O(nlogn)   Space --> O(n)



// Iterative
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

        printVertical(root);
    }

    public static void printVertical(Nodes root) {

        if (root == null) {
            return;
        }
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        int distance = 0;

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        root.distance = distance;

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            distance = current.distance;

            map.putIfAbsent(distance, new ArrayList<>());
            map.get(distance).add(current.data);

            if (current.left != null) {
                current.left.distance = distance - 1;
                queue.add(current.left);
            }
            if (current.right != null) {
                current.right.distance = distance + 1;
                queue.add(current.right);
            }
        }

        Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> top = iterator.next();
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
// Time --> O(nlogn)   Space --> O(n)