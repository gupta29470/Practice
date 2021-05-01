/*
Use two loops. In the outer loop, pick nodes of the linked list one by one. 
In the inner loop, check if there exist a node whose value is greater than the
picked node. If there exists a node whose value is greater, then delete the picked
node. 

Using previous pointer, if current data is less than any right node then previous 
next's will be current's next and current will be current next and flag = true

if flag is false means we won't find any greater element than current element
then previous will be current and current will be current's next;
*/
class Delete {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 10);
        nodes = push(nodes, 20);
        nodes = push(nodes, 30);
        nodes = push(nodes, 40);
        nodes = push(nodes, 50);
        nodes = push(nodes, 60);
        nodes = push(nodes, 70);
        nodes = push(nodes, 80);
        nodes = push(nodes, 5);

        Nodes head = delete(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes delete(Nodes head) {
        Nodes current = head, previous = null;
        boolean flag = false;
        while (current != null) {
            Nodes innerCurrent = current.next;

            while (innerCurrent != null) {
                if (current.data < innerCurrent.data) {
                    Nodes next = current.next;
                    if (previous == null) {
                        head = head.next;
                        current = next;
                    } else {
                        previous.next = next;
                        current = next;
                    }
                }
                else{
                    innerCurrent = innerCurrent.next;
                }
            }
            if (!flag) {
                previous = current;
                current = current.next;
            }
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
// Time --> O(n ^ 2)

**********************************************************************************

/*
1. Reverse the list. 
2. Traverse the reversed list. Keep max till now. If next node is less than max, 
then delete the next node, otherwise max = next node. 
3. Reverse the list again to retain the original order. 
*/
class Delete {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 11);
        nodes = push(nodes, 2);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 10);
        nodes = push(nodes, 15);
        nodes = push(nodes, 12);

        Nodes head = delete(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes delete(Nodes head){
        Nodes duplicateHead = head;
        
        duplicateHead = reverse(duplicateHead);
        duplicateHead = deleteUtil(duplicateHead);
        duplicateHead = reverse(duplicateHead);
        
        return duplicateHead;
    }
    
    public static Nodes deleteUtil(Nodes head){
        Nodes current = head, maxNode = head;
        
        while (current != null && current.next != null){
            if (current.next.data < maxNode.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
                maxNode = current;
            }
        }
        return head;
    }
    
    public static Nodes reverse(Nodes head){
        Nodes current = head, previous = null;
        
        while (current != null){
            Nodes next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
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
// Time --> O(3n)
