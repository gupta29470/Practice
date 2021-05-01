/*
To understand below program: Give a matrix
	row - 0		{ 0, 0, 0, 0, 0 },
    row - 1     { 1, 0, 0, 0, 0 },
    row - 2     { 0, 0, 0, 1, 0 },
    row - 3     { 0, 0, 0, 0, 0 },
    row - 4     { 1, 1, 1, 1, 0 }
	
1. if any row value sum is 0(zero) it is considered as leaf node(0, 3)
2. if any row value is 1 it is considered as parent of leaf node(1, 2)
// above matrix we don't have sum 2
3. Likewise if any row value is 2 it is considered as parent of(1, 2) 
4. Row 4 has sum 4 so it is maximum. So row 4(value 4) is root node.

Approach:
1. We have create a Treemap key as Integer and Value as ArrayList
2. key will be row sum and value will be row (as two row can have same sum. 
Eg : 1, 2)
3. We have create a Node array to store nodes value, a boolean parent array to keep
track of parent, and last variable to keep track of current node data.
4. We traverse Treemap. If key is zero(0) i.e sum is 0 it is leaf node will do
nothing
5. If key is non zero or sum is not zero, then we traverse that whole row(key's row).
6. If parent[index] is false means if leaf node or decendant node has no parent and
matrix[row][index] is 1, then we check if current node's left is null then we 
assign node[index] value to left side else right side.
7. we update parent[index] = true.
8. return node[last] because max sum value is root of tree and in Treemap data is 
sorted according to key(sum). we will return root;
*/

import java.util.*;
 
// key structure to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Utility function to print binary tree nodes in-order fashion
    public static void inorder(Node node)
    {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
 
    // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                        Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
 
    // Function to construct a binary tree from specified ancestor matrix
    public static Node constructBT(int[][] mat)
    {
        // get number of rows in the matrix
        int N = mat.length;
 
        // create an empty multi-map
        Map<Integer, List<Integer>> multimap = new TreeMap<>();
 
        // Use sum as key and row numbers as values in the multi-map
        for (int i = 0; i < N; i++)
        {
            // find the sum of the current row
            int sum = Arrays.stream(mat[i]).sum();
 
            // insert the sum and row number into the multimap
            insertIntoMultiMap(multimap, sum, i);
        }
 
        // node[i] will store node for i in constructed tree
        Node[] node = new Node[N];
        int last = 0;
 
        // the value of parent[i] is true if parent is set for i'th node
        boolean[] parent = new boolean[N];
 
        // Traverse the TreeMap in sorted order (default behavior)
        for (Map.Entry<Integer, List<Integer>> entry: multimap.entrySet())
        {
            for (int row: entry.getValue())
            {
                last = row;
                // create a new node
                node[row] = new Node(row);
 
                // if leaf node, do nothing
                if (entry.getKey() == 0) {
                    continue;
                }
 
                // traverse row
                for (int i = 0; i < N; i++)
                {
                    // do if parent is not set and ancestor exits
                    if (parent[i] == false && mat[row][i] == 1)
                    {
                        // check for the unoccupied node
                        if (node[row].left == null) {
                            node[row].left = node[i];
                        } else {
                            node[row].right = node[i];
                        }
 
                        // set parent for i'th node
                        parent[i] = true;
                    }
                }
            }
        }
 
        // last processed node is the root
        return node[last];
    }
 
    // Construct a Binary Tree from Ancestor Matrix
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 0 }
        };
 
        Node root = constructBT(mat);
        inorder(root);
    }
}