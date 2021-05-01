/*
1. Create parent map and store key as child and value as parent.
2. Use Set to store visited node and avoid duplication
3. Use Queue to traverse in BFS fashion.
4. If our k == 0 we print all values from queue.
*/


import java.util.*;
import java.util.Map.Entry;

public class vit {

    static Integer prev;

    public static void main(String[] args) {

        /* Construct below tree
              15
            /    \
           /      \
          10       20
         / \      /  \
        8   12   16  25
                /
               18
         */
        Nodes root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);
        root.right.left.left = new Nodes(18);

        ArrayList<Integer> result = KDistanceNodes(root, 18, 2);

        System.out.println(result);
    }

    public static ArrayList<Integer> KDistanceNodes(Nodes root, int target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }

        // hash map to store child as key and parent as value.
        Map<Nodes, Nodes> parentMap = new HashMap<>();

        storeParent(root, parentMap);

        // to keep track of visited node and avoid duplication we are using set
        Set<Nodes> visited = new HashSet<>();

        // getting target node using target(int)
        Nodes targetNode = findNode(root, target);

        System.out.println(targetNode.data);

        // queue for BFS
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(targetNode); // starting with target to move up and down

        //result array list
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Nodes current = queue.poll();

                visited.add(current); // visited node

                if (k == 0) { // if distance found
                    result.add(current.data);
                }

                // check if current node has parent and not visited
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                }

                // check if current node has left child and not visited
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                }

                // check if current node has right child and not visited
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                }
                size--;
            }
            k--;
        }
        return result;
    }

    public static void storeParent(Nodes root, Map<Nodes, Nodes> parentMap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }

        storeParent(root.left, parentMap);
        storeParent(root.right, parentMap);
    }

    public static Nodes findNode(Nodes root, int target) {

        if (root != null) {
            if (root.data == target) {
                return root;
            } else {
                Nodes foundNode = findNode(root.left, target);

                if (foundNode == null) {
                    foundNode = findNode(root.right, target);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }

    public static void inOrder(Nodes root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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


// Leetcode
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null){
            return new ArrayList<>();
        }
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
        storeParent(root, parentMap);
        
        Set<TreeNode> visited = new HashSet<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()){
            int size = queue.size();
            
            while (size-- > 0){
                TreeNode current = queue.poll();
                
                visited.add(current);
                
                if (K == 0){
                    result.add(current.val);
                }
                
                if (parentMap.containsKey(current) && 
                   !visited.contains(parentMap.get(current))){
                    queue.add(parentMap.get(current));
                }
                
                if (current.left != null && !visited.contains(current.left)){
                    queue.add(current.left);
                }
                
                if (current.right != null && !visited.contains(current.right)){
                    queue.add(current.right);
                }
            }
            K--;
        }
        return result;
    }
    
    public void storeParent(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if (root == null){
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            if (current.left != null){
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null){
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
}




