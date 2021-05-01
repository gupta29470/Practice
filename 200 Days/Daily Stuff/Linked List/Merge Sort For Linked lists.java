/*
1. Split Linked List recursively using front-back-split
2. Sort list
*/

class MergeSort {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(9);
        nodes.next = new Nodes(8);
        nodes.next.next = new Nodes(7);
        nodes.next.next.next = new Nodes(6);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(4);
        nodes.next.next.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next.next.next = new Nodes(2);

        Nodes sortedList = mergeSort(nodes);
        
        while (sortedList != null){
            System.out.print(sortedList.data + " ");
            sortedList = sortedList.next;
        }
    }
    
    public static Nodes mergeSort(Nodes nodes){
        if (nodes == null || nodes.next == null){
            return nodes;
        }
        
         // split `head` into `front` and `middle` sublists
        Nodes array[] = split(nodes);
        Nodes front = array[0];
        Nodes middle = array[1];
        
        // recursively sort the sublists
        front = mergeSort(front);
        middle = mergeSort(middle);
        
        // answer = merge the two sorted lists
        return sortedMerge(front, middle);
    }
    
    /*
        Split the given list's nodes into front and back halves,
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow pointer strategy
    */
    public static Nodes[] split(Nodes nodes){
        
         // if the length is less than 2, handle it separately
        if (nodes == null || nodes.next == null){
            return new Nodes[]{nodes};
        }
        
        Nodes fast = nodes.next, slow = nodes;
        
        // advance `fast` two nodes, and advance `slow` one node
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // `slow` is before the midpoint in the list, so split it in two
        // at that point.
        Nodes front = nodes;
        Nodes middle = slow.next;
        slow.next = null;
        
        return new Nodes[]{front, middle};
    }
    
    // Takes two lists sorted in increasing order and merge their nodes
    // to make one big sorted list, which is returned
    public static Nodes sortedMerge(Nodes front, Nodes middle){
        
        // base cases
        if (front == null){
            return middle;
        }
        
        else if (middle == null){
            return front;
        }
        
        Nodes sortedList;
        
        // pick either `front` or `middle`, and recur
        if (front.data < middle.data){
            sortedList = front;
            sortedList.next = sortedMerge(front.next, middle);
        }
        else{
            sortedList = middle;
            sortedList.next = sortedMerge(front, middle.next);
        }
        return sortedList;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time Complexity: O(n Log n)