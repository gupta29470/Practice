class MergeSort_LinkedList
{
    static Node mergeSort(Node head)
    {
       if(head==null || head.next==null){
           return head;
       }
       Node middle=getMiddle(head);
       Node middleNext=middle.next;
       middle.next=null;
       Node left=mergeSort(head);
       Node right=mergeSort(middleNext);
       Node sort=sortMerge(left,right);
       return sort;
    }
    static Node getMiddle(Node head){
        if(head==null){
            return head;
        }
        Node fast=head, slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node sortMerge(Node a,Node b){
        Node result=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<b.data){
            result=a;
            result.next=sortMerge(a.next,b);
        }
        else{
            result=b;
            result.next=sortMerge(a,b.next);
        }
        return result;
    }
}


