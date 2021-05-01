class Remove_duplicate_from_sorted_LinkedList
{
    // head: head node
    Node removeDuplicates(Node root)
    {
	    if(root==null || root.next==null){
	        return root;
	    }	
	    Node curr=root;
	    while(curr!=null && curr.next!=null){
	        if(curr.data==curr.next.data){
	            curr.next=curr.next.next;
	        }
	        else{
	            curr=curr.next;
	        }
	    }
	    return root;
    }
}
