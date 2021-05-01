/*
1. If delete key is head, update head to head's next and move to the last node and 
update last's next to updated head.

2. If delete key is middle element or last element then create a previous of
type node which helps if delete key is last element.

if current key is delete key and current next's is head, means it is last element,
so previous will have second last element so previous's next will become head

else if current key is delete key(middle element) then store's current next 
in next variable and previous'next will be current's next i.e next variable;
*/

class DeletionCircular {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(2);
        nodes.next = new Nodes(5);
        nodes.next.next = new Nodes(7);
        nodes.next.next.next = new Nodes(8);
        nodes.next.next.next.next = new Nodes(10);
        nodes.next.next.next.next.next = nodes;
        //nodes.next.next.next.next.next.next = new Nodes(7);
        //nodes.next.next.next.next.next.next.next = nodes;

        Nodes head = deletionCircular(nodes, 7);
        Nodes temp = head.next;
        System.out.print(head.data + " ");
        while (head != temp){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + " ");
    }
    
    public static Nodes deletionCircular(Nodes nodes, int deleteOne){
        
        if (nodes == null){
            return null;
        }
        
        if (nodes.data == deleteOne){
            nodes = nodes.next;
            
            Nodes temp = nodes.next;
            while (true){
                if (temp.next.data == deleteOne){
                    temp.next = nodes;
                    break;
                }
                temp = temp.next;
            }
            return nodes;
        }
        
        Nodes temp = nodes, previous = null;
        
        while (true){
            if (temp.data == deleteOne && temp.next == nodes){
                previous.next = nodes;
                break;
            }
            else if (temp.data == deleteOne){
                Nodes next = temp.next;
                previous.next = next;
                break;
            }
            previous = temp;
            temp = temp.next;
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
// Time --> O(n)