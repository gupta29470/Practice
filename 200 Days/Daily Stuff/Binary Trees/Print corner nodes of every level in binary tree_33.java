/*
Combination of left view and right view
*/

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
        
        printCorner(root);
        
    }
    
    public static void printCorner(Nodes root){
        if (root == null){
            return;
        }
        
       Queue<Nodes> queue = new LinkedList<>();
       queue.add(root);
       
       while (!queue.isEmpty()){
           int size = queue.size();
           
           int index = 0;
           while (index < size){
               Nodes current = queue.poll();
               
               if (index == 0 || index == size - 1){
                   System.out.print(current.data+" ");
               }
               if (current.left != null){
                   queue.add(current.left);
               }
               if (current.right != null){
                   queue.add(current.right);
               }
               index++;
           }
       }
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
        
        printCorner(root);

    }

    public static void printCorner(Nodes root) {
        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
           
            for (int index = 0; index < size; index++) {
                Nodes current = queue.poll();
                
                if (index == 0 || index == size - 1) {
                    System.out.print(current.data+" ");
                }
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
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
