import java.util.*;

public class Lamda_1 {

    public static void main(String[] args) throws IOException {
        List<Integer> l = new ArrayList<>();
        l.add(88);
        l.add(74);
        l.add(77);
        l.add(777);
        Comparator<Integer> c = (Integer i1, Integer i2) -> { // lambda
            return -i1.compareTo(i2);

        };

        Collections.sort(l, c);
        System.out.println(l);

        List<Integer> l1 = new ArrayList<>();
        l1.add(88);
        l1.add(74);
        l1.add(77);
        l1.add(777);
        Comparator<Integer> co = (Integer i1, Integer i2) -> { //lamda
            if (i1 % 10 > i2 % 10) {
                System.out.println(i2);
                return -1;
            } else if (i1 % 10 < i2 % 10) {
                return 1;
            } else {
                return 0;
            }

        };
        Collections.sort(l1, co);
        System.out.println(l1);

    }
}
