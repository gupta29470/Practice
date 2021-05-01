/*
1. Calculate length of linked list.

2. If length is odd then increment length by 1, because  If the length is odd, 
the extra node should go in the front list.

3. Create temp node and initialize with head and index variable initialize with 1,
beacuse head is already initialize with temp node

4. while loop till (len / 2) and move temp to next node and increment index

5. Initialize head1 = head and head2 = temp.next and make temp.next = null.

*/

class FrontBackSplit {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        //nodes.next.next.next.next.next.next.next = new Nodes(8);

        frontBackSplit(nodes);
    }
	
    public static void frontBackSplit(Nodes nodes) {
        Nodes head1 = nodes;
        Nodes head2 = null;

        int size = 0;
        Nodes temp = nodes;
        
        while (temp != null){
            size++;
            temp = temp.next;
        }
        
        size = (size % 2 != 0)? size + 1 : size;
        int index = 1;
        temp = nodes;
        while(index < (size / 2)){
            temp = temp.next;
            index++;
        }
        
		// Now cut at temp
        head1 = nodes;
        head2 = temp.next;
        temp.next = null;
        
        while (head1 != null){
            System.out.print(head1.data + " ");
            head1 = head1.next;
        }
        System.out.println();
        while (head2 != null){
            System.out.print(head2.data + " ");
            head2 = head2.next;
        }
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(2n)   Space --> O(n)




/*
Using Fast and Slow pointer.

1. Initialize fast with head.next and slow with head.

2. Move slow pointer to middle of linked list using while loop and 
fast = fast.next.next and slow = slo.next

3. Initialize head1 = head and head2 = slow.next and make slow.next = null.
*/
class FrontBackSplit {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        //nodes.next.next.next.next.next.next.next = new Nodes(8);

        frontBackSplit(nodes);
    }


	/*
        Split the given list's nodes into front and back halves,
        and return the two lists using an array.
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow reference strategy
    */
	
    public static void frontBackSplit(Nodes nodes) {
        Nodes head1 = nodes;
        Nodes head2 = null;

        Nodes fast = nodes.next, slow = nodes;

        while (fast != null && fast.next != null) {
            if (fast != null){
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        
		// `slow` is before the midpoint in the list, so split it in two
        // at that point.
        head2 = slow.next;
        slow.next = null;
        
        while (head1 != null){
            System.out.print(head1.data + " ");
            head1 = head1.next;
        }
        
        System.out.println("A");
        
        while (head2 != null){
            System.out.print(head2.data + " ");
            head2 = head2.next;
        }
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)  Space --> O(n)