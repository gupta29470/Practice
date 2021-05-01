import java.util.*;

public class RailFenceCipher{

     public static void main(String[] args) {
        String s = "attackatonce";
        int key = 3;
        System.out.println(encryption(s, key));
        String en = encryption(s, key);
        System.out.println(decryption(en, key));
    }

    static String encryption(String text, int key) {
        String encryptedtext = "";
        int put = 0, row = key, col = text.length();
        boolean check = false;
        char charArray[][] = new char[row][col];
        for (int index = 0; index < col; index++) {
            if (put == 0 || put == key - 1) {
                check = !check;
            }

            charArray[put][index] = text.charAt(index);
            if (check) {
                put++;
            } else {
                put--;
            }
        }

        for (int ro = 0; ro < row; ro++) {
            for (int co = 0; co < col; co++) {
                if (charArray[ro][co] != 0) {
                    encryptedtext += charArray[ro][co];
                }
            }
        }
        return encryptedtext;
    }

    static String decryption(String text, int key) {
        String decryptedtext = "";
        int put = 0, row = key, col = text.length();
        boolean check = false;
        char charArray[][] = new char[row][col];
        for (int index = 0; index < col; index++) {
            if (put == 0 || put == key - 1) {
                check = !check;
            }
            charArray[put][index] = '*';
            if (check) {
                put++;
            } else {
                put--;
            }
        }
        int index = 0;
        for (int ro = 0; ro < row; ro++) {
            for (int co = 0; co < col; co++) {
                if (charArray[ro][co] == '*' && index < col) {
                    charArray[ro][co] = text.charAt(index++);
                }
            }
        }
        for (int indexs = 0; indexs < col; indexs++) {
            if (put == 0 || put == key - 1) {
                check = !check;
            }

            decryptedtext += charArray[put][indexs];
            if (check) {
                put++;
            } else {
                put--;
            }
        }
        return decryptedtext;

    }
}
