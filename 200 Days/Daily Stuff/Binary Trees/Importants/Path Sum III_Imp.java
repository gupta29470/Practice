/*
1. create a arraylist to store paths
2. getNumberOfPath function:
	-> if root is null return 0
	-> put every node in list
	-> initialze pathCount = 0, currSum = 0, size = path.size();
	-> here size will be one path of tree
	-> while one path >= 0
		-> add from last of list to current sum beacuse for being equal to K 
		it may include root or not so we start from end of list
		-> if current sum == K then increment pathCount
		-> traverse left of tree
		-> traverse right of tree
		-> remove last element from list as it is processed
		-> return pathCount
*/

class Solution {
    public int pathSum(TreeNode root, int K) {
        List<Integer> path = new ArrayList<>(); //to store paths
        
        return getNumberOfPath(root, K, path);
    }
    
    private int getNumberOfPath(TreeNode root, int K, List<Integer> path){
        if(root == null){
            return 0;
        }
        
        path.add(root.val); //put every node in list
		
		//initialze pathCount = 0, currSum = 0, size = path.size();
        int pathCount = 0, currSum = 0, size = path.size();
		
		//here size will be one path of tree
		//while one path >= 0
        while(--size >= 0){
			
		//add from last of list to current sum beacuse for being equal to K 
		//it may include root or not so we start from end of list
            currSum += path.get(size);
			
			//if current sum == K then increment pathCount
            if(currSum == K){
                pathCount++;
            }
        }
        
        pathCount += getNumberOfPath(root.left, K, path);//traverse left of tree
        pathCount += getNumberOfPath(root.right, K, path);//traverse right of tree
		
		//remove last element from list as it is processed
        path.remove(path.size()-1);
        
		//return pathCount
        return pathCount;
    }
}