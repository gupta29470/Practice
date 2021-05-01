class Palindrome_Linked_List_Stack
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        Stack<Integer> st=new Stack<>();
        boolean ispalin=false;
        Node itr=head;
        while(itr!=null){
            st.push(itr.data);
            itr=itr.next;
        }
        while(head!=null){
        int i=st.pop();
        if(i==head.data){
            ispalin=true;
        }
        else{
            ispalin=false;
            break;
        }
        head=head.next;
        }
        return ispalin;
    }    
}

