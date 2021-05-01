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
        roots.left.left = new Nodes(4);
        roots.left.right = new Nodes(5);
        roots.right.left = new Nodes(6);
        roots.right.right = new Nodes(7);

        ReverseLevelorder(root);
        ReverseLevelorder(roots);
    }

    public static void ReverseLevelorder(Nodes root) {
        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();
            stack.push(current.data);

            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
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





// Using HashMap
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
        roots.left.left = new Nodes(4);
        roots.left.right = new Nodes(5);
        roots.right.left = new Nodes(6);
        roots.right.right = new Nodes(7);

        ReverseLevelorder(root);
        //ReverseLevelorder(roots);
        //LevelOrderTraversal(root);
    }

    public static void ReverseLevelorder(Nodes root) {
        if (root == null) {
            return;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        int level = 1;
        storeReverseLevelorder(root, map, level);

        for (int index = map.size(); index > 0; index--) {
            System.out.println("Level " + index + " : " + map.get(index));
        }
    }

    public static void storeReverseLevelorder(Nodes root, Map<Integer, List<Integer>> map,
            int level) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.data);

        storeReverseLevelorder(root.left, map, level + 1);
        storeReverseLevelorder(root.right, map, level + 1);
    }

    public static void LevelOrderTraversal(Nodes root) {
        if (root == null) {
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 1;
        storeLevelOrderTraversal(root, map, level);

        for (int key = 1; key <= map.size(); key++) {
            System.out.println("Level " + key + " : " + map.get(key));
        }
    }

    public static void storeLevelOrderTraversal(Nodes root,
            Map<Integer, List<Integer>> map, int level) {

        if (root == null) {
            return;
        }

        map.putIfAbsent(level, new ArrayList<>());
        map.get(map.get(level).add(root.data));

        storeLevelOrderTraversal(root.left, map, level + 1);
        storeLevelOrderTraversal(root.right, map, level + 1);
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
