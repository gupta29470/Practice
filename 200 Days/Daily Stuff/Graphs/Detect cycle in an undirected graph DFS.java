/*
isCyclic function:
	-> create a boolean visited vertex
	-> mark all vertices false
	-> for loop for vertices
		-> if current vertex is not visited
			-> pass list, current, visited -1(parent) to util function.
			if util function is true then return true
			
			-> isCyclicUtil:
				-> mark current vertex is visited
				-> iterator to its adjacent vertices
					-> if adjacent vertices is not visited call isCyclicUtil
					function again and pass list, next, visited, current
					(next's parent will be current)
					
					-> else if adjacent vertices is visited then check
					if next != parent return true(has cycle)
					
			return false
	return false
*/

import java.io.*; 
import java.util.*; 

class Graph{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int vertexes = 5;
        for (int index = 0; index < vertexes; index++){
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
            int vertex1, int vertex2){
        list.get(vertex1).add(vertex2);
        list.get(vertex2).add(vertex1);
    }
    
    // Returns true if the graph contains a cycle, else false.
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> list,
            int vertexes){
        
        // Mark all the vertices not visited and not part of recursion stack
        boolean visited[] = new boolean[vertexes];
        Arrays.fill(visited, false);
        
        
        // Call the recursive helper function to detect cycle in different DFS trees 
        for (int index = 0; index < vertexes; index++){
            // Don't recur for index if already visited 
            if (!visited[index]){
                if (isCyclicUtil(list, index, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    
     
    
    // A recursive function that uses visited[] and parent to detect 
    // cycle in subgraph reachable from vertex current. 
    public static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> list,
            int current, boolean visited[], int parent){
        
        // Mark the current node as visited 
        visited[current] = true;
        
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> iterator = list.get(current).iterator();
        
        while (iterator.hasNext()){
            int next = iterator.next();
            // If an adjacent is not visited, then recur for that 
            // adjacent 
           if (!visited[next]){
                if (isCyclicUtil(list, next, visited, current)){
                    return true;
                }
            }
           // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle.
           else if(next != parent){
               return true;
           }
        }
        return false;
    }
}

/*
Complexity Analysis: 

Time Complexity: O(V+E). 
The program does a simple DFS Traversal of the graph which is represented 
using adjacency list. So the time complexity is O(V+E).
Space Complexity: O(V). 
To store the visited array O(V) space is required.
*/