/*
Given V number of vertex and list which has graph
1. create boolean array to keep track of visited nodes
2. add 0 in queue and mark 0 as visited
3. traverse queue
	-> pop element from queue and add in result list
	-> iterator for visisting connected vertex
		-> if nt visited mark visited and add in queue
*/

class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // V refers to number of vertex.
        // visited boolean array
        boolean []visited = new boolean[V];
        
        // Queue to store vertex and implement BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // put 0 in queue and mark 0 as visited in visited array
        queue.add(0);
        visited[0] = true;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()){
            // polling element from queue
            int current = queue.poll();
            
            result.add(current);
            
            // iterator for visisting connected vertex
            Iterator<Integer> iterator = adj.get(current).listIterator();
            while (iterator.hasNext()){
                int next = iterator.next();
                // if not visited
                if (!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return result;
    }
}

// Time Complexity: O(V+E) where V is number of vertices in the graph and E 
// is number of edges in the graph.

// Space Complexity: O(V). 
// Since, an extra visited array is needed of size V.