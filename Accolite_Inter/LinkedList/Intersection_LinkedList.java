class Intersection_LinkedList
{
    static Node findIntersection(Node head1, Node head2)
    {
        HashSet<Integer> set=new HashSet<>();
        Node h1=head1,h2=head2;
        while(h2!=null){
            set.add(h2.data);
            h2=h2.next;
        }
        Node res=null,curr=null;
        while(h1!=null){
            if(set.contains(h1.data)){
                Node temp=new Node(h1.data);
                if(res==null){
                    res=temp;
                    curr=temp;
                }
                else{
                    curr.next=temp;
                    curr=temp;
                }
            }
            h1=h1.next;
        }
        return res;
    }
}
