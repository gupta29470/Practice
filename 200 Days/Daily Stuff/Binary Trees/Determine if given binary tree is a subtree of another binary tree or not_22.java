/*
Also, we know that inorder and pre-order traversal or inorder and post-order traversal 
identify a tree uniquely. The idea is store in-order and post-order traversal of both 
trees in separate arrays. Then, in order for a given binary tree X to be subset of 
another binary tree Y, the in-order traversal of X should be sub-set of in-order 
traversal of Y. Similarly, the post-order traversal of X should be sub-set of post-order 
traversal of Y. We can also perform pre-order traversal instead of post-order traversal. 
For example, consider above trees
*/


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
        root.right = new Nodes(8);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);
        root.right.right.right = new Nodes(3);

        Nodes roots = new Nodes(4);
        roots.left = new Nodes(1);
        roots.right = new Nodes(6);

        System.out.println(subTree(root, roots));

    }
   
    public static boolean subTree(Nodes root, Nodes subRoot){
        if (root == null){
            return false;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        
        inOrder(root, list);
        inOrder(subRoot, subList);
        
        System.out.println(list.size() + " " + subList.size());
        
        String data = list.toString().replace("[", "").replace("]", "");
        String subData = subList.toString().replace("[", "").replace("]", "");
        
        if (!data.contains(subData)){
            return false;
        }
        
        list.clear();
        subList.clear();
        
        postOrder(root, list);
        postOrder(subRoot, subList);
        
        System.out.println(list.size() + " " + subList.size());
        
        data = list.toString().replace("[", "").replace("]", "");
        subData = subList.toString().replace("[", "").replace("]", "");
        
        if (!data.contains(subData)){
            return false;
        }
        return true;
    }
    
    public static void inOrder(Nodes root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        Stack<Nodes> stack = new Stack<>();
        
        Nodes current = root;
        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                current = stack.pop();
                list.add(current.data);
                current = current.right;
            }
        }
    }
    
    public static void postOrder(Nodes root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        
        Stack<Nodes> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()){
            Nodes current = stack.pop();
            
            out.push(current.data);
            
            if (current.left != null){
                stack.push(current.left);
            }
            if (current.right != null){
                stack.push(current.right);
            }
        }
        
        while (!out.isEmpty()){
            list.add(out.pop());
        }
        
    }

}

//6 23 8 4 1 7 2 3
class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}

// Time  --> O(n^2) 


public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(44);
        root.left = new Nodes(9);
        root.right = new Nodes(13);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        boolean result = subTree(root, root.right);

        if (result) {
            System.out.println("Yes Tree 2 is a subtree of Tree 1");
        } else {
            System.out.println("Yes Tree 2 is not a subtree of Tree 1");
        }
    }

    public static boolean subTree(Nodes root1, Nodes root2) {
        if (root1 == null) { // main tree is null its false
            return false;
        }
        if (root2 == null) { // small tree is null then its true
            return true;
        }

        if (isIdentical(root1, root2)) {
            return true;
        }
        return subTree(root1.left, root2) || subTree(root1.right, root2);
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null)
                && (root1.data == root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
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

// Time --> o(n^2)