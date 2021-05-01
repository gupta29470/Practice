class Palindrome_LinkedList_Efficient_MainFunction
{
     Node slow=null,fast=null,secondhead=null;
     boolean res=true;
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        slow=head;fast=head;
        Node prevOfSlow=head,midnode=null;
        if(head!=null && head.next!=null){
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                prevOfSlow=slow;
                slow=slow.next;
            }
            if(fast!=null){
                midnode=slow;
                slow=slow.next;
            }
            secondhead=slow;
            prevOfSlow.next=null;
            reverse();
            res=compare(head,secondhead);
            if(midnode!=null){
                prevOfSlow.next=midnode;
                midnode.next=secondhead;
            }
            else{
                prevOfSlow.next=secondhead;
            }
        }
            return res;
    }
        void reverse(){
            Node curr=secondhead,prev=null,next=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            secondhead=prev;
        }
        boolean compare(Node head1,Node head2){
            Node temp1=head1,temp2=head2;
            while(temp1!=null && temp2!=null){
                if(temp1.data==temp2.data){
                    temp1=temp1.next;
                    temp2=temp2.next;
                }
                else{
                    return false;
                }
            }
            if(temp1==null && temp2==null){
                return true;
            }
            return false;
        }
        
        
    
}