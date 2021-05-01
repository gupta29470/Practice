/*
Using Insertion Sort
*/
class KSorted {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 56);
        nodes = push(nodes, 12);
        nodes = push(nodes, 2);
        nodes = push(nodes, 6);
        nodes = push(nodes, 3);
        //nodes = push(nodes, 7);

        Nodes head = sort(nodes);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes){
        Nodes current = nodes;
        Nodes head = current;
        
        while (current != null){
            int _current = current.data;
            Nodes temp = current;
            
            while (temp.prev != null && temp.prev.data > _current){
                temp.data = temp.prev.data;
                temp = temp.prev;
            }
            temp.data = _current;
            
            current = current.next;
        }
        return head;
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
// Time --> O(n * k)



/*
Using Priority Queue(Min - Heap)
1) Create a Min Heap of size k+1 with first k+1 elements. 
This will take O(k) time (See this GFact) 
2) One by one remove min element from heap, and arrange in new list 
and add a new element to heap from remaining elements.
Removing an element and adding a new element to min heap will take log k time. 
So overall complexity will be O(k) + O((n-k) * log(k)).
*/

import java.util.*;

class KSorted {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 56);
        nodes = push(nodes, 12);
        nodes = push(nodes, 2);
        nodes = push(nodes, 6);
        nodes = push(nodes, 3);

        Nodes head = sort(nodes, 2);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes, int k){
		
		 // priority_queue 'pq' implemented as min heap with the 
    // help of 'compare' function in compare Node class
        PriorityQueue<Nodes> pq = new PriorityQueue<>(new CompareNodes());
        Nodes head = null, last = null;
        
		// Create a Min Heap of first (k+1) elements from 
    // input doubly linked list 
        for (int index = 0; nodes != null && index <= k; index++){
			
			// push the node on to 'pq' 
            pq.add(nodes);
			
			// move to the next node 
            nodes = nodes.next;
        }
        
		// loop till there are elements in 'pq' 
        while (!pq.isEmpty()){
			
			// If first element
            if (head == null){
                head = pq.peek();
                last = pq.peek();
                head.prev = null;
            }
            else{
                last.next = pq.peek();
                pq.peek().prev = last;
                last = pq.peek();
            }
			
			// remove element from 'pq' 
            pq.poll();
            
			// if there are more nodes left in the input list 
            if (nodes != null){
				
				// push the node on to 'pq' 
                pq.add(nodes);
				
				 // move to the next node 
                nodes = nodes.next;
            }
        }
		// making 'next' of last node point to NULL 
        last.next = null;
		
		// new head of the required sorted DLL 
        return head;
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

class CompareNodes implements Comparator<Nodes>{
    @Override
    public int compare(Nodes nodes1, Nodes nodes2){
        return nodes1.data - nodes2.data;
    }
}

// Time Complexity: O(nLogk)  		Space: O(k)