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
        
        printNodes(root);
        
    }

    public static void printNodes (Nodes root){
        if (root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        
        Queue<Nodes> first = new LinkedList<>();
        first.add(root.left);
        
        Queue<Nodes> second = new LinkedList<>();
        second.add(root.right);
        
        while (!first.isEmpty()){
            
            int size = first.size();
            
            while (size-- > 0){
                Nodes current1 = first.poll();
                
                System.out.print(current1.data+" ");
                if (current1.left != null){
                    first.add(current1.left);
                }
                if (current1.right != null){
                    first.add(current1.right);
                }
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

        printNodes(root);

    }

    public static void printNodes(Nodes root) {

        if (root == null) {
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 1;

        insertInToMap(root, map, level);

        Queue<Nodes> first = new LinkedList<>();
        first.add(root.left);

        Queue<Nodes> second = new LinkedList<>();
        second.add(root.right);

        while (!first.isEmpty()) {

            int size = first.size();
            level++;

            while (size-- > 0) {
                Nodes current1 = first.poll();

                insertInToMap(current1, map, level);

                if (current1.left != null) {
                    first.add(current1.left);
                }
                if (current1.right != null) {
                    first.add(current1.right);
                }

                Nodes current2 = second.poll();

                insertInToMap(current2, map, level);

                if (current2.right != null) {
                    second.add(current2.right);
                }
                if (current2.left != null) {
                    second.add(current2.left);
                }

            }
        }
        for (int index = map.size(); index > 0; index--) {
            System.out.println(map.get(index));
        }
    }

    public static void insertInToMap(Nodes root, Map<Integer, List<Integer>> map,
            int level) {
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.data);
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
