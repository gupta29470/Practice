/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Aakash
 */
import java.io.*;
import java.util.*;

public class prati {

    static Node root;
    static Node pre;
    static Node suc;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        root = new Node(10); 
//        root.left = new Node(11); 
//        root.left.left = new Node(7); 
//        root.right = new Node(9); 
//        root.right.left = new Node(15); 
//        root.right.right = new Node(8); 
//        System.out.println("Inorder");
//        inorder(root);
//        insert(root,25);
//        System.out.println("Inorder");
//        inorder(root);
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
//        root.right.left = new Node(6); 
//        root.right.right = new Node(7); 

//        prati p = new prati();
//        int a[] = {1, 2, 3, 4, 5,6,7,8,9};
//        root = insert_from_array(root, a, 0);
        System.out.println("");
        inorder(root);
        System.out.println("");
        levelorder(root);
        //delete(root, 7);
        //delete(root, 6);
        System.out.println("");
        levelorder(root);
        System.out.println("");
        if (search(root, 9)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println("Preorder");
        preorder(root);
        System.out.println("");
        System.out.println("Iterative Preorder");
        iterpreorder(root);
        System.out.println("");
        System.out.println("Iterative Inorder");
        inorderiter(root);
        System.out.println("");
        System.out.println("Reverse Level Order");
        reverselevelorder(root);
        System.out.println("");
        System.out.println("Height of a tree ");
        System.out.println(height(root));
        System.out.println("Height of a tree Recursion");
        System.out.println(heightrecur(root));
        max_min(root);
        System.out.println("Max");
        System.out.println(max);
        System.out.println("Min");
        System.out.println(min);
        System.out.println("Diameter");
        System.out.println(diameter(root));
        System.out.println("Mirror Recursion");
        mirrorrecur(root);
        System.out.println("Preorder");
        inorder(root);

    }

//    static void insert(Node root,int data){
//        if(root==null){
//            root=new Node(data);
//            return;
//        }
//        Queue<Node> q=new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            Node temp=q.poll();
//            if(temp.left==null){
//                temp.left=new Node(data);
//                break;
//            }
//            else{
//                q.add(temp.left);
//            }
//            if(temp.right==null){
//                temp.right=new Node(data);
//                break;
//            }
//            else{
//                q.add(temp.right);
//            }
//        }
//    }
    static Node insert_from_array(Node root, int a[], int i) {
        if (i < a.length) {
            Node temp = new Node(a[i]);
            root = temp;
            root.left = insert_from_array(root.left, a, 2 * i + 1); // left child insert in odd position
            root.right = insert_from_array(root.right, a, 2 * i + 2); // right child in even position
        }
        return root;

    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }

        }
    }

    static void deletedeep(Node root, Node data) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == data) {
                temp = null;
                q.remove(data);
                return;
            }
            if (temp.left != null) {
                if (temp.left == data) {
                    temp.left = null;
                    q.remove(data);
                    return;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == data) {
                    temp.right = null;
                    q.remove(data);
                    return;
                } else {
                    q.add(temp.right);
                }
            }
        }

    }

    static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.data == data) {
                return null;
            } else {
                return root;
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keynode = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == data) {
                keynode = temp;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        if (keynode != null) {
            int x = temp.data;
            deletedeep(root, temp);
            keynode.data = x;
        }
        return root;
    }

    static boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.data == data) {
                return true;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return false;
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    static void iterpreorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            //preorder=Root,left,right;
            // here after root right because we have to pop left first stack is LIFO
            // So we entering left element last to pop first
            if (temp.right != null) {
                st.add(temp.right);
            }
            if (temp.left != null) {
                st.add(temp.left);
            }
        }
    }

    static void inorderiter(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while (!st.isEmpty() || temp != null) {
            if (temp != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                temp = st.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }

        }
    }

    static void reverselevelorder(Node root) {
        if (root == null) {
            return;
        }
        Node n = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            n = q.poll();
            st.push(n.data);
            if (n.right != null) {
                q.add(n.right);
            }
            if (n.left != null) {
                q.add(n.left);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
    }

    static int heightrecur(Node root) {
        int h=0;
        if (root == null) {
            return 0;
        }
//        } else {
//            int leftdep = heightrecur(root.left);
//            int rightdep = heightrecur(root.right);
//            if (leftdep > rightdep) {
//               h=leftdep + 1;
//            } else {
//                h= rightdep + 1;
//            }
//        }
        return Math.max(1+heightrecur(root.left), heightrecur(root.right));

    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0, height = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (1 == 1) {
            count = q.size();
            if (count == 0) {
                return height;
            }
            height++;
            while (count-- > 0) {
                Node temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    static void max_min(Node root) { //using preorder
        if (root == null) {
            return;
        }
        if (root.data > max) {
            max = root.data;
        }
        if (root.data < min) {
            min = root.data;
        }
        max_min(root.left);
        max_min(root.right);

    }
    static int diameter(Node root) {
        if (root == null) {
            return 0;
        } 
        int lheight=heightrecur(root.left);
        int rheight=heightrecur(root.right);
        int ldiameter=diameter(root.left);
        int rdiameter=diameter(root.right);
        int res=Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
        return res;
    }
    static Node mirrorrecur(Node root){
        if(root==null)
            return root;
        Node left=mirrorrecur(root.left);
        Node right=mirrorrecur(root.right);
        root.left=right;
        root.right=left;
        
        return root;
    }
    static void mirror(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            Node temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;
            
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }


}

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
