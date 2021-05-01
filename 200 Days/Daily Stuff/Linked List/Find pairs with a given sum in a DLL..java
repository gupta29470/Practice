/*************************** Linked List is Sorted ***********************/

/*
Using two loops
*/
class Pair {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 7);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        pair(nodes, 7);
    }

    public static void pair(Nodes nodes, int sum) {

        Nodes current1 = nodes;
        while (current1 != null){
            Nodes current2 = current1.next;
            while (current2 != null){
                if (current1.data + current2.data == sum){
                    System.out.println("(" + current1.data + ", " + current2.data + ")");
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }
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
// Time --> O(n ^ 2)



/*
Using Hash Set.
Loop Linked List if set contains sum - current data then print else add in set
and advance pointer.
*/

import java.util.*;

class Pair {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 7);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        pair(nodes, 7);
    }

    public static void pair(Nodes nodes, int sum) {
        Set<Integer> set = new HashSet<>();

        Nodes temp = nodes;

        while (temp != null) {
            if (set.contains(sum - temp.data)) {
                System.out.println("(" + temp.data + ", " + (sum - temp.data) + ")");
            }
            else{
                set.add(temp.data);
            }
            temp = temp.next;
        }
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
// Time --> O(n)   Space --> O(n)




/*
Using two pointers.
start and end are two pointers will be initialize at start and end of list.

if start + end == sum then print
else if start + end < sum advance start
else if start + end > sum retreat end
*/
class Pair {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 7);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        pair(nodes, 7);
    }

    public static void pair(Nodes nodes, int sum) {

        Nodes start = nodes;
        Nodes end = nodes;
        
        while (end.next != null){
            end = end.next;
        }
        
        while (start != null && end != null && start != end){
            if (start.data + end.data == sum){
                System.out.println("(" + start.data + ", " + end.data + ")");
                start = start.next;
                end = end.prev;
            }
            else if (start.data + end.data < sum){
                start = start.next;
            }
            else{
                end = end.prev;
            }
        }
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
// Time --> O(2n)  
