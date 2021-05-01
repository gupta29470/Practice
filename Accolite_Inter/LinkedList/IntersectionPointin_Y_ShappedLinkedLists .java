class IntersectionPointin_Y_ShappedLinkedLists 
{
	int intersectPoint(Node headA, Node headB)
	{
         Node a=headA; int ans=-1;
         while(a!=null){
             if(a.data==0){
                 a.data=Integer.MAX_VALUE;
                 a=a.next;
             }
             else{
                 a.data=(-1)*a.data;
                 a=a.next;
             }
         }
         Node b=headB;
         while(b!=null){
             if(b.data<0){
                 return Math.abs(b.data);
             }
             else if(b.data==Integer.MAX_VALUE){
                 return 0;
             }
             b=b.next;
         }
         return -1;
	}
}


