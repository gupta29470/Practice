/*
						Manipulate Original List
*/
class Sort {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 1);
        nodes = push(nodes, 0);
        nodes = push(nodes, 2);
        nodes = push(nodes, 0);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes sort(Nodes nodes) {
        Nodes current = nodes;
        int count0 = 0, count1 = 0, count2 = 0;
        
        while (current != null){
            if (current.data == 0){
                count0++;
            }
            else if (current.data == 1){
                count1++;
            }
            else{
                count2++;
            }
            current = current.next;
        }
        current = nodes;
        while (count0-- > 0){
            current.data = 0;
            current = current.next;
        }
        while (count1-- > 0){
            current.data = 1;
            current = current.next;
        }
        while (count2-- > 0){
            current.data = 2;
            current = current.next;
        }
        return nodes;
    }
    
    

    public static Nodes push(Nodes nodes, int data) {
        if (nodes == null) {
            nodes = new Nodes(data);
        } else {
            Nodes newNodes = new Nodes(data);
            nodes.prev = newNodes;
            newNodes.next = nodes;
            nodes = newNodes;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next, prev;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)



/*
							By changing links 
*/
class Sort {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 1);
        nodes = push(nodes, 0);
        nodes = push(nodes, 2);
        nodes = push(nodes, 0);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes sort(Nodes nodes) {
        Nodes current = nodes;

        Nodes zero = new Nodes(0), one = new Nodes(0), two = new Nodes(0);
        Nodes zeroHead = zero, oneHead = one, twoHead = two;

        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;

            } else if (current.data == 1) {
                one.next = current;
                one = one.next;

            } else {
                two.next = current;
                two = two.next;

            }
            current = current.next;
        }

        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        nodes = zeroHead.next;
        
        return nodes;
    }

    public static Nodes push(Nodes nodes, int data) {
        if (nodes == null) {
            nodes = new Nodes(data);
        } else {
            Nodes newNodes = new Nodes(data);
            nodes.prev = newNodes;
            newNodes.next = nodes;
            nodes = newNodes;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next, prev;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)
