// 1. FIND NUMBER OF DIGITS IN INTEGER
public class foss {

    public static void main(String[] args) throws IOException {
        long n = 9855475, counter = 0,res=0,nums=n;
        int num=95542587;
        
        //BruteForce Approach
        while (n!=0) {
            n=n/10;
            res++;
        }
        System.out.println(res);
        
        //Better Solution

        counter = (int) Math.floor(Math.log10(nums) + 1); //Important formula to find number of digits in integer.

        System.out.println(counter);
        
        //Better Solution -> if number is int only
        
        String s=Integer.toString(num);
        System.out.println(s.length());
    }
}


//2. ARITHMETIC AND GEOMETRIC PROGRESSION

/* ARITHMETIC PROGRESSION:Arithmetic Progression
A sequence of numbers is said to be in an Arithmetic progression if the difference 
between any two consecutive terms is always the same. 
In simple terms, it means that the next number in the series is calculated by
 adding a fixed number to the previous number in the series. 
 For example, 2, 4, 6, 8, 10 is an AP because difference between any two 
 consecutive terms in the series (common difference) is same 
 (4 - 2 = 6 - 4 = 8 - 6 = 10 - 8 = 2).
 
 General Formulas to solve problems related to Arithmetic Progressions: 
 If ‘a’ is the first term and ‘d’ is the common difference:
nth term of an AP = a + (n-1)*d.
Arithmetic Mean = Sum of all terms in the AP / Number of terms in the AP.
Sum of ‘n’ terms of an AP = 0.5 n (first term + last term) = 0.5 n [ 2a + (n-1) d

Facts about Arithmetic Progression :
1. Initial term: In an arithmetic progression, the first number in the series is called 
the initial term.
2. Common difference: The value by which consecutive terms increase or decrease is 
called the common difference.
3. The behavior of the arithmetic progression depends on the common difference d. 
If the common difference is:positive, then the members (terms) will grow towards
 positive infinity or negative, then the members (terms) will grow towards negative infinity.

*/

public class foss {

    public static void main(String[] args) throws IOException {
        // find nth term(6th term)
        int a=1,sum=0,n=6,d=3;
        sum=a+(n-1)*d;
        System.out.println(sum);
        //output=16
        
        // find Arithmetic progression where start,end and n is given
        int start=3,end=18,nth=4;
        int diff=(end-start)/(nth+1);
        for(int i=1;i<=nth;i++){
            System.out.print((start+i*diff)+" ");
        }
        //output=6 9 12 15
        
        // find Arithmetic mean
        int arr[]={2,4,6,8,10,12};
        int sums=0,result=0;
        for(int i=0;i<arr.length;i++){
            sums+=arr[i];
        }
        int len=arr.length;
        result=sums/len;
        System.out.println(result);
        //output 42/7=6
        
        //Sum of n terms
        int initial=2,differ=1,nths=4;
         double sumss=0.5*nths*(2*initial+(nths-1)*differ);
         int valu=(int)sumss;
         System.out.println(valu);
    }
}



/* GEOMETRIC PROGRESSION
A sequence of numbers is said to be in a Geometric progression if the ratio of any
 two consecutive terms is always same. In simple terms, it means that next number
 in the series is calculated by multiplying a fixed number to the previous number 
 in the series.For example, 2, 4, 8, 16 is a GP because ratio of any two consecutive 
 terms in the series (common difference) is same (4 / 2 = 8 / 4 = 16 / 8 = 2).
 
 
 General Formulas to solve problems related to Geometric Progressions:

If ‘a’ is the first term and ‘r’ is the common ratio:
nth term of a GP = a*rn-1.
Geometric Mean = nth root of product of n terms in the GP.
Sum of ‘n’ terms of a GP (r < 1) = [a (1 – rn)] / [1 – r].
Sum of ‘n’ terms of a GP (r > 1) = [a (rn – 1)] / [r – 1].
Sum of infinite terms of a GP (r < 1) = (a) / (1 – r)
*/
import java.util.*;
import java.io.*;
import java.math.*;

public class foss {

    public static void main(String[] args) throws IOException {
        
        /*nth term of a GP = a*rn-1.
Geometric Mean = nth root of product of n terms in the GP.
Sum of ‘n’ terms of a GP (r < 1) = [a (1 – rn)] / [1 – r].
Sum of ‘n’ terms of a GP (r > 1) = [a (rn – 1)] / [r – 1].
Sum of infinite terms of a GP (r < 1) = (a) / (1 – r).*/
        
        
        
        
        // find nth term(4th term)   nth term of a GP = a*rn-1.
        // 110 220 440 880 1760 difference =2
        // 110*2=220    220*2=440...
        int a=110;
        double n=4,r=2,res;
        res=Math.pow(r, n-1)*a;
        int ress=(int)res;
        System.out.println(ress);
        
        // Geometric Mean  Geometric Mean = nth root of product of n terms in the GP.
        double b=15 * 12 * 13 * 19 * 10;
        float mean=(float)Math.pow(b,(float)1/5);
        System.out.println(mean);
        
        
    //  Sum of geometric mean if r<1 where r is difference
        float f=1f,rat=0.5f; int num=10;
        float pow=(float)(Math.pow((float)rat, num));
        System.out.println("POW:"+pow);
        float sum=(float)(f*(1-pow))/(1-rat);
        System.out.println(sum);
        
        //output 1.9980469
        
        //  Sum of geometric mean if r<1 where r is difference
        
        float start=2,ratio=2;int number=15;
        float power=(float)Math.pow(ratio,number);
        float sums=(float)(start*(power-1))/(ratio-1);
        System.out.println(sums);
        
        //output 65534.0
        
        // sum of inginite terms
        sums=0;
        sums=(start)/(1-ratio);
         System.out.println(sums);
         
         //output -2.0
        
    }
}





/* Quadratic Equation
A quadratic equation is a second-order polynomial equation of a variable say x. 
The general form of a quadratic equation is given as:
a*x2 + b*x + c = 0

Where a,b and c are real known values and,
a can't be zero.

roots = (-b ± √(b2 - 4ac))/2a
*/
public class foss {

    public static void main(String[] args) throws IOException {

        /*Quadratic equation
         determinant=b^2-4ac
         if determinant >0 roots are real and different
         if determinant == 0 roots are real and equal
         if determinant <0 roots are real and complex
      
         */
        double a = 15, b = 168, c = 3;
        double root1, root2;

        double determi = b * b - 4 * a * c;
        System.out.println(determi);
        if (determi > 0) {
            root1 = (-b + Math.sqrt(determi)) / (2 * a);
            root2 = (-b - Math.sqrt(determi)) / (2 * a);
            System.out.println("Roots are real and different");
            System.out.println(root1 + " " + root2);
        } else if (determi == 0) {
            root1 = root2 = (-b) / 2 * a;
            System.out.println("Roots are real and equal");
        } else {
            double real_part = -b / (2 * a);
            double imaginary_part = Math.sqrt(-determi) / (2 * a);
            System.out.println(real_part + "    " + imaginary_part);
            System.out.println("Roots are real and complex");
        }

    }
}


/*Mean and Median
Median: Median is the middle value of a set of data. To determine the median value 
in a sequence of numbers, the numbers must first be arranged in an ascending order.


Formula for finding Median :
If the count of numbers is odd: After sorting the sequence,
Median = {(N+1)/2}th value.
If the count of numbers is even: After sorting the sequence,
Median  =  Average of (N/2)th and {(N/2) + 1}th value.

*/
public class foss {

    public static void main(String[] args) throws IOException {

        // Mean
        int a[]={2,4,4,4,5,5,7,9,9};
        int sum=0;
        for(int i:a){
            sum+=i;
        }
        int mean=sum/a.length;
         System.out.println("Mean:"+a[mean]);
        
        
        //Median
        // if len is in odd
        int median=(a.length+1)/2;
         System.out.println("Median:"+a[median]);

        int b[]={2,4,5,6,7,8,9};
        // if len is in even
        median=(((b.length)/2)+(b.length+1)/2)/2;
        System.out.println("Median:"+b[median]);
    }
}





