/*
Using hash set. 
Create two pointers previous and current. 
Initialize previous with head.
Add previous in set.
Initialize current with head.next
Check if current present in set if yes then update previous next to null and 
return head.

If not present, add current in set.
while current is not null
update previous with current and current with current's next

if current present in set if yes then update previous next to null and 
return head. 
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

        Nodes head = loop(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes removeLoop(Nodes nodes) {
        Set<Nodes> set = new HashSet<>();
        Nodes previous = nodes;
        set.add(previous);
        Nodes current = previous.next;
        set.add(current);
        if (current == null){
            return previous;
        }
        else if (set.contains(current.next)){
            current.next = null;
            return previous;
        }
        
        Nodes head = previous;
        while (current != null){
            previous = current;
            current = current.next;
            
            if (set.contains(current)){
                previous.next = null;
                break;
            }
            
            set.add(current);
        }
        return head;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)   Space --> O(n)



/*
Floyd’s Cycle-Finding Algorithm 
Approach: This is the fastest method and has been described below:  

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two.
If these pointers meet at the same node then there is a loop. 
If pointers do not meet then linked list doesn’t have a loop.

Once we found the loop we check two conditions:
	1. If the node fast and slow are met is same as head then traverse till end'same
	node and update end's node with null
	
	2. Else if fast and slow are same, then update slow = head.
	while fast.next is not equal to slow.next increment fast and slow by 1 i.e
	fast = fast.next;
    slow = slow.next;
	
	Once fast.next and slow.next are same then update fast's next with null
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

        Nodes head = loop(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes removeLoop(Nodes nodes) {
        Nodes fast = nodes, slow = nodes;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow){
                break;
            }
        }
        // loop on first node
        if (fast == nodes){
            while(fast.next != nodes){
                fast = fast.next;
            }
            fast.next = null;
        }
        else{
            slow = nodes;
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
