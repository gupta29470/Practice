/*
Calculate size of linked list.
Loop till size / 2 and get middle
*/

class MiddleElement {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes middle = middleElement(nodes);
        
        System.out.println(middle.data);
    }
    
    public static Nodes middleElement(Nodes nodes){
        int size = 0;
        Nodes temp = nodes;
        
        while (temp != null){
            size++;
            temp = temp.next;
        }
        
        temp = nodes;
        
        for (int index = 0; index < size / 2; index++){
            temp = temp.next;
        }
        
        return temp;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n + n / 2)   Space --> O(1)


/*
Using fast and slow pointer
*/
class MiddleElement {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes middle = middleElement(nodes);
        
        System.out.println(middle.data);
    }
    
    public static Nodes middleElement(Nodes nodes){
        Nodes fast = nodes, slow = nodes;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)   Space --> O(1)