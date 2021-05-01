import java.util.*;

public class vit {

    public static void main(String[] args) throws Exception {
        String a = "strange";
        String b = "strong";

        System.out.println(anagram(a, b));
    }

    public static boolean anagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : b.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

}



import java.util.*;

public class vit {

    public static void main(String[] args) throws Exception {
        String a = "anger";
        String b = "range";

        System.out.println(anagram(a, b));
    }

    public static boolean anagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : a.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (Character c : b.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return map1.equals(map2);
    }

}




import java.util.*;

public class vit {

    public static void main(String[] args) throws Exception {

        int a[][] = {{1, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        System.out.println(identity(a));

    }

    public static boolean identity(int a[][]) {
        boolean flag = true;

        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = 0; index2 < a[0].length; index2++) {
                if (index1 == index2 && a[index1][index2] != 1) {
                    flag = false;
                    break;
                } else if (index1 != index2 && a[index1][index2] != 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}


import java.util.*;

public class vit {

    public static void main(String[] args) throws Exception {

        int a[][][] = {{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}};
        System.out.println(identity(a));

    }

    public static boolean identity(int a[][][]) {
        boolean flag = true;

        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = 0; index2 < a[index1].length; index2++) {
                for (int index3 = 0; index3 < a[index1][index2].length; index3++) {
                    if (index1 == index2 && index2 == index3 && a[index1][index2][index3] != 1) {
                        flag = false;
                        break;
                    } else if (index1 != index2 && index2 != index3 && a[index1][index2][index3] != 0) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}

