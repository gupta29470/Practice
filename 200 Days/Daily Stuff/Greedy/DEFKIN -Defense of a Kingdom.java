/*
Theodore implements a new strategy game “Defense of a Kingdom”. On each level a player 
defends the Kingdom that is represented by a rectangular grid of cells. 
The player builds crossbow towers in some cells of the grid. The tower defends all the 
cells in the same row and the same column. No two towers share a row or a column.

The penalty of the position is the number of cells in the largest undefended rectangle. 
For example, the position shown on the picture has penalty 12.
*/


/*
I would do it like this:

Given w, h as width and height of the playing field, and the coordinates of the towers as 
(x1,y1) .. (xN,yN), split the coordinates into two lists x1..xN, y1..yN, sort both of those
 coordinate lists.

Then calculate the empty spaces, e.g. dx[] = { x1, x2-x1, ..., xN - xN-1, (w + 1) - xN }. 
Do the same for the y coordinates: dy[] = { y1, y2-y1, ..., yN - yN-1, (h + 1) - yN }. 
Multiply max(dx)-1 by max(dy)-1 and you should have the largest uncovered rectangle. 
You have to decrement the delta values by one because the line covered by the higher 
coordinate tower is included in it, but it is not uncovered.
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int width = 15, height = 8, noOfTowers = 3;
        int towerPositions[][] = {{3, 8}, {11, 2}, {8, 6}};

        System.out.println(defenseKingdom(width, height, noOfTowers, towerPositions));
    }

    public static int defenseKingdom(int width, int height, int noOfTowers,
            int towerPositions[][]) {

        int xCordinates[] = new int[noOfTowers];
        int yCordinates[] = new int[noOfTowers];
        int EmptySpaceX[] = new int[noOfTowers + 1];
        int EmptySpaceY[] = new int[noOfTowers + 1];

        for (int index = 0; index < noOfTowers; index++) {
            xCordinates[index] = towerPositions[index][0];
            yCordinates[index] = towerPositions[index][1];
        }

        Arrays.sort(xCordinates);
        Arrays.sort(yCordinates);

        EmptySpaceX[0] = xCordinates[0];
        EmptySpaceY[0] = yCordinates[0];

        for (int index = 1; index < noOfTowers; index++){
            EmptySpaceX[index] = xCordinates[index] - xCordinates[index - 1];
            EmptySpaceY[index] = yCordinates[index] - yCordinates[index - 1];
        }

        EmptySpaceX[noOfTowers] = (width + 1) - xCordinates[noOfTowers - 1];
        EmptySpaceY[noOfTowers] = (height + 1) - yCordinates[noOfTowers - 1];

        for (int data : EmptySpaceX) {
            System.out.print(data + " ");
        }
        System.out.println("");

        for (int data : EmptySpaceY) {
            System.out.print(data + " ");
        }
        System.out.println("");

        int xMax = Arrays.stream(EmptySpaceX).max().getAsInt();
        int yMax = Arrays.stream(EmptySpaceY).max().getAsInt();
        
        return ((xMax - 1) * (yMax - 1));
    }
}
// Time --> O(2(n log n) + n)