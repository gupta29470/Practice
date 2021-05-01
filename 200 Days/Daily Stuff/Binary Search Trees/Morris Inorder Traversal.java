/* 
1. Initialize current as root 
2. While current is not NULL
   If the current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Find rightmost node(predecessor) in current left subtree OR
              node whose right child == current.
         If we found right child == current
             Go to the right, i.e. current = curent->right
         Else
             a) Make current as the right child of that rightmost 
                node we found; and 
             b) Go to this left child, i.e., current = current->left
   
   */
class tNode {
    int data;
    tNode left, right;
 
    tNode(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree {
    tNode root;
 
    /* Function to traverse a 
       binary tree without recursion
       and without stack */
    void MorrisTraversal(tNode root)
    {
        tNode current, pre;
 
        if (root == null)
            return;
 
        current = root;
        while (current != null) 
        {
            if (current.left == null) 
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
                /* Find the inorder 
                    predecessor of current
                 */
                pre = current.left;
                while (pre.right != null
                       && pre.right != current)
                    pre = pre.right;
 
                /* Make current as right 
                   child of its
                 * inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
 
                /* Revert the changes made
                   in the 'if' part
                   to restore the original 
                   tree i.e., fix
                   the right child of predecessor*/
                else
                {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL
                   */
 
            } /* End of if condition current->left == NULL*/
 
        } /* End of while */
    }
 
    // Driver Code
    public static void main(String args[])
    {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /   \
         4     5
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
 
        tree.MorrisTraversal(tree.root);
    }
}

// Time --> O(n)   Space --> O(1)
 