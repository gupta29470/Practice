/*
Create temp of type String and store string 1 two times.
return true if string 1 is of same length of string 2 and temp 
string contains string 2, 
else return false.

String str1 = "ABCD";
String str2 = "CDAB";

temp = ABCDABCD
temp contains CDAB ... AB "CDAB" CD
because storing two times will contains all
possible rotations.
*/

class OneStringRotationOfAnother {

    public static void main(String[] args) {

        String str1 = "ABCD";
        String str2 = "CDAB";
        
        System.out.println(areRotations(str1, str2));

    }

    public static boolean areRotations(String string1, String string2) {

        String temp = string1 + string1;
        
        return (string1.length() == string2.length())
                && temp.contains(string2);
    }
}
