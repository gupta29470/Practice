/*
*************************** ITERATIVE *************************************
1. if root is null then root = new Nodes(data) return root
2. Create current = root and parentOfCurrent = null(current is current node of 
tree and parent is current node of parent)
3. We have to insert element at the end means at leaf node
4. while current is not null we update parentofCurrent = current then move
current left or right based on data
5. once current point to null in parent we have leaf node to we insert at parent 
on left or right based on data
*/

public class vit {

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
        
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        Nodes root = null;
        
        for (int data : keys){
            root = insert(root, data);
        }
        
        inorder(root);
    }
    
    public static Nodes insert(Nodes root, int data){
         
        if (root == null){
            root = new Nodes(data);
            return root;
        }
		
		Nodes current = root, parentOfCurrent = null;
   
        while (current != null){
            parentOfCurrent = current;
            
            if (data < current.data){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        
        if (data < parentOfCurrent.data){
            parentOfCurrent.left = new Nodes(data);
        }
        else{
            parentOfCurrent.right = new Nodes(data);
        }
        return root;
    }

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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


// *********************** RECURSIVE ******************************
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
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Nodes root = null;

        for (int data : keys) {
            root = insert(root, data);
        }

        inorder(root);
    }

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

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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
