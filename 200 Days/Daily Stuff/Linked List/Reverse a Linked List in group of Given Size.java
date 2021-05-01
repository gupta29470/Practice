/*
	********************* RECURSIVE SOLUTION ************************
*/

class ReverseKNodes {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        //nodes.next.next.next.next.next.next = nodes.next.next;
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = reverseK(nodes, 5);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes reverseK(Nodes nodes, int k){
        Nodes current = nodes, next = null, previous = null;
        int count = 0;
        
        while (current != null && count < k){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        
        if (next != null){
            nodes.next = reverseK(next, k);
        }
        return previous;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)    Space --> O(n / k) or or (n / k) + 1(recursive call stack)



/*
	********************* ITERATIVE SOLUTION ************************
*/

class ReverseKNodes {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        //nodes.next.next.next.next.next.next = nodes.next.next;
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = reverseK(nodes, 5);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes reverseK(Nodes nodes, int k) {
        Nodes root = new Nodes(0);
        root.next = nodes;
        Nodes previous = root, current = nodes;

        while (current != null) {
            Nodes tail = current;
            int index = 0;

            while (current != null && index < k) {
                current = current.next;
                index++;
            }

            previous.next = reverse(tail, k);
            previous = tail;

        }
        return root.next;
    }

    public static Nodes reverse(Nodes nodes, int k) {
        Nodes current = nodes, previous = null;

        while (current != null && k-- > 0) {
            Nodes next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n * k)



/*
	********************* ITERATIVE LEETCODE SOLUTION ************************
*/


class ReverseKNodes {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        //nodes.next.next.next.next.next.next = nodes.next.next;
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = reverseK(nodes, 5);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes reverseK(Nodes nodes, int k){
        Nodes root = new Nodes(0);
        root.next = nodes;
        Nodes previous = root, current = nodes;
        
        while (current != null){
            Nodes tail = current;
            int index = 0;
            
            while (current != null && index < k){
                current = current.next;
                index++;
            }
            
            if (index != k){
                previous.next = tail;
            }
            else{
                previous.next = reverse(tail, k);
                previous = tail;
            }
        }
        return root.next;
    }
    
    public static Nodes reverse(Nodes nodes, int k){
        Nodes current = nodes, previous = null;
        
        while (current != null && k-- > 0){
            Nodes next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n * k)