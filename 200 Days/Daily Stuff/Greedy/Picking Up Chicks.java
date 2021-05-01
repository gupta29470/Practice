/*
We will traverse chickPosition array from end beacuse if ahead chicks reach destination
then only chicks behind it reach.

1. We calculate distanceToCover by barn position - chick initial position
2. We calculate how much distance they can actually cover by multiplying time and speed
3. if distanceToCover is less than or equals to actually they cover distance then 
increment count and if cantReach is greater than zero add cantReach to swaps
4. else if distanceToCover is greater than actually they cover distance then increment
cantReach we have to swap that much chicks.
5. if count is equals to wantChicks break
6. if count is not equals to wantChicks it means it is impossible to supply that much
amount of chicks return -1
7. else return swaps
*/

public class prat {

    public static void main(String[] args) {
        int numberOfChicks = 5;
        int wantChicks = 3;
        int barn = 10;
        int time = 5;
        
        int chickPositions[] = {0, 2, 3, 5, 7};
        int speeds[] = {2, 1, 1, 1, 4};
        
        System.out.println(minimumSwaps(numberOfChicks, wantChicks, barn, time,
                chickPositions, speeds));
    }

    public static int minimumSwaps(int numberOfChicks, int wantChicks, int barn,
            int time, int chickPosition[], int speeds[]) {

        int swaps = 0, count = 0, cantReach = 0;
        
        for (int index = numberOfChicks - 1; index >= 0; index--){
            int distanceToCover = barn - chickPosition[index];
            int canCover = time * speeds[index];
            
            if (distanceToCover <= canCover){
                count++;
                
                if (cantReach > 0){
                    swaps+= cantReach;
                }
            }
            else{
                cantReach++;
            }
            
            if (count == wantChicks){
                break;
            }
        }
        
        if (count != wantChicks){
            return -1;
        }
        return swaps;
    }

}
// Time --> O(n)
