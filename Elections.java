import java.io.*;
import java.util.*;

public class Elections {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lengthOfQueue = Integer.parseInt(br.readLine());
        String supporters = br.readLine();

        int first = 0, last = lengthOfQueue - 1;
        int count_ = 0, countA = 0, countB = 0;

        while (first <= last) {
            if (supporters.charAt(first) == '-' && supporters.charAt(last) == '-') {
                count_ += 1;
            } else if (supporters.charAt(first) == 'A' && supporters.charAt(last) == '-') {
                countA += 2;
            } else if (supporters.charAt(first) == 'B' && supporters.charAt(last) == '-') {
                countB += 1;
            } else if (supporters.charAt(first) == 'A' && supporters.charAt(last) == 'A') {
                countA += 1;
            } else if (supporters.charAt(first) == 'B' && supporters.charAt(last) == 'B') {
                countB += 2;
            } else if (supporters.charAt(first) == 'A' && supporters.charAt(last) == 'B') {
                countA += 1;
                countB += 1;
            }
            first++;
            last--;
        }

        countA += count_;
        countB += count_;

        if (countA < countB) {
            System.out.println("B");
            return;
        } else if (countA > countB) {
            System.out.println("A");
            return;
        } else if (countA == countB) {
            System.out.println("Coalition government");
        }
    }

}
