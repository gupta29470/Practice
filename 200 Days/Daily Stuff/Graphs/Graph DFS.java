// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // boolean visited array
        boolean []visited = new boolean[V];
        
        // storing results
        ArrayList<Integer> result = new ArrayList<>();
        
        // traversing each vertex
        for (int index = 0; index < V; index++){
            // if not visited then go to DFSUtil
            if (visited[index] ==false){
                DFSUtil(adj, index, visited, result);
            }
        }
        return result;
    }
    
    public void DFSUtil(ArrayList<ArrayList<Integer>> adj, int current, boolean []visited, 
    ArrayList<Integer> result){
        
        // visit the current vertex
        visited[current] = true;
        // adding in result
        result.add(current);
        
        // Iterating connected vertex 
        Iterator<Integer> iterator = adj.get(current).listIterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            // if next not visited then recursively call util passing next in place of current
            if (!visited[next]){
                DFSUtil(adj, next, visited, result);
            }
        }
    }
}

// Time Complexity: O(V+E) where V is number of vertices in the graph and E 
// is number of edges in the graph.

// Space Complexity: O(V). 
// Since, an extra visited array is needed of size V.