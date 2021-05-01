/*
The game is simple. You initially have ‘H’ amount of health and ‘A’ amount of armor. At any instant you can live in any of the three places - fire, water and air. After every unit time, you have to change your place of living. For example if you are currently living at fire, you can either step into water or air.

If you step into air, your health increases by 3 and your armor increases by 2

If you step into water, your health decreases by 5 and your armor decreases by 10

If you step into fire, your health decreases by 20 and your armor increases by 5

If your health or armor becomes <=0, you will die instantly

Find the maximum time you can survive.

Input:

The first line consists of an integer t, the number of test cases. 
For each test case there will be two positive integers representing the initial health H 
and initial armor A.


Output:

For each test case find the maximum time you can survive.

Note: You can choose any of the 3 places during your first move.

Input Constraints:

1 <= t <= 10
1 <= H, A <= 1000

Example:

Sample Input:

3
2 10
4 4
20 8
Sample Output:

1
1
5

*/


/*
if we have sufficient health and armor, we'll go to water. Else, if health is sufficient 
enough and armor is not sufficient, go to fire. Else, it's over!
*/


public class prat {

    public static void main(String[] args) {
        int health = 20, armor = 8;

        System.out.println(dieHard(health, armor));
    }

    public static int dieHard(int health, int armor) {
        int airHealth = 3, airArmor = 2;
        int waterHealth = 5, waterArmor = 10;
        int fireHealth = 20, fireArmor = 5;
        int jump = 1;
        int surviveCount = 0;

        while (health > 0) {
            // air
            if (jump % 2 != 0) {
                health = health + airHealth;
                armor = armor + airArmor;;
            } // water and fire 
            else {
                if (health >= waterHealth && armor >= waterArmor) {
                    health = health - waterHealth;
                    armor = armor - waterArmor;
                } 
                else if (health >= fireHealth) {
                    health = health - fireHealth;
                    armor = armor + fireArmor;
                }
                else{
                    break;
                }
            }
            if (health > 0) {
                surviveCount++;
            }
            jump++;
        }
        return surviveCount;
    }

}
// Time --> O(health)