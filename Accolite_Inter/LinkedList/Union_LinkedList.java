class Union_LinkedList
{
	public static Node findUnion(Node head1,Node head2)
	{
	   
	   Node h1=head1;
	   Node h2=head2;
	   ArrayList<Integer> arr=new ArrayList<>();
	   while(h1!=null){
	       if(!arr.contains(h1.data)){
	           arr.add(h1.data);
	       }
	       h1=h1.next;
	   }
	   while(h2!=null){
	       if(!arr.contains(h2.data)){
	           arr.add(h2.data);
	       }
	        h2=h2.next;
	   }
	   Collections.sort(arr);
	   Node res=null,curr=null;
	   for(int i=0;i<arr.size();i++){
	       Node temp=new Node(arr.get(i));
	       if(res==null){
	           res=temp;
	           curr=temp;
	       }
	       else{
	           curr.next=temp;
	           curr=temp;
	       }
	   }
	   return res;
	}
}