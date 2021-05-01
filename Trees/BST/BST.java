import java.io.*;
import java.util.*;

public class BST {

    static Node root;
    static Node pre;
    static Node suc;

    public static void main(String[] args) throws IOException {
        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(70);
        insert(60);
        insert(80);
        if (search(root, 30)) {
            System.out.println("Yes found it");
        } else {
            System.out.println("Not found");
        }
        delete(30);
        if (search(root, 30)) {
            System.out.println("Yes found it");
        } else {
            System.out.println("Not found");
        }
        System.out.print("Level Order:");
        levelOrderTraversal(root);
        System.out.println("");
        System.out.print("Preorder:");
        preorder(root);
        System.out.println("");
        System.out.print("Inorder:");
        Inorder(root);
        System.out.println("");
        System.out.print("Postorder:");
        Postorder(root);
        System.out.println("");

        if (isbsttree()) {
            System.out.println("Tree is BST");
        } else {
            System.out.println("Not a BST");
        }
        int key=70;
        inorder_predecessor_successor(root,key);
        if(pre!=null){
            System.out.println("Predecessor of "+key+" is:"+pre.data);
        }
        else{
            System.out.println("-1");
        }
        if(suc!=null){
            System.out.println("Successor of "+key+" is:"+suc.data);
        }
        else{
            System.out.println("-1");
        }
        System.out.println("");
        System.out.println(findmin());
        System.out.println(findmax());
        
        printroot_to_leadf(root);
        
     

    }

    static Node insertdata(Node root, int data) {
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=insertdata(root.left,data);
        }
        else if(data>root.data){
            root.right=insertdata(root.right,data);
        }
        return root; 
    }
        

    static void insert(int data) {
        root = insertdata(root, data);
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
        
    }

    static int minval(Node root) {
        int min=root.data;
        while(root.left!=null){
            min=root.data;
            root=root.left;
        }
        return min;
    }

    static Node deletedata(Node root, int data) {
       if(root==null){
           return root;
       }
       if(data<root.data){
           root.left=deletedata(root.left,data);
       }
       else if(data>root.data){
           root.right=deletedata(root.right,data);
       }
       else{
           //Node with one child
           if(root.left==null)
               return root.right;
           else if(root.right==null)
               return root.left;
           
           //Node with 2 child
           // It assigns min leaf value with no children from right side to deleted data
           root.data=minval(root.right);
           //delete min leaf value
           root.right=deletedata(root.right,root.data);
       }
       return root;
    }

    static void delete(int data) {
        root=deletedata(root,data);
    }

    static void levelOrderTraversal(Node root) {
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    static void Postorder(Node root) {
        if (root == null) {
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }

    static boolean search(Node root, int data) {
        if(root==null)
            return true;
        while(root!=null){
        if(root.data<data)
            root=root.right;
        else if(root.data>data)
            root=root.left;
        else if(root.data==data)
            return true;
        }
        return false;
    }

    static boolean isbst(Node root, int min, int max) {
        if(root==null)
            return true;
        if(root.data<min || root.data>max)
            return false;
        return (isbst(root.left,min,root.data-1) && isbst(root.right,root.data+1,max));
    }
//
    static boolean isbsttree() {
        return isbst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static void inorder_predecessor_successor(Node root, int data) {
        if(root==null)
            return;
        while(root!=null){
            if(root.data==data){
                if(root.right!=null){
                    suc=root.right;
                    while(suc.left!=null){
                        suc=suc.left;
                    }
                }
                if(root.left!=null){
                    pre=root.left;
                    while(pre.right!=null){
                        pre=pre.right;
                    }
                }
               return; 
            }
            else if(data<root.data){
                suc=root;
                root=root.left;
            }
            else if(data>root.data){
                pre=root;
                root=root.right;
            }
            
        }
    }
    static void print_array(int a[],int len){
        for(int i=0;i<len;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
//    
    static void printrecur(Node root,int a[],int len ){
        if(root==null)
            return;
        a[len]=root.data;
        len++;
        if(root.left==null && root.right==null)
            print_array(a,len);
        printrecur(root.left,a,len);
        printrecur(root.right,a,len);
    }
    
    static void printroot_to_leadf(Node root){
        int a[]=new int[100];
        printrecur(root,a,0);
    }
    
    static int findmin(){
        Node temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp.data;
    }
    static int findmax(){
        Node temp=root;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp.data;
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
