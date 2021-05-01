import java.util.*;

public class Prime_Fibonacci {

    public static void main(String[] args) {
        //ArrayList<String> arr = new ArrayList<>();
        String arr[] = new String[150];
        int pos = 0;
        for (int i = 2; i <= 40; i++) {
            if (findPrime(i)) {
                arr[pos] = Integer.toString(i);
                pos++;
            }
        }
        pos = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        String arrs[] = new String[150];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] != arr[j] && arr[i] != null && arr[j] != null) {
                    String s = arr[i] + arr[j];
                    arrs[pos] = s;
                    pos++;
                }
            }
        }
        System.out.println("");
        //Arrays.sort(arrs);
        for (String i : arrs) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println(arrs[0]);
        ArrayList<Integer> a = new ArrayList<>();
        int i = 0;
        while (arrs[i] != null) {
            int j = Integer.parseInt(arrs[i]);
            if (findPrime(j)) {
                if (!a.contains(j)) {
                    a.add(j);
                }
            }
            i++;
        }
        Collections.sort(a);
        System.out.println(a);
        System.out.println("Smallest:" + a.get(0));
        System.out.println("Largest:" + a.get(a.size() - 1));
        int size = a.size();
        System.out.println(a.size());
        long m = a.get(0), n = a.get(a.size() - 1), sum = 0;
        System.out.println(m + " " + n);
        for (int s = 2; s < size; s++) {
            sum = m + n;
            m = n;
            n = sum;
        }
        System.out.println(sum);
    }
    static boolean findPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
