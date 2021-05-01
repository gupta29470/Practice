public class reverse_a_linked_list {
    Node head;
    prat(){
        head=null;
    }
    void push(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        
    }
    void middle(){
        Node first=head,second=head;
        while(first!=null){
            first=first.next.next;
            second=second.next;
        }
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
            System.out.println(second.key);
        }
    }
    void reverse(){
        Node temp=head,prev=null;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
    }
    void recursive_reverse(Node temp,Node prev){
        if(temp==null)
            return;
        if(temp.next==null){
            head=temp;
            temp.next=prev;
            return;
        }
        Node next=temp.next;
        prev=temp;
        recursive_reverse(next,temp);
        
    }
    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.key+" ");
            temp=temp.next;
        };
    }
    public static void main(String[] args) {
        
        prat p=new prat();
        p.push(81);
        p.push(82);
        p.push(83);
        p.push(84);
        p.push(85);
        p.push(86);
        p.print();
        System.out.println("");
        p.reverse();
       p.print();
     p.recursive_reverse(null, null);
        p.print();
    }
    
}
class Node{
    int key;
    Node next;
    Node(){
        key=0;
        next=null;
    }
    Node(int key){
        this.key=key;
        next=null;
    }
}
