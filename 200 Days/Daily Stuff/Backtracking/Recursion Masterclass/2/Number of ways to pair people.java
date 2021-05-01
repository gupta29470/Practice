/*

Given that there are p people. Each person can either join go to party as a single 
individual or as a pair with any other. The task is to find the number of different ways 
in which p people can go to party.

persons = A, B, C, D

Base case 1 : if persons == 1 then only one way to go to party (A)
Base case 2 : if persons == 2 then only two way to go to party ((A), (B) and (A, B))

Sub problem assumption:
1. If A wants to go to party alone then no of ways A can go to party is depend on 
no of ways n - 1 go to party.
-> A, B, C, D
-> A, (B, C), D
-> A, (B, D), C
-> A, B, (C, D)
4 ways.


2. If A wants to go to party with pair, so A can make pair with B or C or D at once.
(i) If A pair with B the no. of ways they can go to party is depends on number of ways
C and D go to party.

If A makes pair it is blocking himself and another person also i.e total 2 person. 
So number of person left for making decision is n - 2

-> ((A, B), C, D)
-> ((A, B), (C, D))

(ii) If A pair with C the no. of ways they can go to party is depends on number of ways
B and D go to party.

-> ((A, C), B, D)
-> ((A, C), (B, D))

(iii) If A pair with D the no. of ways they can go to party is depends on number of ways
B and D go to party.

-> ((A, D), B, C)
-> ((A, D), (B, C))

A can make pair with n - 1 and go with n - 2.
i.e (n - 1) * f(n - 2) = (3 * f(2)) = (3 * 2) = 6 ways

recurrence relation = f(n - 1) + ((n - 1) * f(n - 2))

*/



public class Practice {

    public static void main(String[] args) {
        int persons = 4;
        
        System.out.println(waysToParties(persons));
    }
    
    public static int waysToParties(int persons){
        if (persons == 1 || persons == 2){
            return persons;
        }
        return waysToParties(persons - 1) + (persons - 1) * waysToParties(persons - 2);
    }
}
