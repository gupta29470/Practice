/*
The node is a "dead end node" means we cannot add any node further in the tree 
or we cannot make that node parent
if BST contains "dead end node - 1" and "dead end node + 1".
Suppose x is a dead end node if BST contains x - 1 and x + 1 
1. deadEndNode function: 
	-> create two sets: 
		1. Set 1 will store all nodes (allNodes)
		2. Set 2 will store only leaf nodes to avoid re-traversal of BST
		(allLeafNodes)
	-> insert 0 in 'Set 1' for handle case if bst contain value 1
	-> pass(root, set 1 and set 2) to storeNodes function
	-> storeNodes function: performing preorder traversal
		-> if root null then return
		-> add data in allNodes(Set 1)
		-> check if current node is leaf then add in allLeafNodes(Set 2)
		-> traverse left
		-> traverse right
	-> create deadEnd variable intialize to min value
	-> iterator for set
	-> while iterator.hasNext()
		-> store current data in "current" variable
		-> Note: type iterator.next() only once because because it point to next
           every time we call. so storing in "current variable"
		-> create small variable as current - 1 and big variable as current + 1
		-> if allNodes(Set 1) contains small and big value then deadEnd = current
	-> return deadEnd != min value
*/
import java.util.*;

public class vit {

    public static void main(String[] args) {

        Nodes root = new Nodes(8);
        root.left = new Nodes(7);
        root.right = new Nodes(10);
        root.left.left = new Nodes(2);
        root.right.left = new Nodes(9);
        root.right.right = new Nodes(13);

        System.out.println(deadEndNode(root));
    }

    public static boolean deadEndNode(Nodes root) {
        if (root == null) {
            return false;
        }

        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> allLeafNodes = new HashSet<>();

        allNodes.add(0);
        
        storeNodes(root, allNodes, allLeafNodes);

        System.out.println(allNodes);
        System.out.println(allLeafNodes);
        
        int deadEnd = Integer.MIN_VALUE;
        Iterator<Integer> iterator = allLeafNodes.iterator();

        while (iterator.hasNext()) {
            // call iterator.next() only once because it point to next
            // every time we call
            int current = iterator.next();
            
            int small = current - 1, big = current + 1;
            
            if (allNodes.contains(small) && allNodes.contains(big)) {
                deadEnd = current;
                System.out.println(deadEnd);
            }
        }
        return deadEnd != Integer.MIN_VALUE;
    }

    public static void storeNodes(Nodes root, Set<Integer> allNodes,
            Set<Integer> allLeafNodes) {
        if (root == null) {
            return;
        }

        allNodes.add(root.data);

        if (root.left == null && root.right == null) {
            allLeafNodes.add(root.data);
        }

        storeNodes(root.left, allNodes, allLeafNodes);

        storeNodes(root.right, allNodes, allLeafNodes);
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

// Time --> O(n)  Space -> O(n) + O(leaf Node size)


/*
************************** RECURSIVE APPROACH ***************************
1. deadEndNode function:
	-> create min and max for range of value in BST
	-> pass(root, min, max) to deadEndNodeUtil function
	-> deadEndNodeUtil function:
		-> if root is null return false
		-> check min is equal to max then return true. If dead end node is
		present in BST then min and max and it means we cannot add any node further in the 
		tree.
		-> traverse left and right by
		root.left, min, root.data - 1 ||(or) root.right, root.data + 1, max
		-> if we find true either in left tree "or" right tree we return true
*/

public class vit {


    public static void main(String[] args) {

        Nodes root = new Nodes(8);
        root.left = new Nodes(7);
        root.right = new Nodes(10);
        root.left.left = new Nodes(2);
        root.right.left = new Nodes(9);
        root.right.right = new Nodes(13);

        System.out.println(deadEndNode(root));
    }

    public static boolean deadEndNode(Nodes root) {
        if (root == null) {
            return false;
        }
        
        int min = 1, max = Integer.MAX_VALUE;
        return deadEndNode(root, min, max);
    }
    
    
    // Returns true if tree with given root contains 
    // dead end or not. min and max indicate range 
    // of allowed values for current node. Initially 
    // these values are full range.
    public static boolean deadEndNodeUtil(Nodes root, int min, int max){
        // if the root is null or the recursion moves 
        // after leaf node it will return false 
        // i.e no dead end
        if (root == null){
            return false;
        }
        
        // if this occurs means dead end is present. 
        if (min == max){
            return true;
        }
        
        // heart of the recursion lies here. 
        return deadEndNodeUtil(root.left, min, root.data - 1) ||
                deadEndNodeUtil(root.right, root.data + 1, max);
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

