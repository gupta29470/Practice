class Split_a_Circular_Linked_List_into_two_halves
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {
             Node first=list.head,second=list.head;
             while(first.next!=list.head && first.next.next!=list.head){
                 first=first.next.next;
                 second=second.next;
             }
             if(first.next.next==list.head){
                 first.next=first.next.next;
             }
             Node head1=list.head,head2=null;
             if(list.head.next!=list.head){
                 head2=second.next;
             }
             first.next=second.next;
             second.next=list.head;
	    }
}