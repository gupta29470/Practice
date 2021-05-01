/*
1. Compute in-degree(number of incoming edges for each vertexes).
for each of the vertex present in the graph and initialize the count of visited nodes as 0.
2. Enque all the vertexes in queue who has 0 incoming edges.
3. One by one poll vertex from queue and then
	-> decrease in-degree by 1 for all its neighbouring vertexes
	-> increment count of visited vertexes by 1
	-> if indegree of neighbouring vertex is 0 then add in queue
4. if count of visited vertex is not equals to V then there is cycle, 
otherwise not.
*/




/*Complete the function below*/

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // storing in-degree(number of incoming edges for each vertes)
        int []incomingEdges = new int[V];
        // initialize with 0
        Arrays.fill(incomingEdges, 0);
        
        // Traverse adjacency lists to fill indegrees of vertices. This step takes O(V+E) time
        for (int index = 0; index < V; index++){
            for (int data : adj.get(index)){
                incomingEdges[data]+= 1;
            }
        }
        
        // Create an queue and enqueue all vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        
        for (int index = 0; index < V; index++){
            if (incomingEdges[index] == 0){
                queue.add(index);
            }
        }
        
        // Initialize count of visited vertices
        int countVisited = 0;
        
        // Create a vector to store result (A topological ordering of the vertices)
        Vector<Integer> visitedVertex = new Vector<>();
        
        while (!queue.isEmpty()){
            
            // Extract front of queue (or perform dequeue) and add it to topological order
            int currentVertex = queue.poll();
            visitedVertex.add(currentVertex);
            
            // Iterate through all its neighbouring nodes of dequeued node u and decrease their in-degree
            // by 1
            Iterator<Integer> iterator = adj.get(currentVertex).iterator();
            while (iterator.hasNext()){
                int next = iterator.next();
                if (--incomingEdges[next] == 0){
                    queue.add(next);
                }
            }
            countVisited+= 1;
        }
        // Check if there was a cycle
        if (countVisited != V){
            return true;
        }
        return false;
    }
}

















// Java program to check if there is a cycle in 
// directed graph using BFS.
import java.io.*;
import java.util.*;
 
class GFG
{
 
    // Class to represent a graph
    static class Graph
    {
        int V; // No. of vertices'
 
        // Pointer to an array containing adjacency list
        Vector<Integer>[] adj;
 
        @SuppressWarnings("unchecked")
        Graph(int V)
        {
            // Constructor
            this.V = V;
            this.adj = new Vector[V];
            for (int i = 0; i < V; i++)
                adj[i] = new Vector<>();
        }
 
        // function to add an edge to graph
        void addEdge(int u, int v)
        {
            adj[u].add(v);
        }
 
        // Returns true if there is a cycle in the graph
        // else false.
 
        // This function returns true if there is a cycle
        // in directed graph, else returns false.
        boolean isCycle() 
        {
 
            // Create a vector to store indegrees of all
            // vertices. Initialize all indegrees as 0.
            int[] in_degree = new int[this.V];
            Arrays.fill(in_degree, 0);
 
            // Traverse adjacency lists to fill indegrees of
            // vertices. This step takes O(V+E) time
            for (int u = 0; u < V; u++)
            {
                for (int v : adj[u])
                    in_degree[v]++;
            }
 
            // Create an queue and enqueue all vertices with
            // indegree 0
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < V; i++)
                if (in_degree[i] == 0)
                    q.add(i);
 
            // Initialize count of visited vertices
            int cnt = 0;
 
            // Create a vector to store result (A topological
            // ordering of the vertices)
            Vector<Integer> top_order = new Vector<>();
 
            // One by one dequeue vertices from queue and enqueue
            // adjacents if indegree of adjacent becomes 0
            while (!q.isEmpty())
            {
 
                // Extract front of queue (or perform dequeue)
                // and add it to topological order
                int u = q.poll();
                top_order.add(u);
 
                // Iterate through all its neighbouring nodes
                // of dequeued node u and decrease their in-degree
                // by 1
                for (int itr : adj[u])
                    if (--in_degree[itr] == 0)
                        q.add(itr);
                cnt++;
            }
 
            // Check if there was a cycle
            if (cnt != this.V)
                return true;
            else
                return false;
        }
    }
 
    // Driver Code
    public static void main(String[] args) 
    {
 
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
 
        if (g.isCycle())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
 
// This code is contributed by
// sanjeev2552