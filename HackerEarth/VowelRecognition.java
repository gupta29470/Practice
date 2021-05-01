public class VowelRecognition {

    public static void main(String argc[]) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String inputString = sc.next();
            long maxVowel = 0;
            String subString;
            long len = inputString.length();

            for (int index = 0; index < inputString.length(); index++) {
                if (inputString.charAt(index) == 'a' || inputString.charAt(index) == 'e'
                        || inputString.charAt(index) == 'i' || inputString.charAt(index) == 'o'
                        || inputString.charAt(index) == 'u' || inputString.charAt(index) == 'A'
                        || inputString.charAt(index) == 'E' || inputString.charAt(index) == 'I'
                        || inputString.charAt(index) == 'O' || inputString.charAt(index) == 'U') {
                    maxVowel += (index + 1) * (len - index);
                }
            }
            System.out.println(maxVowel);

        }

    }
}
