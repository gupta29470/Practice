/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

//import java.io.*;
import java.util.*;

public class test {

    public static void main(String args[]) {
        Node head = null;
        head = insert(head, 8);
        head = insert(head, 56);
        head = insert(head, 12);
        head = insert(head, 2);
        head = insert(head, 6);
        head = insert(head, 3);

        head = K_sort(head, 3);
        printList(head);
        
    }

    static class Node {

        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    static Node insert(Node head, int data) {
        Node newnode = new Node(data);
        newnode.data = data;
        newnode.next = newnode.prev = null;
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        return head;
    }

    static Node K_sort(Node head, int k) {
        if (head == null) {
            return head;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.data > b.data) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
        Node newHead=null,last=null;
        for(int i=0;i<=k;i++){
            pq.add(head);
            head=head.next;  
        }
        while(!pq.isEmpty()){
            if(newHead==null){
                newHead=pq.peek();
                newHead.prev=null;
                last=newHead;
            }
            else{
                last.next=pq.peek();
                pq.peek().prev=last;
                last=pq.peek();
            }
            pq.poll();
            if(head!=null){
                pq.add(head);
                head=head.next;
            }
        }
        last.next=null;
        return newHead;   
    }

    static void printList(Node node) {
        while (node != null && node.next != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        if (node != null) {
            System.out.print(node.data);
        }
    }

}
