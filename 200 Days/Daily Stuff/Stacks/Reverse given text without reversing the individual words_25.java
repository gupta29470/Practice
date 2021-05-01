import java.util.*;

public class vit {

    public static void main(String[] args) {
String input = "preparation Interview Technical IT for material good provide We";

        Stack<String> stack = new Stack<>();

        String inputStringArray[] = input.trim().split(" ");
        for (int index = 0; index < inputStringArray.length; index++) {
            stack.push(inputStringArray[index]);
        }
        String result = "";
        while (!stack.isEmpty()){
            result += stack.pop()+" ";
        }
        System.out.println(result.trim());
    }
}

Time --> O(n)   Space --> O(n)

public class vit {

    public static void main(String[] args) {
        String input = "preparation Interview Technical IT for material good provide We";
        char charArray[] = input.toCharArray();
        reverse(charArray);
        System.out.println(charArray);
    }

    public static void swap(char charArray[], int begin, int end) {
        char temp = charArray[begin];
        charArray[begin] = charArray[end];
        charArray[end] = temp;
    }

    public static void reverse(char charArray[], int begin, int end) {
        while (begin < end) {
            swap(charArray, begin++, end--);
        }
    }

    public static void reverse(char charArray[]) {
        int begin = 0, end = 0;

        for (int index = 0; index < charArray.length; index++) {
            if (charArray[index] == ' ') {
                reverse(charArray, begin, end);

                begin = end = index + 1;
            } else {
                end = index;
            }
        }
        reverse(charArray, begin, end);
        reverse(charArray, 0, charArray.length - 1);
    }
}

Time --> O(n)