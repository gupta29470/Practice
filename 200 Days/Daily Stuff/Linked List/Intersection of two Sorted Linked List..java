/*
The strategy is to advance up both lists and build the result list as we go. 
When the current point in both lists is the same, add a node to the result. 
Otherwise, advance whichever list is smaller. By exploiting the fact that both 
lists are sorted, we only traverse each list once.
*/


class Intersection {

    public static void main(String[] args) {

        Nodes nodes1 = new Nodes(1);
        nodes1.next = new Nodes(2);
        nodes1.next.next = new Nodes(3);
        nodes1.next.next.next = new Nodes(4);
        nodes1.next.next.next.next = new Nodes(6);

        Nodes nodes2 = new Nodes(2);
        nodes2.next = new Nodes(4);
        nodes2.next.next = new Nodes(6);
        nodes2.next.next.next = new Nodes(8);
        //nodes2.next.next.next.next = new Nodes(10);

        Nodes intersection = intersection(nodes1, nodes2);
        
        while (intersection != null){
            System.out.print(intersection.data + " ");
            intersection = intersection.next;
        }
    }
    
    public static Nodes intersection(Nodes nodes1, Nodes nodes2){
        if (nodes1 == null || nodes2 == null){
            return null;
        }
        
        Nodes previous = null, head = null;
        
        while (nodes1 != null && nodes2 != null){
            if (nodes1.data < nodes2.data){
                nodes1 = nodes1.next;
            }
            else if (nodes1.data > nodes2.data){
                nodes2 = nodes2.next;
            }
            else{
                Nodes newNode = new Nodes(nodes1.data);
                if (head == null){
                    head = newNode;
                    previous = newNode;
                }
                else{
                    previous.next = newNode;
                    previous = newNode;
                }
                nodes1 = nodes1.next;
                nodes2 = nodes2.next;
            }
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
// Time --> O(n+m)   Space --> O(n+m)
