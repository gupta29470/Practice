package javaapplication1;

import java.util.*;

/**
 *
 * @author Aakash
 */
public class doubly_linkeedlist_operations_and_convert_circular {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        JavaApplication1 li = new JavaApplication1();
        LinkedList l=new LinkedList();
        boolean flag=true;
        while (flag) {
            System.out.println("");
            System.out.println("1.Insert at begin\n2.Insert at given pos\n3.Insert at last\n4.Delete at first\n5.Delete at given pos\n6.Delete at last\n7.print at forward\n8.print at backward\n9.Exit");
            System.out.println("Enter your choice:");
            System.out.println("");
            int choice = sc.nextInt();
            int pos;
            int data;
            switch (choice) {
                case 1:
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    l.insert_at_first(data);
                    break;
                case 2:
                    System.out.println("Enter pos:");
                    pos = sc.nextInt();
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    l.insert_at_pos(pos, data);
                    break;
                case 3:
                    System.out.println("Insert data:");
                    data = sc.nextInt();
                    l.insert_at_end(data);
                    break;
                case 4:
                    l.delete_at_first();
                    break;
                case 5:
                    System.out.println("Enter position:");
                    pos = sc.nextInt();
                    l.delete_at_pos(pos);
                    break;
                case 6:
                    l.delete_at_end();
                    break;
                case 7:
                    l.print_forward();
                    break;
                case 8: 
                   l.print_backward();
                    break;
                case 9:
                    flag=false;
                    
                    
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}

class Node {

    private int data;
    private Node next; //reference of node
    private Node prev;

    public Node() {
        data = 0;
        next = null;
        prev=null;
    }

    public Node(int data, Node next,Node prev) {
        this.data = data;
        this.next = next;
        this.prev=prev;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
    public void setPrev(Node prev){
        this.prev=prev;
    }
    public Node getPrev(){
        return prev;
    }
    

    
}

class LinkedList {

    private int size;
    private Node start;
    private Node end;

    LinkedList() {
        size = 0;
        start = null;
        end=null;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getListsize() {
        return size;
    }

    public void print_forward() {
        Node temp = start;
        if (isEmpty()) {
            System.out.println("No elements in list");
        }
        for(int i=1;i<=size;i++){
            System.out.print(temp.getData()+" ---> ");
            temp=temp.getNext();
        }
        System.out.println("null");
    }
    public void print_backward() {
        Node temp = end;
        if (isEmpty()) {
            System.out.println("No elements in list");
        }
        
      for(int i=size;i>=1;i--){
          
           System.out.print(temp.getData()+" ---> ");
           temp=temp.getPrev();
       }
       System.out.println("null");
    }

    public void size() {
        System.out.println(size);
    }

    public void insert_at_first(int data){
        
        Node newnode=new Node();
        if(isEmpty()){
            
            end=newnode;
        }
        else{
            start.setPrev(newnode);
        }
        newnode.setData(data);
        newnode.setNext(start);
        start=newnode;
        size++;
        
    }
    public void insert_at_end(int data){
        Node newnode=new Node();
        if(isEmpty()){
            start=newnode;
        }
        else{
            end.setNext(newnode);
            newnode.setPrev(end);
        }
        newnode.setData(data);
        end=newnode;
        size++;
    }
    
    public void insert_at_pos(int pos,int data){
        if(pos==1){
            insert_at_first(data);
        }
        else if(pos==size+1){
            insert_at_end(data);
        }
        else if(pos>1 || pos<size){
            Node newnode=new Node(data,null,null);
            Node temp=start;
            for(int i=1;i<pos-1;i++){
                temp=temp.getNext();
            }
            newnode.setNext(temp.getNext());
            newnode.setPrev(temp);
            temp.getNext().setPrev(newnode);
            temp.setNext(newnode);
            size++;
           
            
        }
        else{
            System.out.println("Insertion not possible");
        }
    } 
    public void delete_at_first(){
        if(start==null){
            System.out.println("Deletion not possible");
        }
        else{
            start=start.getNext();
            size--;
        }
    }
    public void delete_at_end(){
        if(start==null){
            System.out.println("Deletion not possible");
        }
        else if(size==1){
            start=null;
            
            size--;
        }
        else{
            Node temp=start;
            for(int i=1;i<size-1;i++){
                temp=temp.getNext();
            }
            temp.setNext(null);
            size--;
        }
    }
    public void delete_at_pos(int pos){
        if(pos==1){
            delete_at_first();
        }
        else if(pos==size){
            delete_at_end();
    }
        else if(pos<1 || pos>size){
            System.out.println("Deletion not possible");
        }
        Node temp=start;
        for(int i=1;i<pos-1;i++){
            temp=temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        temp.getNext().getNext().setPrev(temp);
        size--;
    }
    public void  circular(){
        Node temp=start;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(start);
        start.setPrev(temp);
    }
}
