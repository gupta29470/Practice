
// using two loops create min and max different function
class MinMaxInArray {

    public static void main(String[] args) {

        int array[] = {55, 6663, 221, 663, 22545, 6354478, 336547};

        min_max(array);
    }

    public static void min_max(int array[]) {
        int min = min(array);
        int max = max(array);

        System.out.println(min + " " + max);
    }

    public static int min(int array[]) {
        int min = Integer.MAX_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
            }
        }
        return min;
    }

    public static int max(int array[]) {
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (array[index] > max) {
                max = array[index];
            }
        }
        return max;
    }

}



// using one loops and simultaneously checking min and max
class MinMaxInArray {

    public static void main(String[] args) {

        int array[] = {55, 6663, 221, 663, 22545, 6354478, 336547};

        min_max(array);
    }

    public static void min_max(int array[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
            }
            if (array[index] > max) {
                max = array[index];
            }
        }

        System.out.println(min + " " + max);
    }
}



// using one loop but used Math.min and Math.max function
class MinMaxInArray {

    public static void main(String[] args) {

        int array[] = {55, 6663, 221, 663, 22545, 6354478, 336547};

        min_max(array);
    }

    public static void min_max(int array[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            min = Math.min(array[index], min);
            max = Math.max(array[index], max);
        }

        System.out.println(min + " " + max);
    }
}



// using stream library
class MinMaxInArray {

    public static void main(String[] args) {

        int array[] = {55, 6663, 221, 663, 22545, 6354478, 336547};

        min_max(array);
    }

    public static void min_max(int array[]) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();

        System.out.println(min + " " + max);
    }
}

