/*
isCyclic:
	-> create a boolean visited array
	-> for loop for vertices
		-> if current vertex is not visited then pass list, current, 
		visited, V to isCyclicUtil iterative function
			-> if isCyclicUtil return true then return true
			
			-> isCyclicUtil function:
				-> create parent array of size V and mark all for -1
				-> enqueue current in queue and mark current as visited
				-> while queue is not empty
					-> poll element(current)
					-> iterate adjacent of current
						-> if (next is not visited) then mark next as visited
						true, enqueue next in queue and next's parent will
						be current
						else it is already visited then check if 
						parent[current] != next if true return true
			return false
return false
*/

import java.io.*;
import java.util.*;

class Graph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int vertexes = 5;
        for (int index = 0; index < vertexes; index++) {
            list.add(new ArrayList<>());
        }

        addAdjancencyList(list, 0, 1);
        addAdjancencyList(list, 0, 3);
        addAdjancencyList(list, 0, 2);
        addAdjancencyList(list, 1, 2);
        addAdjancencyList(list, 3, 4);

        System.out.println(isCyclic(list, 5));
    }

    public static void addAdjancencyList(ArrayList<ArrayList<Integer>> list,
            int vertex1, int vertex2) {
        list.get(vertex1).add(vertex2);
        list.get(vertex2).add(vertex1);
    }

    // Returns true if the graph contains a cycle, else false.
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> list,
            int vertexes) {

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertexes];

        for (int index = 0; index < vertexes; index++) {
            if (!visited[index]) {
                if (isCyclicUtil(list, index, visited, vertexes)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> list,
            int current, boolean visited[], int vertexes) {

        // Set parent vertex for every vertex as -1. 
        int parent[] = new int[vertexes];
        Arrays.fill(parent, -1);

        // Create a queue for BFS 
        Queue<Integer> queue = new LinkedList<>();
        // Mark the current node as visited and enqueue it 
        queue.add(current);
        visited[current] = true;

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it 
            current = queue.poll();
  
           // Get all adjacent vertices of the dequeued vertex u. 
          // If a adjacent has not been visited, then mark it visited 
          // and enqueue it. We also mark parent so that parent is not considered 
          // for cycle. 
            Iterator<Integer> iterator = list.get(current).iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = current;
                } else if (parent[current] != next) {
                    return true;
                }
            }

        }
        return false;

    }
}
