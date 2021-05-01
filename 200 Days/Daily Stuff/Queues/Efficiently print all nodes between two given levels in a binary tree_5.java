import java.util.*;

public class vit {

    public static void main(String[] args) {
        Nodes root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);
        root.right.right.right = new Nodes(30);

        int start = 1, end = 3;
        printAllNodes_given_Levels(root, start, end);
    }

    public static void printAllNodes_given_Levels(Nodes root, int start, int end) {
        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;

            int size = queue.size();
            while (size-- > 0) {
                Nodes current = queue.poll();

                if (level >= start && level <= end) {
                    System.out.print(current.data + " ");
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (level >= start && level <= end) {
                System.out.println();
            }
        }
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






import java.util.*;

// Data structure to store a Binary Tree node
class Node
{
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

import java.util.*;

public class vit {

    public static void main(String[] args) {
        Nodes root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);
        root.right.right.right = new Nodes(30);

        int start = 2, end = 3;
        printNodes(root, start, end);

    }

    public static void printNodes(Nodes root, int start, int end) {

        if (root == null) {
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        int level = 1;
        printNodes(root, start, end, map, level);

        for (int key = start; key <= end; key++) {
            System.out.println(key + " --> " + map.get(key) + " ");
        }
    }

    public static void printNodes(Nodes root, int start, int end,
            Map<Integer, List<Integer>> map, int level) {

        if (root == null) {
            return;
        }

        if (level >= start && level <= end) {
            map.putIfAbsent(level, new ArrayList<>()); // if map.containsKey
            map.get(level).add(root.data); // else
        }

        printNodes(root.left, start, end, map, level + 1);
        printNodes(root.right, start, end, map, level + 1);
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
