/*
A simple solution would be to connect all linked lists into one list 
(order doesn’t matter). Then use the merge sort algorithm for the linked list sort 
the list  in ascending order. The worst-case time complexity of this approach will 
be O(n.log(n)) , where n is the total number of nodes present in all lists. 
Also, this approach does not take advantage of the fact that each list is 
already sorted.
*/

class Sort {

    public static void main(String[] args) {
        int k = 3;
        Nodes[] arr = new Nodes[k];

        arr[0] = new Nodes(1);
        arr[0].next = new Nodes(3);
        arr[0].next.next = new Nodes(5);
        arr[0].next.next.next = new Nodes(7);

        arr[1] = new Nodes(2);
        arr[1].next = new Nodes(4);
        arr[1].next.next = new Nodes(6);
        arr[1].next.next.next = new Nodes(8);

        arr[2] = new Nodes(0);
        arr[2].next = new Nodes(9);
        arr[2].next.next = new Nodes(10);
        arr[2].next.next.next = new Nodes(11);

        Nodes result = mergeKSorted(arr);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    public static Nodes mergeKSorted(Nodes array[]) {

        Nodes theOne = new Nodes(-1);
        Nodes head = theOne;
        for (int index = 0; index < array.length; index++){
            Nodes current = array[index];
            
            while (current != null){
                theOne.next = current;
                theOne = theOne.next;
                current = current.next;
            }
        }
        Nodes sorted = mergeSort(head.next);
        
        return sorted;
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
    Nodes next, random;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> (n.log(n))  Space --> O(n)




/*
We will take two linked list at a time and merge in sorted order and return it.
We start from last and second last linked list and using merge's sort sortedMerge
function we are merging two sorted linkedlist.
*/
class Sort {

    public static void main(String[] args) {
        int k = 3;
        Nodes[] arr = new Nodes[k];

        arr[0] = new Nodes(1);
        arr[0].next = new Nodes(3);
        arr[0].next.next = new Nodes(5);
        arr[0].next.next.next = new Nodes(7);

        arr[1] = new Nodes(2);
        arr[1].next = new Nodes(4);
        arr[1].next.next = new Nodes(6);
        arr[1].next.next.next = new Nodes(8);

        arr[2] = new Nodes(0);
        arr[2].next = new Nodes(9);
        arr[2].next.next = new Nodes(10);
        arr[2].next.next.next = new Nodes(11);

        Nodes result = mergeKSorted(arr);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    public static Nodes mergeKSorted(Nodes array[]) {

        if (array.length == 0) {
            return null;
        }

        if (array.length == 1) {
            return array[0];
        }

        Nodes result = array[array.length - 1];
        for (int index = array.length - 2; index >= 0; index--) {
            result = sortedMerge(array[index], result);
        }
        return result;
    }

    public static Nodes sortedMerge(Nodes first, Nodes second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        Nodes result;

        if (first.data < second.data) {
            result = first;
            result.next = sortedMerge(first.next, second);
        } else {
            result = second;
            result.next = sortedMerge(first, second.next);
        }

        return result;
    }

}

class Nodes {

    int data;
    Nodes next, random;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n logk)
