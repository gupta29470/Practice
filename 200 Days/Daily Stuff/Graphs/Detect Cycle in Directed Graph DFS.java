/*
Reason to use DFS to detect cycle in "Directed Graph" becuase if we encounter
a vertex in recursionStack it means we found a cycle, becuase vertex in 
recursionStack means it neighbors or neighbor's neighbors or somebody
in that hierarchy is still being explored and vertex found a back path to 
vertex in recursionStack indicating there is cycle. 
*/


/*Complete the function below*/

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       
       // keep track of visited vertex
       boolean visited[] = new boolean[V];
       // if we encounter any vertex which has already true value or already present in stack and 
       // remaining to process then has cycle
       boolean recursionStack[] = new boolean[V];
       
       for (int index = 0; index < V; index++){
           if (isCyclicUtil(adj, index, visited, recursionStack)){
               return true;
           }
       }
       return false;
    }
    
    public boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int current, boolean visited[], 
    boolean recursionStack[]){
        
        // if we encounter any vertex which has already true value or already present in stack and 
       // remaining to process then return true means has cycle 
        if (recursionStack[current]){
            return true;
        }
        
        // while returning back and if already visited then mark as false
        if (visited[current]){
            return false;
        }
        
        // not visited or new vertex and new encounter vertex
        recursionStack[current] = true;
        visited[current] = true;
        
        // traverse adjancents
        Iterator<Integer> iterator = adj.get(current).iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            if (isCyclicUtil(adj, next, visited, recursionStack)){
                return true;
            }
        }
        
        // while returning back update vertex value as false it means, that vertex does not encounter
        // second time means no cycle
        recursionStack[current] = false;
        
        // if no cycle detected return false
        return false;
    }
}

/*
Time Complexity: O(V+E).
Time Complexity of this method is same as time complexity

Space Complexity: O(V).
To store the visited and recursion stack O(V) space is needed.
*/



// ****************************** GFG *******************************
// A Java Program to detect cycle in a graph 
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List; 
  
class Graph { 
      
    private final int V; 
    private final List<List<Integer>> adj; 
  
    public Graph(int V)  
    { 
        this.V = V; 
        adj = new ArrayList<>(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>()); 
    } 
      
    // This function is a variation of DFSUtil() in  
    // https://www.geeksforgeeks.org/archives/18212 
    private boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack)  
    { 
          
        // Mark the current node as visited and 
        // part of recursion stack 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = adj.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 
  
    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
  
    // Returns true if the graph contains a  
    // cycle, else false. 
    // This function is a variation of DFS() in  
    // https://www.geeksforgeeks.org/archives/18212 
    private boolean isCyclic()  
    { 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
          
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        Graph graph = new Graph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
          
        if(graph.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
    } 
} 
  
// This code is contributed by Sagar Shah.