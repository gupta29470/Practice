import java.util.*;
import java.util.Map.Entry;

public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);
        
        diagonaTraversal(root);

    }

    public static void diagonaTraversal(Nodes root) {

        if (root == null) {
            return;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int diagonal = 0;

        storeDiagonalTraversal(root, diagonal, map);
        
        System.out.println(map.values());
    }

    public static void storeDiagonalTraversal(Nodes root, int diagonal,
            Map<Integer, ArrayList<Integer>> map) {

        if (root == null) {
            return;
        }
        if (!map.containsKey(diagonal)) {
            map.put(diagonal, new ArrayList<>());
        }
        map.get(diagonal).add(root.data);

        storeDiagonalTraversal(root.left, diagonal + 1, map);
        storeDiagonalTraversal(root.right, diagonal, map);
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
// Time --> O(n)   Space --> O(n)




/*
1. Initially add root and null in queue.
2. if current is null check if queue is empty, if it is empty return else add null in queue
3. if current is not empty loop till currrent == null. print current. if left of current 
is not null then add left of current and move current to right
*/


import java.util.*;
import java.util.Map.Entry;

public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);

        diagonaTraversal(root);

    }

    public static void diagonaTraversal(Nodes root) {

        if (root == null) {
            return;
        }
        
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while (!queue.isEmpty()){
            Nodes current = queue.poll();
            
            if (current == null){
                if (queue.size() == 0){
                    return;
                }
                System.out.println("");
                queue.add(null);
            }
            else{
                while (current != null){
                    System.out.print(current.data+" ");
                    
                    if (current.left != null){
                        queue.add(current.left);
                    }
                    current = current.right;
                }
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

// Time --> O(n)   Space --> O(n)