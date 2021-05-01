/*
The idea is very simple. We traverse the tree in postorder fashion and for every 
node we swap its left and right child pointer after recursively converting its left 
subtree and right subtree first to mirror. 
*/


public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

        convertMirror(roots);
        preOrder(roots);
    }

    public static void convertMirror(Nodes root) {
        if (root == null){
            return;
        }
        
        convertMirror(root.left);
        convertMirror(root.right);
        
        swap(root);
    }

    public static void swap(Nodes root) {
        if (root == null){
            return;
        }
        
        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
        
    }

    public static void preOrder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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




class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root = swap(root);
        return root;
    }
    
    public static TreeNode swap(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

// Time --> O(n)   Space --> O(h)




// Iterative
public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

      
        convertMirror(roots);
        preOrder(roots);
    }

    public static void convertMirror(Nodes root) {
        if (root == null){
            return;
        }
        
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            Nodes current = queue.poll();
            swap(current);
            
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    public static void swap(Nodes root) {
        if (root == null){
            return;
        }
        
        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
        
    }

    public static void preOrder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            swap(current);
            
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return root;
    }
    
    public static void swap(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

// Time --> O(n)   Space --> O(n)
