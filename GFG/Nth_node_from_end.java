public class Nth_node_from_end {
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
    void nth_node(int n){
        Node first=head,second=head;
        int count=0;
        if(head!=null){
            while(count<n){
                if(first==null){
                    System.out.println("Out of reach");
                }
                first=first.next;
                count++;
            }
            while(first!=null){
                first=first.next;
                second=second.next;
            }
            System.out.println("Nth node from end is:"+second.data);
        }
        
        
    }
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        };
    }
    public static void main(String[] args) {
        Nth_node_from_end p=new Nth_node_from_end();
        p.push(81);
        p.push(82);
        p.push(83);
        p.push(84);
        p.push(85);
        p.push(86);
        p.end(86);
        p.print();
        p.nth_node(3);
        
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
