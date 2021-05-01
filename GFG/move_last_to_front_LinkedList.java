void move_front(){
        Node last=head,seclast=null;
        while(last.next!=null){
            seclast=last;
            last=last.next;
        }
        last.next=head;
        head=last;
        seclast.next=null;