import java.util.*;

public class practice_1 {
	
	static int top = -1;
	static int max = 10;
	static int stack[] = new int[max];
	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		peek();
		
		pop();
		
		peek();
		
		boolean isEmpty = isStackEmpty();
		if (isEmpty) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Stack is not empty");
		}
	}
	
	
	public static void push(int data) {
		if (top >= max - 1) {
			System.out.println("Stack Overflow");
		}
		else {
			top++;
			stack[top] = data;
		}
	}
	
	public static void pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
		}
		else {
			int poppedData = stack[top];
			stack[top] = 0;
			top--;
			
			System.out.println("Popped data is : " + poppedData);
		}
	}
	
	public static void peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
		}
		else {
			System.out.println("Top element is : " + stack[top]);
		}
	}
	
	public static boolean isStackEmpty() {
		if (top < 0) {
			return true;
		}
		return false;
	}

}
















