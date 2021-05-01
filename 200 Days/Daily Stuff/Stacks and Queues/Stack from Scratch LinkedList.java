import java.util.*;

public class practice_1 {
	
	static Node top = null;
	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		peek();
		
		pop();
		
		peek();
		
		pop();
		
		peek();
	}
	
	
	public static void push(int data) {
		Node newNode = new Node(data);
		
		if (top == null) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	public static void pop() {
		if (top == null) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Popped data is : " + top.data);
			top = top.next;
		}
	}
	
	public static void peek() {
		System.out.println("Top element : " + top.data);
	}
}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}















