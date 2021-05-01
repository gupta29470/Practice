/*
1. store root in another Node type object "main"
2. create hashmap to store key as root and value will be its successor for each node
3. do inorder traversal
	-> traverse left
	-> find successor from succ function
	-> traverse right
4. succ function performs case 1 and case 2
	-> if succ == null then put - 1 else put succ.data
5. print map
*/

import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {

        /* Construct below tree
		          50
		        /   \
		       /     \
		      30      70
		     /\       / \
		    /  \     /   \
		   20   40  60    80
		              		                     
         */
        Nodes root = new Nodes(50);
        root.left = new Nodes(30);
        root.right = new Nodes(70);
        root.left.left = new Nodes(20);
        root.left.right = new Nodes(40);
        root.right.left = new Nodes(60);
        root.right.right = new Nodes(80);

        allSucc(root);
    }

    public static void allSucc(Nodes root) {
        if (root == null) {
            return;
        }
        Nodes main = root;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        allSucc(root, map, main);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue() + " ");
        }
    }

    public static void allSucc(Nodes root, Map<Integer, Integer> map, Nodes main) {
        if (root == null) {
            return;
        }

        allSucc(root.left, map, main);

        succ(root, map, main);

        allSucc(root.right, map, main);
    }

    public static void succ(Nodes root, Map<Integer, Integer> map, Nodes main) {
        if (root.right != null) {
            Nodes succ = succCase1(root.right);
            if (succ == null) {
                map.put(root.data, -1);
            } else {
                map.put(root.data, succ.data);
            }
            return;
        } else {
            Nodes succ = succCase2(root, main);
            if (succ == null) {
                map.put(root.data, -1);
            } else {
                map.put(root.data, succ.data);
            }
            return;
        }
    }

    public static Nodes succCase1(Nodes root) {
        Nodes temp = root;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public static Nodes succCase2(Nodes root, Nodes main) {
        Nodes temp = main;
        Nodes leftTurn = null;

        while (temp.data != root.data) {
            if (root.data < temp.data) {
                leftTurn = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return leftTurn;
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
