/****************************** BRUTE FORCE *****************************/

/*
							Anti-Clockwise -- Right Rotation

Example = 1, 2, 3, 4, 5, 6, k = 2     		Expected = 5, 6, 1, 2, 3, 4

1. Calculate length of list and store in size

2. We have to go that place from where we have to rotate, so we calculate 
nonRotate by size - k

3. So do for loop index from 0 till less than nonRotate and after for loop temp 
will be at 5

4. We will store from 5 to different list i.e head will cotains from 5 onwards,
i.e 5 and 6 and head's previous is null

5. We will reach end of temp i.e 6 and store in tail

6. update temp = nodes i.e 1 and we will again loop non rotate part and tail's
next will be 1, 2, 3, 4 

7. At last tail's next will be null

8. return head.
*/

class Rotate {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes, 4);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes, int k){
        int size = size(nodes);
        int nonRotate = size - k;
        Nodes temp = nodes;
        Nodes head = null, tail = null;
        
        for (int index = 0; index < nonRotate; index++){
            temp = temp.next;
        }
        
        if (head == null){
            head = temp;
            head.prev = null;
            tail = moveLast(temp);
        }
        
        temp = nodes;
        for (int index = 0; index < nonRotate; index++){
            tail.next = new Nodes(temp.data);
            tail = tail.next;
            temp = temp.next;
        }
        tail.next = null;
        
        return head;
    }
    
    public static int size(Nodes nodes){
        int size = 0;
        Nodes temp = nodes;
        
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    
    public static Nodes moveLast(Nodes nodes){
        while (nodes.next != null){
            nodes = nodes.next;
        }
        return nodes;
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



/*
								Clockwise --- Left Rotation

Example = 1, 2, 3, 4, 5, 6, k = 2     		Expected = 3, 4, 5, 6, 1, 2

1. So do for loop index from 0 till less than k and after for loop temp will be 
at 3 

2. We will store from 3 to different list i.e head will cotains from 3 onwards,
i.e 3, 4, 5 and 6 and head's previous is null

3. We will reach end of temp i.e 6 and store in tail

4. update temp = nodes i.e 1 and we will again loop rotate part and tail's
next will be 1, 2

5. At last tail's next will be null

6. return head.
*/
class Rotate {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes, 2);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes, int k){
        int size = size(nodes);
        int nonRotate = size - k;
        Nodes temp = nodes;
        Nodes head = null, tail = null;
        
        for (int index = 0; index < k; index++){ // change is here
            temp = temp.next;
        }
        
        if (head == null){
            head = temp;
            head.prev = null;
            tail = moveLast(temp);
        }
        
        temp = nodes;
        for (int index = 0; index < k; index++){ // changes here
            tail.next = new Nodes(temp.data);
            tail = tail.next;
            temp = temp.next;
        }
        tail.next = null;
        
        return head;
    }  
    public static Nodes moveLast(Nodes nodes){
        while (nodes.next != null){
            nodes = nodes.next;
        }
        return nodes;
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




/********************************* EFFICIENT APPROACH ***************************/
/*
						Anti-Clockwise -- Right Rotation

Example = 1, 2, 3, 4, 5, 6, k = 2     		Expected = 5, 6, 1, 2, 3, 4

1. Calculate length of list and store in size

2. We have to go that place from where we have to rotate, so we calculate 
nonRotate by size - k

3. So do for loop index from 1 - till less than nonRotate and after for loop 
current will be at 4

4. We will store current in temp i.e 4 beacuse it will be tail of rotated list.

5. We will reach end of current i.e 6 

6. update current's next to head i.e 6's next will be 1 and head previous will 
be current i.e 1's previous willl be 6

7. head = temp.next i.e 5

8. head's previous is null

9. temp's next will be null  beacuse it will be tail of rotated list.

10. return head.
*/
class Rotate {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes, 2);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes, int k){
        int size = size(nodes);
        int nonRotate = size - k;
        Nodes current = nodes;
        
        for (int index = 1; index < nonRotate; index++){
            current = current.next;
        }
        
        if (current == null){
            return null;
        }
        
        Nodes temp = current;
        
        current = moveLast(current);
        
        current.next = nodes;
        nodes.prev = current;
        
        nodes = temp.next;
        nodes.prev = null;
        temp.next = null;
        
        return nodes;
    }
    
    public static int size(Nodes nodes){
        int size = 0;
        Nodes temp = nodes;
        
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    
    public static Nodes moveLast(Nodes nodes){
        while (nodes.next != null){
            nodes = nodes.next;
        }
        return nodes;
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




/*
							Clockwise --- Left Rotation

Example = 1, 2, 3, 4, 5, 6, k = 2     		Expected = 3, 4, 5, 6, 1, 2

3. So do for loop index from 1 - till less than k and after for loop current 
will be at 2

4. We will store current in temp i.e 2 beacuse it will be tail of rotated list.

5. We will reach end of current i.e 6 

6. update current's next to head i.e 6's next will be 1 and head previous will 
be current i.e 1's previous willl be 6

7. head = temp.next i.e 3

8. head's previous is null

9. temp's next will be null  beacuse it will be tail of rotated list.

10. return head.
*/
class Rotate {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes head = sort(nodes, 2);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static Nodes sort(Nodes nodes, int k){
        Nodes current = nodes;
        
        for (int index = 1; index < k; index++){// changes here
            current = current.next;
        }
        
        if (current == null){
            return null;
        }
        
        Nodes temp = current;
        
        current = moveLast(current);
        
        current.next = nodes;
        nodes.prev = current;
        
        nodes = temp.next;
        nodes.prev = null;
        temp.next = null;
        
        return nodes;
    }    
    public static Nodes moveLast(Nodes nodes){
        while (nodes.next != null){
            nodes = nodes.next;
        }
        return nodes;
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
