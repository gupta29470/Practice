class CheckCircular {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        System.out.println(isCircular(nodes));
    }

    public static boolean isCircular(Nodes nodes) {
        Nodes current = nodes;

        while (current.next != null) {
            if (current.next == nodes) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
// Time --> O(n)

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
