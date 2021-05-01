import java.util.*;
import java.util.stream.IntStream;

public class Diet_Plan {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String maxFoodsArr[] = sc.nextLine().split(" ");

        int maxpro = (Integer.parseInt(maxFoodsArr[0].replaceAll("[^0-9]", "")));
        int maxcarbo = (Integer.parseInt(maxFoodsArr[1].replaceAll("[^0-9]", "")));
        int maxfat = (Integer.parseInt(maxFoodsArr[2].replaceAll("[^0-9]", "")));
        StringBuilder remove = new StringBuilder();

        String inputFoods[];
        inputFoods = sc.nextLine().split("\\|");

        for (String a : inputFoods) {
            remove.append(a + " ");
        }

        System.out.println(remove);

        String inputfoods[] = remove.toString().split(" ");
        int len = inputfoods.length / 3;
        int arr[][] = new int[len][3];
        int index = 0;
        try {
            for (int i = 0; i < inputfoods.length; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(inputfoods[index++].replaceAll("[^0-9]", ""));
                }
            }
        } catch (Exception e) {
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> IntStream.of(a).sum()));
        boolean usable[] = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            usable[i] = true;
        }
        boolean flag;
        while (true) {
            flag = true;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (usable[i] && (maxpro - arr[i][0]) >= 0 && (maxcarbo - arr[i][1]) >= 0 && (maxfat - arr[i][2]) >= 0) {
                    maxpro -= arr[i][0];
                    maxcarbo -= arr[i][1];
                    maxfat -= arr[i][2];
                    flag = false;

                } else {
                    usable[i] = false;
                }
            }
            if (flag == true) {
                break;
            }
        }

        System.out.println(maxpro + " " + maxcarbo + " " + maxfat);
    }

}
