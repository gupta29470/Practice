/*
Traverse the list one by one and keep putting the node addresses in a Hash Table. 
At any point, if NULL is reached then return false and if next of current node 
points to any of the previously stored nodes in Hash then return true. 
*/

import java.util.*;

class DetectLoop {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = nodes;
        //nodes.next.next.next.next.next.next = new Nodes(7);

        System.out.println(detectLoop(nodes));
    }
    
    public static boolean detectLoop(Nodes nodes) {
        Set<Nodes> set = new HashSet<>();
        Nodes current = nodes;

        while (current != null){
            if (set.contains(current)){
                return true;
            }
            set.add(current);
            current = current.next;
        }
        return false;
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



/*
Floyd’s Cycle-Finding Algorithm 
Approach: This is the fastest method and has been described below:  

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two.
If these pointers meet at the same node then there is a loop. 
If pointers do not meet then linked list doesn’t have a loop.

Why this works:
Imagine fast is just behind slow then in next iteration fast and slow will meet 
and if fast and slow meet it means we detect cycle, but it is wrong, if the linked
list is linear, it will give answer that list has cycle


If we take fast 2 steps behind slow or 3 steps or n steps behind slow it will 
meet and give wrong answer
*/
class DetectLoop {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = nodes;
        //nodes.next.next.next.next.next.next = new Nodes(7);

        System.out.println(loop(nodes));
    }
    
    public static boolean loop(Nodes nodes){
        Nodes fast = nodes, slow = nodes;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}

