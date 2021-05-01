/*
We can find LCA in BST by using same approach used in Binary Tree. But for only BST 
there is an efficient approach available.

************************ RECURSIVE *******************************
if n1 and n2 are less than root then we move left
if n1 and n2 are greater than root then move right
if either above two condition fails we return root that is LCA

*/

Node lca(Node node, int n1, int n2)  
    { 
        if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.data > n1 && node.data > n2) 
            return lca(node.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.data < n1 && node.data < n2)  
            return lca(node.right, n1, n2); 
   
        return node; 
    } 
	
// Time Complexity: O(h).  Space Complexity: O(1).


// ************************ ITERATIVE *******************************

static Node lca(Node root, int n1, int n2)  
{  
    while (root != null)  
    {  
        // If both n1 and n2 are smaller  
        // than root, then LCA lies in left  
        if (root.data > n1 &&  
            root.data > n2)  
        root = root.left;  
  
        // If both n1 and n2 are greater  
        // than root, then LCA lies in right  
        else if (root.data < n1 &&  
                 root.data < n2)  
        root = root.right;  
  
        else break;  
    }  
    return root;  
}  

// Time Complexity: O(h).  Space Complexity: O(1).


//************** SAME APPROACH USED IN Binary Tree ************************

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
        
        System.out.println(LCA(root, 20, 80));
    }
    
    public static int LCA(Nodes root, int node1, int node2){
        if (root == null){
            return 0;
        }
        
        Nodes lca = LCAUtil(root, node1, node2);
        
        return lca.data;
    }
    
    public static Nodes LCAUtil(Nodes root, int node1, int node2){
        if (root == null){
            return root;
        }
        
        if (root.data == node1 || root.data == node2){
            return root;
        }
        
        Nodes left = LCAUtil(root.left, node1, node2);
        
        Nodes right = LCAUtil(root.right, node1, node2);
        
        if (left != null && right != null){
            return root;
        }
        
        return left != null? left : right;
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
