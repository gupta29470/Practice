/*
We simultaneously traverse both trees. Let the current internal nodes of two trees being traversed be n1 and n2 respectively. There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
1) Data of n1 and n2 is same.
2) One of the following two is true for children of n1 and n2
……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is 
isomorphic to right child of n2.
……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is 
isomorphic to left child of n2.
*/

class BinaryTree  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
         // code here.
         if (root1 == null && root2 == null){
             return true;
         }
         if (root1 == null || root2 == null){
             return false;
         }
         if (root1.data != root2.data){
             return false;
         }
         return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
         || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }
    
}    