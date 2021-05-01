/*
The idea is to traverse the tree in preorder fashion and store every encountered node in 
current path from root to leaf in a data structure. Whenever we encountered leaf node
we will print.
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

        printAllPaths(root);

    }

    public static void printAllPaths(Nodes root) {
        if (root == null) {
            return;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> storePath = new ArrayList<>();

        storeAllPaths(root, result, storePath);

        System.out.println(result);

    }

    public static void storeAllPaths(Nodes root, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> storePath) {

        if (root == null) {
            return;
        }
        storePath.add(root.data);

        if (root.left == null && root.right == null) {
            result.add((ArrayList<Integer>) storePath.clone());
            storePath.remove(storePath.size() - 1);
            return;
        }

        storeAllPaths(root.left, result, storePath);
        storeAllPaths(root.right, result, storePath);

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

// Time --> O(n)  Space --> O(h)  if use ArrayList   Space --> O(n)

class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        if (root == null){
            return new ArrayList<>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> storePath = new ArrayList<>();
        
        PathsUtil(root, result, storePath);
        
        return result;
        
    }
    
    public static void PathsUtil(Node root, ArrayList<ArrayList<Integer>> result,
    ArrayList<Integer> storePath){
        if (root == null){
            return;
        }
        
        storePath.add(root.data);
        
        if (root.left == null && root.right == null){
            result.add((ArrayList<Integer>)storePath.clone());
            storePath.remove(storePath.size() - 1);
            return;
        }
        
        PathsUtil(root.left, result, storePath);
        PathsUtil(root.right, result, storePath);
        storePath.remove(storePath.size() - 1);
    }
    
}