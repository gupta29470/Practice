public class CountDigits {

    public static void main(String argc[]) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        String strArray[] = inputString.split("");
        int array[] = new int[inputString.length()];
        for (int index = 0; index < inputString.length(); index++) {
            array[index] = Integer.parseInt(strArray[index]);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer data : array) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        for (int index = 0; index < 10; index++) {
            if (map.containsKey(index)) {
                System.out.println(index + " " + map.get(index));
            } else {
                System.out.println(index + " " + "0");
            }
        }

    }
}
