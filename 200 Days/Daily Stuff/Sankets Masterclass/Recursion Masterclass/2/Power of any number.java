public class Practice {

    public static void main(String[] args) {
        int number = 5, power = 5;

        System.out.println(power(number, power));
    }

    public static int power(int number, int power) {
		
		// base case
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return number;
        }
		
		// recursive assumption
        int subPower = power(number, power - 1);
		
		// self work
        return number * subPower;
    }
}
// Time --> O(power)   Space --> O(power)



			/********************* OPTIMIZE SOLUTION **************************/
			
/*
-> If power is even then : answer = ((number)^(power / 2) * (number)^(power / 2))

-> If power is odd then answer = (number * (number)^(power / 2) * (number)^(power / 2))
*/
public class Practice {

    public static void main(String[] args) {
        int number = 5, power = 5;

        System.out.println(power(number, power));
    }

    public static int power(int number, int power) {
		
		// base case
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return number;
        }
		
		// recursive assumption
        int halfSubPower = power(number, power / 2);
		
		// self work
        if (power % 2 == 0){
            return halfSubPower * halfSubPower;
        }
        else{
            return number * halfSubPower * halfSubPower;
        }
    }
}
// Time --> O(logb)   Space --> O(logb)