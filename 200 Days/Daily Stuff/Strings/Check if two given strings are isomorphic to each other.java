class Isomorphic {

    public static void main(String[] args) {

        String string1 = "toayaxz", string2 = "fbjbkrx";

        System.out.println(areIsomorphic(string1, string2));
    }

    public static boolean areIsomorphic(String str1,String str2)
    {
        if (str1.length() != str2.length()){
            return false;
        }
        
        java.util.Map<Character, Character> map1 = new java.util.HashMap<>();
        java.util.Map<Character, Boolean> map2 = new java.util.HashMap<>();
        
        for (int index = 0; index < str1.length(); index++){
            
            char one = str1.charAt(index);
            char two = str2.charAt(index);
            
            if (map1.containsKey(one)){
                if (map1.get(one) != two){
                    return false;
                }
            }
            else{
                if (map2.containsKey(two)){
                    return false;
                }
                else{
                    map1.put(one, two);
                    map2.put(two, true);
                }
            }
        }
        return true;
    }
}
// Time --> O(n)   Space --> O(n)