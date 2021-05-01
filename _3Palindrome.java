import java.io.*;
import java.util.*;

public class _3Palindrome {

    static ArrayList<String> output = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String supporters = br.readLine();
        print3Palindrome(supporters);

    }

    public static void print3Palindrome(String inputString) {
        int lengthString = inputString.length();

        boolean flag = false;
        for (int index1 = 1; index1 < lengthString - 2; index1++) {
            if (checkifPalindromes(inputString.substring(0, index1))) {
                for (int index2 = index1 + 1; index2 < lengthString; index2++) {
                    if (checkifPalindromes(inputString.substring(index1, index2))
                            && checkifPalindromes(inputString.substring(index2, lengthString))) {
                        if (inputString.substring(0, index1) != "" && inputString.substring(index1, index2) != "" && inputString.substring(index2, lengthString) != ""
                                && inputString.substring(0, index1) != null && inputString.substring(index1, index2) != null && inputString.substring(index2, lengthString) != null) {
                            output.add(inputString.substring(0, index1));
                            output.add(inputString.substring(index1, index2));
                            output.add(inputString.substring(index2, lengthString));
                            flag = true;
                        }
                    }
                }
            }
        }
        if (flag == false) {
            System.out.println("Not possible");
        } else if (flag == true) {
            Iterator<String> it = output.iterator();
            while (it.hasNext()) {
                if (it.next().equals(" ")) {
                    it.remove();
                }
            }
            for (int index = 0; index < 3; index++) {
                System.out.println(output.get(index));
            }
        }
    }

    public static boolean checkifPalindromes(String inputString) {
        int lengthString = inputString.length();

        if (lengthString == 1) {
            return true;
        }
        int index = 0;
        for (index = 0; index < lengthString / 2; index++) {
            if (inputString.charAt(index) != inputString.charAt(lengthString - index - 1)) {
                return false;
            }
        }
        return true;
    }

}
