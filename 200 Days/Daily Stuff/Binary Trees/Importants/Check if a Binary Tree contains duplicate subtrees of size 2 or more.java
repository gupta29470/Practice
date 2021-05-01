/*
***************************** APPROACH 1(IN_EFFICIENT) **********************************

1. Create count global variable to keep track of number of duplicates
2. Create root2 global of Nodes type to find duplicate root
3. In duplicate function
	-> using approach of finding subtree so creating two roots
        (root1 -> main tree, root2 -> small tree)
	-> set to find duplicate node
	-> using level order finding duplicate root(findRoot2 function)
	-> checking if duplicate tree contains using sub tree approach
return count in duplicate function
*/
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class vit {

    static int count = 1; // number of duplicates
    static Nodes root2 = null; //root2 -> small tree

    public static void main(String[] args) {

        /* Construct below BST
                  1
                /    \
               /      \
              2        3
             /  \       \
            /    \       \
           4      5       2
                         / \
                        /   \
                       4     5
         */
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.right = new Nodes(2);
        root.right.right.left = new Nodes(4);
        root.right.right.right = new Nodes(5);
       
        System.out.println(duplicate(root));
        
        if (count > 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    public static int duplicate(Nodes root) {
        // using approach of finding subtree so creating two roots
        //(root1 -> main tree, root2 -> small tree)
        Nodes root1 = root;

        Set<Integer> set = new HashSet<>(); // set to find duplicate node
        findRoot2(root, set); // function to get duplicate node(root)

        // checking if duplicate tree contains using sub tree approach
		subTree(root1, root2); 
        
        return count;
    }

    public static boolean subTree(Nodes root1, Nodes root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }

        if (isIdentical(root1, root2)) {
            count += 1;
            return true;
        }

        return subTree(root1.left, root2) || subTree(root1.right, root2);
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null) && (root1.data == root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static void findRoot2(Nodes root, Set<Integer> set) {
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            if (set.contains(current.data)) {
                root2 = current;
                return;
            } else {
                set.add(current.data);
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
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

// Time --> O(n^2)    Space --> O(n^2)


/*
************************* APPROACH 2 (EFFICIENT) ********************************
1. Helper function
	-> Converted every visited path in to String
	-> if map contains that String then put root in list
	-> every visits must enter in map
*/

public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(res, root, new HashMap<>());
        return res;
    }
    
    private String helper(List<TreeNode> res, TreeNode node, Map<String, Integer> map) {
        if(node == null) return " # ";
        String curr = node.val + " left " + helper(res, node.left, map) + " right " + helper(res, node.right, map);
        if(map.getOrDefault(curr, 0) == 1) res.add(node);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        
        return curr;
    }
	
// Time --> O(n)  Space --> O(n)

