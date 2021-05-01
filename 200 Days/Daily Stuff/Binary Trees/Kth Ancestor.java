/*
1. Create temp node to find target node
2. kthAncestor function:
	-> if root null then return null
	-> find target node using preorder fashion in one if condition
	-> if K is greater than 0 then decrement K and return to root(upwards)
	-> else if K == 0 then it is Kth Ancestor
	-> if all fails return null
*/

public class vit {

    static Nodes temp = null;

    public static void main(String[] args) {

        /* Construct below BST
                  1
                /    \
               /      \
              2        3
             /  \       \
            /    \       \
           4      5       2
    
         */
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.right = new Nodes(2);
        
        Nodes result = kthAncestor(root, root.right.right, 2);
        
        System.out.println(result.data);

    }
    
    public static Nodes kthAncestor(Nodes root, Nodes node, int K){
        if (root == null){
            return null;
        }
        
        if (root == node || (temp = kthAncestor(root.left, node, K)) != null 
                ||(temp = kthAncestor(root.right, node, K)) != null){
            
            if (K > 0){
                K--;
            }
            else if (K == 0){
                return root;
            }
            
            return root;
        }
        
        return null;
    }
}

class LeafLevel {

    int leafLevel = 0;
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