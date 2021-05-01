// From Java pattern app
public class pattern1 {
    public static void main(String argc[]) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        

    }
}
public class pattern2 {
    public static void main(String argc[]) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(i);
            }
            System.out.println("");
        }
        

    }
}
public class pattern3 {
    public static void main(String argc[]) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(j);
            }
            System.out.println("");
        }
        

    }
}

public class pattern4_a {
    public static void main(String argc[]) {
        int n=5,a=65;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print((char)(a)+" ");
            }
            a+=1;
            System.out.println("");
        }
    }
}
public class pattern4_b {
    public static void main(String argc[]) {
        for(char row='A';row<='E';row++){
            for(char col='A';col<='E';col++){
                System.out.print(row+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern5 {
    public static void main(String argc[]) {
        for(char row='A';row<='E';row++){
            for(char col='A';col<='E';col++){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern6 {
    public static void main(String argc[]) {
        for(int row=5;row>=1;row--){
            for(int col=5;col>=1;col--){
                System.out.print(row+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern7 {
    public static void main(String argc[]) {
        for(int row=5;row>=1;row--){
            for(int col=5;col>=1;col--){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern8 {
    public static void main(String argc[]) {
        for(char row='E'; row>='A';row--){
            for(char col='E';col>='A';col--){
                System.out.print(row+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern9 {
    public static void main(String argc[]) {
        for(char row='E'; row>='A';row--){
            for(char col='E';col>='A';col--){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern10 {
    public static void main(String argc[]) {
        for(int row=1;row<=5;row++){
            for(int col=1;col<=row;col++){
                System.out.print("*"+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern11 {
    public static void main(String argc[]) {
        for(int row=1;row<=5;row++){
            for(int col=1;col<=row;col++){
                System.out.print(row+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern12 {
    public static void main(String argc[]) {
        for(int row=1;row<=5;row++){
            for(int col=1;col<=row;col++){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern13 {
    public static void main(String argc[]) {
        for(char row='A';row<='E';row++){
            for(char col='A';col<=row;col++){
                System.out.print(row+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern14 {
    public static void main(String argc[]) {
        for(char row='A';row<='E';row++){
            for(char col='A';col<=row;col++){
                System.out.print(col+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern15_A {
    public static void main(String argc[]) {
        for(int row=5;row>=1;row--){
            for(int col=row;col>=1;col--){
                System.out.print("*"+" ");
            }
            System.out.println("");
        }
    }
}
public class pattern15_b {
    public static void main(String argc[]) {
       for(int row=1;row<=5;row++){
           for(int col=5;col>=row;col--){
               System.out.print("*"+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern16 {
    public static void main(String argc[]) {
       for(int row=1;row<=5;row++){
           for(int col=5;col>=row;col--){
               System.out.print(row+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern17 {
    public static void main(String argc[]) {
       for(int row=5;row>=1;row--){
           for(int col=1;col<=row;col++){
               System.out.print(col+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern18 {
    public static void main(String argc[]) {
       for(char row='A';row<='E';row++){
           for(char col='E';col>=row;col--){
               System.out.print(row+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern18_b {
    public static void main(String argc[]) {
       for(int row=0;row<=4;row++){
           for(int col=4;col>=row;col--){
               System.out.print((char)(row+65)+ " ");
           }
           System.out.println("");
       }
    }
}
public class pattern19 {
    public static void main(String argc[]) {
       for(int row=4;row>=0;row--){
           for(int col=0;col<=row;col++){
               System.out.print((char)(col+65)+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern20 {
    public static void main(String argc[]) {
       for(int row=5;row>=1;row--){
           for(int col=1;col<=row;col++){
               System.out.print(row+" ");
           }
           System.out.println("");
       }
    }
}
public class pattern21 {

    public static void main(String[] args) throws Exception {
        for(int row=1;row<=5;row++){
            for(int col=5;col>=row;col--){
                System.out.print(col+" ");
            }
            System.out.println("");
        }

    }
}
public class pattern21 {

    public static void main(String[] args) throws Exception {
        for(char row='E';row>='A';row--){
            for(char col='A';col<=row;col++){
                System.out.print(row+" ");
            }
            System.out.println("");
        }

    }
}
public class pattern22 {

    public static void main(String[] args) throws Exception {
        for(char row='A';row<='E';row++){
            for(char col='E';col>=row;col--){
                System.out.print(col+" ");
            }
            System.out.println("");
        }

    }
}
public class pattern23{
    public static void main(String[] args) throws Exception {
        int n = 10;
        for (int row = 1; row <= n; row++) {//row loop
            for (int space = n - 1; space >= row; space--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
public class pattern24 {

    public static void main(String[] args) throws Exception {
        int n = 9;
        for (int row = 1; row <= n; row++) {
            for (int space = n - 1; space >= row; space--) {
                System.out.print(" ");
            }
            for (int print = 1; print <= row; print++) {
                System.out.print(row);
            }
            System.out.println("");
        }

    }
}

public class pattern26 {

    public static void main(String[] args) throws Exception {
        int n = 9;
        for (int row = 1; row <= n; row++) {
            for (int space = n - 1; space >= row; space--) {
                System.out.print(" ");
            }
            for (int print = 1; print <= row; print++) {
                System.out.print(print);
            }
            System.out.println("");
        }

    }
}
public class pattern27 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=0;row<=n;row++){
            for(int space=n-1;space>=row;space--){
                System.out.print(" ");
            }
            for(int print=0;print<=row;print++){
                System.out.print((char)(row+65));
            }
            System.out.println("");
        }

    }
}
public class pattern28 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=0;row<=n;row++){
            for(int space=n-1;space>=row;space--){
                System.out.print(" ");
            }
            for(int print=0;print<=row;print++){
                System.out.print((char)(print+65));
            }
            System.out.println("");
        }

    }
}
public class pattern29 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=1;row<=5;row++){
            for(int space=0;space<row-1;space++){
                System.out.print(" ");
            }
            for(int print=5;print>=row;print--){
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}

public class pattern30 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=n;row>=1;row--){
            for(int space=5;space>row;space--){
                System.out.print(" ");
            }
            for(int print=1;print<=row;print++){
                System.out.print(row);
            }
            System.out.println("");
        }
    }
}

public class pattern31 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=n;row>=1;row--){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int print=1;print<=row;print++){
                System.out.print(print);
            }
            System.out.println("");
        }

    }

}
public class pattern32 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=n-1;row>=0;row--){
            for(int space=n-1;space>row;space--){
                System.out.print(" ");
            }
            for(int print=0;print<=row;print++){
                System.out.print((char)(row+65));
            }
            System.out.println("");
        }
    }

}
public class pattern33 {

    public static void main(String[] args) throws Exception {
        int n=5;
        for(int row=n-1;row>=0;row--){
            for(int space=n-1;space>row;space--){
                System.out.print(" ");
            }
            for(int print=0;print<=row;print++){
                System.out.print((char)(print+65));
            }
            System.out.println("");
        }
    }

}
public class pattern34 {

    public static void main(String[] args) throws Exception {
        int n=5,minStars=1;
        for(int row=1;row<=n;row++){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int print=1;print<=minStars;print++){
                System.out.print("*");
            }
            minStars+=2;
            System.out.println("");
        }
    }

}
public class pattern35 {

    public static void main(String[] args) throws Exception {
        int n=5,min=1;
        for(int row=1;row<=n;row++){
            for(int col=n;col>row;col--){
                System.out.print(" ");
            }
            for(int print=1;print<=min;print++){
                System.out.print(row);
            }
            min+=2;
            System.out.println("");
        }
    }

}
public class pattern36 {

    public static void main(String[] args) throws Exception {
        int n=9,min=1;
        for(int row=1;row<=n;row+=2){
            for(int col=n;col>row;col-=2){
                System.out.print(" ");
            }
            for(int print=1;print<=min;print++){
                System.out.print(row);
            }
            min+=2;
            System.out.println("");
        }
    }

}
public class pattern37 {

    public static void main(String[] args) throws Exception {
        int n=5,min=1;
        for(int row=0;row<=n;row++){
            for(int col=n;col>row;col--){
                System.out.print(" ");
            }
            for(int print=1;print<=min;print++){
                System.out.print((char)(row+65));
            }
            min+=2;
            System.out.println("");
        }
    }

}
public class pattern38 {

    public static void main(String[] args) throws Exception {
        int n=9,min=1;
        for(int row=0;row<=n;row+=2){
            for(int col=n;col>row;col-=2){
                System.out.print(" ");
            }
            for(int print=1;print<=min;print++){
                System.out.print((char)(row+65));
            }
            min+=2;
            System.out.println("");
        }
    }

}
public class pattern39 {

    public static void main(String[] args) throws Exception {
        int n=5,min=1;
        for(int row=1;row<=n;row++){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int print=1;print<=min;print++){
                System.out.print(print);
            }
            min+=2;
            System.out.println("");
        }
    }

}

public class pattern40 {

    public static void main(String[] args) throws Exception {
        int n=5,min=1;
        for(int row=1;row<=n;row++){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int print=min;print>=1;print--){
                System.out.print(print);
            }
            min+=2;
            System.out.println("");
        }
    }

}
public class pattern41 {

    public static void main(String[] args) {
        int n = 5, min = 0;
        for (int row = 0; row <= n; row++) {
            for (int space = n; space > row; space--) {
                System.out.print(" ");
            }
            for (int print = 0; print <= min; print++) {
                System.out.print((char) (print + 65));
            }
            min += 2;
            System.out.println("");
        }
    }
}
public class pattern42 {

    public static void main(String[] args) {
        int n = 5, min = 0;
        for(int row=0;row<=n;row++){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int print=min;print>=0;print--){
                System.out.print((char)(print+65));
            }
            min+=2;
            System.out.println("");
        }
    }
}
public class pattern43 {

    public static void main(String[] args) {
        int n = 5, min = 1;
        for (int row = 1; row <= n; row++) {
            for (int space = n; space > row; space--) {
                System.out.print(" ");
            }
            for (int print = min; print >= 1; print--) {
                System.out.print(Math.abs(print - row));
            }
            min += 2;
            System.out.println("");
        }
    }
}




