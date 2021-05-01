class Add_1_to_a_number_represented_as_linked_list
{
    public static Node addOne(Node head) 
    { 
        int carry=giveCarry_or_addOneToList(head);
        if(carry==1){
            Node temp=new Node(carry);
            temp.next=head;
            head=temp;
        }
        return head;
    }
    static int giveCarry_or_addOneToList(Node head){
        if(head==null){
            return 1;
        }
        int res=head.data+giveCarry_or_addOneToList(head.next);
        head.data=res%10;
        return res=res/10;
    }
}
