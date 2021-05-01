import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
		          6
		        /   \
		       /     \
		      23      8
		     /       /   \
		    /       /     \
		   5       4       2
		        /   \      \
		       /     \      \
		      1       7      3
         */

        Nodes root = new Nodes(6);
        root.left = new Nodes(23);
        root.left.left = new Nodes(5);
        root.right = new Nodes(8);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);
        root.right.right.right = new Nodes(3);
        
        diagonalSum(root);

    }
    
    public static void diagonalSum(Nodes root){
        if (root == null){
            return;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int diagonal = 0;
        
        _diagonalSum(root, diagonal, map);
        
        System.out.println(map.values());
    }
    
    public static void _diagonalSum(Nodes root, int diagonal, 
            Map<Integer, Integer> map){
        if (root == null){
            return;
        }
        
        map.put(diagonal, map.getOrDefault(diagonal, 0) + root.data);
        
        _diagonalSum(root.left, diagonal + 1, map);
        _diagonalSum(root.right, diagonal, map);
    }

}

//6 23 8 5 2 1 3 
class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}