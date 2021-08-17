import java.util.*;
import java.io.*;

public class practice_1 {

	static int shortestPath = Integer.MAX_VALUE;

	public static void main(String args[]) {
		char maze[][] = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };

		int entrance[] = { 1, 2 };

		System.out.println(nearestExit(maze, entrance));
	}

	public static int nearestExit(char[][] maze, int[] entrance) {
		int rowLen = maze.length, colLen = maze[0].length;
        int distanceFromEntrance[][] = new int[rowLen][colLen];
        boolean visited[][] = new boolean[rowLen][colLen];
        int shortestPath = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int array[] : distanceFromEntrance){
            Arrays.fill(array, - 1);
        }
        
        queue.add(new int[] {entrance[0], entrance[1], 0});
        
        
        while (!queue.isEmpty()){
            int currentArray[] = queue.poll();
            int rowIndex = currentArray[0], colIndex = currentArray[1], distance = currentArray[2];
            
            if ((rowIndex < 0) || (colIndex < 0) || (rowIndex >= rowLen) || (colIndex >= colLen)){
                continue;
            }
            
            if (maze[rowIndex][colIndex] != '.'){
                continue;
            }
            
            if (visited[rowIndex][colIndex]){
                continue;
            }
            
            visited[rowIndex][colIndex] = true;
            distanceFromEntrance[rowIndex][colIndex] = distance;
            
            queue.add(new int[] {rowIndex + 1, colIndex, distance + 1});
            queue.add(new int[] {rowIndex - 1, colIndex, distance + 1});
            queue.add(new int[] {rowIndex, colIndex + 1, distance + 1});
            queue.add(new int[] {rowIndex, colIndex - 1, distance + 1});
        }
        
        System.out.println("Reach");
        
        for(int index = 0; index < rowLen; index++){
            int currentDistance = distanceFromEntrance[index][0];
            if (currentDistance > 0){
                shortestPath = Math.min(shortestPath, currentDistance);
            }
            
            currentDistance = distanceFromEntrance[index][colLen - 1];
            if (currentDistance > 0){
                shortestPath = Math.min(shortestPath, currentDistance);
            }
        }
        
        for(int index = 0; index < colLen; index++){
            int currentDistance = distanceFromEntrance[0][index];
            if (currentDistance > 0){
                shortestPath = Math.min(shortestPath, currentDistance);
            }
            
            currentDistance = distanceFromEntrance[rowLen - 1][index];
            if (currentDistance > 0){
                shortestPath = Math.min(shortestPath, currentDistance);
            }
        }
        
        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
	}
}

