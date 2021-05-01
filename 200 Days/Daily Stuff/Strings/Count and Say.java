class CountAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
		
        String temp = "1";
        
        while (n-- > 1){
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < temp.length(); index++){
                int count = 1;
                while (index + 1 < temp.length() && temp.charAt(index) == 
                        temp.charAt(index + 1)){
                    count++;
                    index++;
                }
                sb.append(count).append(temp.charAt(index));
            }
            temp = sb.toString();
        }
        return temp;
    }

}
