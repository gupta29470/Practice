class QucikSort_LinkedList
{
    public static void quickSort(Node start,Node end){
        if(start==end){
            return;
        }
        Node pivot_prev=partition(start,end);
        quicksort(start,pivot_prev);
        if(pivot_prev!=null && pivot_prev==start){
            quicksort(pivot_prev.next,end);
        }
        else if(pivot_prev!=null && pivot_prev.next!=null){
            quicksort(pivot_prev.next.next,end);
        }
    }
    static Node partition(Node start,Node end){
        if(start==end|| start==null || end==null){
            return start;
        }
        Node curr=start,pivot_prev=start;
        int pivot=end.data;
        while(start!=end){
            if(start.data<pivot){
                pivot_prev=curr;
                int temp=curr.data;
                curr.data=start.data;
                start.data=temp;
                curr=curr.next;
            }
            start=start.next;
        }
        int temp=curr.data;
        curr.data=pivot;
        end.data=temp;
        return pivot_prev;
    }
    
    
}