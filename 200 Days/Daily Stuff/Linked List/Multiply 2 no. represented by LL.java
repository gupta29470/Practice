/*
Convert linked list in to number and return multiplication of two numbers
*/

class Sort {

    public static void main(String[] args) {

        Nodes nodes1 = null;
        nodes1 = push(nodes1, 6);
        nodes1 = push(nodes1, 4);
        nodes1 = push(nodes1, 9);

        Nodes nodes2 = null;
        nodes2 = push(nodes2, 4);
        nodes2 = push(nodes2, 8);

        System.out.println(multiply(nodes1, nodes2));
    }

    public static long multiply(Nodes nodes1, Nodes nodes2) {
        long number1 = 0, number2 = 0;

        while (nodes1 != null || nodes2 != null) {
            if (nodes1 != null) {
                number1 = number1 * 10 + nodes1.data;
            }

            if (nodes2 != null) {
                number2 = number2 * 10 + nodes2.data;
            }
            
            if (nodes1 != null){
                nodes1 = nodes1.next;
            }
            
            if (nodes2 != null){
                nodes2 = nodes2.next;
            }
        }
        return number1 * number2;
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
// Time --> O(length of long list)