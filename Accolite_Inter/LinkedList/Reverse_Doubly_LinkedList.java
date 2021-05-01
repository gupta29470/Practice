public static Node reverseDLL(Node  head)
{
    Node curr=head,prev_ptr=null;
    while(curr!=null){
        Node next_ptr=curr.next; // Store current next
        curr.next=prev_ptr; // Assign current next = previous
        curr.prev=next_ptr; // Assign current previous =next
        prev_ptr=curr; // Make prev= current
        curr=next_ptr; // increment current to next
    }
    head=prev_ptr; // head= last node
    return head;
}
