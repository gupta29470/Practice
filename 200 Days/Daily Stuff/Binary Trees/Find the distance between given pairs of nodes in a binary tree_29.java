/*
Step 1 : Find Lowest Common Ancestors of both nodes
Step 2 : Find level(aLevel, bLevel) of both nodes by passing LCA as root
Step 3 : return aLevel + bLevel
*/


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

        System.out.println(findDistance(root, root.left.right, root.right.left));
    }

    public static int findDistance(Nodes root, Nodes node1, Nodes node2) {
        Nodes LCA = LCA(root, node1, node2);
        int level = 0;
        
        int distance1 = findLevel(LCA, node1, level);
        int distance2 = findLevel(LCA, node2, level);
        
        return distance1 + distance2;
    }

    public static int findLevel(Nodes root, Nodes node, int level) {
        if (root == null) {
            return -1;
        }
        if (root == node) {
            return level;
        }
        int left = findLevel(root.left, node, level + 1);
        if (left == -1) {
            return findLevel(root.right, node, level + 1);
        }
        return left;
    }

    public static Nodes LCA(Nodes root, Nodes node1, Nodes node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Nodes left = LCA(root.left, node1, node2);
        Nodes right = LCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
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

// Time --> O(n)   Space --> O(h)



public class GFG {
 
    public static class Node {
        int value;
        Node left;
        Node right;
 
        public Node(int value) {
            this.value = value;
        }
    }
 
    public static Node LCA(Node root, int n1, int n2) 
    {
        if (root == null)
            return root;
        if (root.value == n1 || root.value == n2)
            return root;
 
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
 
        if (left != null && right != null)
            return root;
          if (left == null && right == null)
              return null;
        if (left != null)
            return LCA(root.left, n1, n2);
        else
            return LCA(root.right, n1, n2);
    }
 
    // Returns level of key k if it is present in
    // tree, otherwise returns -1
    public static int findLevel(Node root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.value == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }
 
    public static int findDistance(Node root, int a, int b)
    {
        Node lca = LCA(root, a, b);
 
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
 
        return d1 + d2;
    }
     
    // Driver program to test above functions
    public static void main(String[] args) {
         
        // Let us create binary tree given in
        // the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                             + findDistance(root, 4, 5));
                              
        System.out.println("Dist(4, 6) = "
                             + findDistance(root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + findDistance(root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + findDistance(root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + findDistance(root, 8, 5));
 
    }
}