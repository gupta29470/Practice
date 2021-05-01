class IntersectionLeetcode {

    public static void main(String[] args) {

        int array1[] = {1, 2, 2, 1};
        int array2[] = {2, 2};

        int result[] = intersection(array1, array2);

        for (int data : result) {
            System.out.println(data);
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Boolean> map = new HashMap<>();

        for (int data : nums1) {
            map.put(data, true);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (int data : nums2) {
            if (map.containsKey(data) && map.get(data)) {
                map.put(data, false);
                list.add(data);
            }
        }
        System.out.println(map);
        System.out.println(list);
        int result[] = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            result[index] = list.get(index);
        }
        return result;
    }
}
