class Find_nth_node_from_end_LinkedList
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
        if(head==null){
            return -1;
        }
    	Node first=head,second=head;
    	for(int i=0;i<n;i++){
    	    if(first==null){
    	        return -1;
    	    }
    	    first=first.next;
    	}
    	while(first!=null){
    	    first=first.next;
    	    second=second.next;
    	}
    	return second.data;
    }
}
