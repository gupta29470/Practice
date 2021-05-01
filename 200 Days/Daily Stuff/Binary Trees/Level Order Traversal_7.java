// Using Queue
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
        LevelOrderTraversal(root);
    }

    public static void LevelOrderTraversal(Nodes root) {
        if (root == null) {
            return;
        }
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Nodes current = queue.poll();

            System.out.print(current.data + " ");

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

    int data;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        left = right = null;
    }
}



// Using Queue
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
        LevelOrderTraversal(root);
    }

    public static void LevelOrderTraversal(Nodes root){
        if (root == null){
            return;
        }
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            int size = queue.size();
            
            while (size-- > 0){
                Nodes current = queue.poll();
                
                System.out.print(current.data+" ");
                
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            System.out.println("");
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
        LevelOrderTraversal(root);
    }

    public static void LevelOrderTraversal(Nodes root) {
        if (root == null) {
            return;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 1;
        storeLevelOrderTraversal(root, map, level);
        
        for (int key = 1; key <= map.size(); key++){
            System.out.println("Level "+ key + " : " + map.get(key));
        }
    }
    public static void storeLevelOrderTraversal(Nodes root,
            Map<Integer, List<Integer>> map, int level){
        
        if (root == null){
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
