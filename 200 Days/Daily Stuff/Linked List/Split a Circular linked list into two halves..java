class TwoCircularHalves {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = nodes;

        twoCircularHalves(nodes);
    }
    
    
    /* Function to split a list (starting with head) into two lists. 
     head1_ref and head2_ref are references to head nodes of  
     the two resultant linked lists */
    public static void twoCircularHalves(Nodes nodes){
        
        if (nodes == null || nodes.next == null){
            return;
        }
        
        Nodes head1 = nodes, head2 = null;
        Nodes fast = nodes, slow = nodes;
        
        /* If there are odd nodes in the circular list then 
         fast_ptr->next becomes head and for even nodes  
         fast_ptr->next->next becomes head */
        while (fast.next != nodes && fast.next.next != nodes){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        /* If there are even elements in list then move fast_ptr */
        if (fast.next.next == nodes){
            fast = fast.next;
        }
        
        /* Set the head pointer of second half */
        head2 = slow.next;
        
        /* Make second half circular */
        fast.next = slow.next;
        
        /* Make first half circular */
        slow.next = nodes;
        
        printList(head1);
        printList(head2);
    }

    static void printList(Nodes node) { 
        Nodes temp = node; 
        if (node != null) { 
            do { 
                System.out.print(temp.data + " "); 
                temp = temp.next; 
            } while (temp != node); 
        }
        System.out.println("");
    } 
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}

// Time --> O(n)




class TwoCircularHalves {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = nodes;

        twoCircularHalves(nodes);
    }
    
	
	/* Function to split a list (starting with head) into two lists. 
     head1_ref and head2_ref are references to head nodes of  
     the two resultant linked lists */
    public static void twoCircularHalves(Nodes nodes){
        
        if (nodes == null){
            return;
        }
        
        Nodes head1 = nodes, head2 = null;
		// only difference is fast = node.next
        Nodes fast = nodes.next, slow = nodes;
        
		
		/* If there are even nodes in the circular list then 
         fast_ptr->next becomes head and for odd nodes  
         fast_ptr->next->next becomes head */
        while (fast.next != nodes && fast.next.next != nodes){
            fast = fast.next.next;
            slow = slow.next;
        }
        
		/* If there are odd elements in list then move fast_ptr */
        if (fast.next.next == nodes){
            fast = fast.next;
            slow = slow.next;
        }
        
		/* Set the head pointer of second half */
        head2 = slow.next;
        
		 /* Make second half circular */
        fast.next = slow.next;
		
		/* Make first half circular */
        slow.next = nodes;
        
        printList(head1);
        printList(head2);
    }

    static void printList(Nodes node) { 
        Nodes temp = node; 
        if (node != null) { 
            do { 
                System.out.print(temp.data + " "); 
                temp = temp.next; 
            } while (temp != node); 
        }
        System.out.println("");
    } 
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)