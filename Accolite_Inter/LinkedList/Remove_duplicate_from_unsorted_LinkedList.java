class Remove_duplicate_from_unsorted_LinkedList
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
         Node curr=head,prev=null;
         HashSet<Integer>set=new HashSet<>();
         while(curr!=null){
             int val=curr.data;
             if(set.contains(curr.data)){
                 prev.next=curr.next;
             }
             else{
                 set.add(val);
                 prev=curr;
             }
             curr=curr.next;
         }
         return head;
    }
}