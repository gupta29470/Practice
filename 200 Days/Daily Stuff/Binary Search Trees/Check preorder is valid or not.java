/*
The idea is to first construct a BST from the given sequence by inserting keys into the 
BST one at a time. Next we compare the preorder traversal of the constructed BST 
with the given sequence. If the order matches, we can say that the given sequence 
represents preorder traversal of a BST.

1. create global index variable to traverse array
2. First make BST using given array.
Note: construct BST as like we construct from normal array, because we don't know
that given preorder array is valid or not

3. After constructing BST traverse BST in preorder fashion and compare
if current data is equal to array element. if it is not equal then return false
*/


public class vit {

    static int index = 0;

    public static void main(String[] args) {

        int array[] = {40,30, 32, 35, 80, 90, 100, 120};

        System.out.println(validPreorder(array));
    }
	
	// function to check valid preorder
    public static boolean validPreorder(int[] array) {

        Nodes root = buildTree(array);
        
        return traverseAndCheck(array, root);
    }
	
	// function to build BST
    public static Nodes buildTree(int array[]) {
        Nodes root = null;

        for (int data : array) {
            root = insert(root, data);
        }
        return root;
    }

    // function to insert array element in BST according to BST property
	public static Nodes insert(Nodes root, int data) {
        if (root == null) {
            return new Nodes(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
	
	// traverse BST in preorder fashion and compare
	// if current data is equal to array element. if it is not equal then return 
	// false
	public static boolean traverseAndCheck(int []array, Nodes root){
        if (root == null){
            return true;
        }
        
        if (array[index] != root.data){
            return false;
        }
        index++;
        
        return traverseAndCheck(array, root.left) && 
                traverseAndCheck(array, root.right);
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

// Time --> O(nLogn)  Space --> O(n) for call stack
