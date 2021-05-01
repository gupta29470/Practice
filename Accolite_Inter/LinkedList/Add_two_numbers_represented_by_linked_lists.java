class Add_two_numbers_represented_by_linked_lists {
    static Node addLists(Node first, Node second){
        Node head=new Node(0);
        Node a=reverse(first);
        Node b=reverse(second);
        Node curr=head;
        int carry=0,sum;
        while(a!=null || b!=null){
            int m=(a!=null?a.data:0);
            int n=(b!=null?b.data:0);
            sum=m+n+carry;
            carry=(sum>9)?1:0;
            sum=sum%10;
            curr.next=new Node(sum);
            curr=curr.next;
            a=(a==null?a:a.next);
            b=(b==null?b:b.next);
        }
        if(carry>0){
            curr.next=new Node(carry);
        }
        Node finalHead=reverse(head.next);
        return finalHead;
    }
    static Node reverse(Node head){
        Node curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}