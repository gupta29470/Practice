public class Middle-of_LinkedList {
    Node head;
    prat(){
        head=null;
    }
    void push(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;    
    }
    void end(int data){
        Node newnode=new Node(data);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
    }
    void middle(){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("Middle is:"+slow.data);
    }
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        };
    }
    public static void main(String[] args) {
        Middle-of_LinkedList p=new Middle-of_LinkedList();
        p.push(81);
        p.push(82);
        p.push(83);
        p.push(84);
        p.push(85);
        p.push(86);
        p.end(86);
        p.print();
        p.middle();
        
    }
    
}
class Node{
    int data;
    Node next;
    Node(){
        data=0;
        next=null;
    }
    Node(int data){
        this.data=data;
    }
}
