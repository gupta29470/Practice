/*
You will be given a value n, print the first n + 1 whole numbers in lexicographically order
Example n = 13;
0
1
10
11
12
13
2
3
4
5
6
7
8
9

I will say bring me 1 to n + 1 all lexicographically number, 2 to n + 1 all 
lexicographically number, 3 to n all lexicographically number... and so on.

I will just print 0 or value.

It will print all values start with 1, then print all values start with 2... then 3, 4... n

lexicographically(n , 10 * value + _value): To convert 0 to 1 = 10 * 0 + 1 = 1.
Convert 1 to 10: 10 * 1 + 0 = 10
Convert 1 to 100 : 10 * 10 + 0 = 100...

To convert 0 to 2 : 10 * 0 + 2.
2 to 20 : 10 * 2 + 0 = 20
20 to 200 : 10 * 20 + 0 = 200...
 so on and so forth
*/

public class Practice {

    public static void main(String args[]){
        int n = 20, value = 0;
        
        lexicographically(n, value);
    }
    
    public static void lexicographically(int n, int value){
        // base case
        if (value > n){
            return;
        }
        
        // self work
        System.out.println(value);
        
        // recursive assumption
        for (int _value = (value == 0) ? 1 : 0; _value <= 9; _value++){
            lexicographically(n , 10 * value + _value);
        }
    }
}
