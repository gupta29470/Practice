package javaapplication1;

import java.util.*;

public class AVL_insert_delete {

    static Nodee root;

    public static void main(String[] args) {
        AVL_insert_delete j = new AVL_insert_delete();
        j.root = j.insert(j.root, 10);
        j.root = j.insert(j.root, 20);
        j.root = j.insert(j.root, 30);
        j.root = j.insert(j.root, 40);
        j.root = j.insert(j.root, 50);
        j.root = j.insert(j.root, 25);
        j.preorder(j.root);
        delete(j.root,25);
        System.out.println("");
        j.preorder(j.root);

    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int height(Nodee root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    static Nodee rotateRight(Nodee rot) {
        Nodee newrot = rot.left;
        Nodee temp = newrot.right;

        newrot.right = rot;
        rot.left = temp;

        rot.height = max(height(rot.left), height(rot.right)) + 1;
        newrot.height = max(height(newrot.left), height(newrot.right)) + 1;

        return newrot;
    }

    static Nodee rotateLeft(Nodee rot) {
        Nodee newrot = rot.right;
        Nodee temp = newrot.left;

        newrot.left = rot;
        rot.right = temp;

        rot.height = max(height(rot.left), height(rot.right)) + 1;
        newrot.height = max(height(newrot.left), height(newrot.right)) + 1;

        return newrot;
    }

    static int getbalance(Nodee root) {
        if (root == null) {
            return 0;
        }
        return (height(root.left) - height(root.right));
    }

    static Nodee insert(Nodee root, int data) {
        if (root == null) {
            return (new Nodee(data));
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }
         else {
            return root;
        }
//        
        root.height = 1 + max(height(root.left), height(root.right));
        int balance = getbalance(root);

        if (balance > 1 && data < root.left.data) {
            return rotateRight(root);
        }
        if (balance < -1 && data > root.right.data) {
            return rotateLeft(root);
        }
        if (balance > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }
    
    static Nodee minval(Nodee root){
        Nodee min=root;
        while(root.left!=null){
            min=root.left;
        }
        return min;
    }
    static Nodee delete(Nodee root,int data){
       if(root==null)
           return root;
       if(data<root.data){
           root.left=delete(root.left,data);
       }
       else if(data>root.data){
           root.right=delete(root.right,data);
       }
       else{
           if((root.left==null)|| (root.right==null)){
               Nodee temp=null;
               if(temp==root.left){
                   temp=root.right;
               }
               else{
                   temp=root.left;
               }
               if(temp==null){
                   temp=root;
                   root=null;
               }
               else{
                   root=temp;
               }
           }
           else{
              Nodee temp=minval(root.right);
              root.data=temp.data;
              root.right=delete(root.right,temp.data);
           }
       }
        if(root==null)
            return null;
        root.height = 1 + max(height(root.left), height(root.right));
        int balance = getbalance(root);

        if (balance > 1 && data < root.left.data) {
            return rotateRight(root);
        }
        if (balance < -1 && data > root.right.data) {
            return rotateLeft(root);
        }
        if (balance > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
        
    }

    static void preorder(Nodee root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

class Nodee {

    int data, height;
    Nodee left, right;

    Nodee(int data) {
        this.data = data;
        height = 1;
    }
}
