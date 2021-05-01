import java.util.*;

public class prat {

    public static void main(String[] args) {
        int chocolatePacket[] = {12, 4, 7, 9, 2, 23,
            25, 41, 30, 40, 28,
            42, 30, 44, 48, 43,
            50};

        int students = 7;
        
        System.out.println(minimumDifference(chocolatePacket.length, chocolatePacket,
                students));
    }

    // arr[0..n-1] represents sizes of
    // packets. m is number of students.
    // Returns minimum difference between
    // maximum and minimum values of
    // distribution.
    public static int minimumDifference(int packets, int chocolatePacket[], int students) {
        
        // if there are no chocolates or
        // number of students is 0
        if (packets == 0 || students == 0) {
            return 0;
        }

        // Number of students cannot be
        // more than number of packets
        if (packets < students) {
            return -1;
        }

        // Sort the given packets
        Arrays.sort(chocolatePacket);
        
        // Largest number of chocolates
        int minDiff = Integer.MAX_VALUE;

        // Find the subarray of size m
        // such that difference between
        // last (maximum in case of
        // sorted) and first (minimum in
        // case of sorted) elements of
        // subarray is minimum.
        for (int index = 0; index + students - 1 < packets; index++) {
            int currentDiff = chocolatePacket[index + students - 1]
                    - chocolatePacket[index];

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        return minDiff;
    }

}
// Time --> O(n logn)