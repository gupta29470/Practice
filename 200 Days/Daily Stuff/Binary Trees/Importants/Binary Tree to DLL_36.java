/*
1. Create head and previous object of Nodes.
	-> head = head of doubly linked list
	-> previous = previous element of linked list and helps to build linked list
2. We traverse in inorder fashion
	-> traverse left
	-> check if head is null means current element is first element; else 
	current left will be previous element and previous right will be current element
	-> updating previous
	-> traverse right
*/



public class vit {

    // head = head of doubly linked list
    // previous = previous element of linked list and helps to build linked list
    static Nodes head = null, previous = null;

    public static void main(String[] args) {

        /* Construct below BST
                  5
                /    \
               /      \
              3        8
             /  \     /  \
            /    \   /    \
           4      2  6    10
         */
        Nodes root = new Nodes(5);
        root.left = new Nodes(3);
        root.right = new Nodes(8);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(2);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(10);

        convertbtToDLL(root);
        display();
    }

    public static void convertbtToDLL(Nodes root) {

        if (root == null) {
            return;
        }

        convertbtToDLL(root.left); // traverse left

        if (head == null) { // head is null means current element is first element
            head = root;
        } else {
            root.left = previous; // current left will be previous element
            previous.right = root; // previous right will be current element
        }

        previous = root; // updating previous

        convertbtToDLL(root.right); // traverse right
    }

    public static void display() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }

        Nodes current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

}

class Index {

    int index = 0;
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

// Time --> O(n)    Space --> O(h)