/*
Reverse the give node and store in different linked list.
Compare both list
*/

class Palindrome {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(4);
        nodes.next.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next.next = new Nodes(2);
        nodes.next.next.next.next.next.next.next = new Nodes(1);

        System.out.println(isPalindrome(nodes));
    }
    
    public static boolean isPalindrome(Nodes nodes){
        Nodes reverse = reverse(nodes);
        
        Nodes pointer1 = nodes, pointer2 = reverse;
        
        while (pointer1 != null && pointer2 != null){
            if (pointer1.data != pointer2.data){
                return false;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return true;  
    }
    
    public static Nodes reverse(Nodes nodes){
        Nodes current = nodes, previous = null;
        
        while (current != null){
            Nodes next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(2n)   Space --> O(n)



/*
Using Stack

Put all linked list elements in stack. So last element of list will appear first,
second last element will appear second and so on.

Loop input list and check if current data is equal to top of stack or not and 
simulataneously pop element from stack and advance pointer of list
*/

import java.util.*;

class Palindrome {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(4);
        nodes.next.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next.next = new Nodes(2);
        nodes.next.next.next.next.next.next.next = new Nodes(1);

        System.out.println(isPalindrome(nodes));
    }
    
    public static boolean isPalindrome(Nodes nodes){
        
        Stack<Integer> stack = new Stack<>();
        Nodes temp = nodes;
        
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        
        temp = nodes;
        
        while (temp != null){
            if (temp.data != stack.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;  
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)    Space --> O(n)



/*
	  ********************** EFFICIENT APPROACH **********************
	  
We will reverse second half of linked list and compare.

-> If list length is odd then we will ignore middle element. If length is odd then 
at end fast pointer will point to last element of list so we return slow.next, 
because slow is pointing to middle element and we have to ignore middle and 
return another half

-> If length is even then at end fast pointer will point to null so we return 
slow, because slow is pointing to another half of list.

-> We will reverse another half and compare while reverse list is not null, 
because if length of list is odd then first half contains one extra element 
i.e middle element so we will ignore that comparison
*/
class Palindrome {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(4);
        nodes.next.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next.next = new Nodes(2);
        //nodes.next.next.next.next.next.next.next = new Nodes(1);

        System.out.println(isPalindrome(nodes));
    }
    
    public static boolean isPalindrome(Nodes nodes){
        Nodes middle = findMiddle(nodes);
        
        Nodes reverseHalf = reverse(middle);
       
        while (reverseHalf != null){
            if (nodes.data != reverseHalf.data){
                return false;
            }
            
            nodes = nodes.next;
            reverseHalf = reverseHalf.next;
        }
        
        return true;  
    }
    
    public static Nodes findMiddle(Nodes nodes){
        Nodes fast = nodes, slow = nodes;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
		// if list length is even
        if (fast == null){
            return slow;
        }
		// if list length is odd
        return slow.next;
    }
    
    public static Nodes reverse(Nodes nodes){
        Nodes current = nodes, previous = null;
        
        while (current != null){
            Nodes next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
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
