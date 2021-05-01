import java.util.*;

public class Reversingthefirst_K_elementsofaQueue {

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        int k = 5;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.peek());
            q.remove();
        }
       while(!st.isEmpty()) {
            q.add(st.peek());
            st.pop();
        }
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.peek());
            q.remove();
        }
        System.out.println(q);

    }

}
