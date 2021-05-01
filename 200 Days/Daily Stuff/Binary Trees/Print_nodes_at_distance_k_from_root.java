class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          if (root == null){
              return new ArrayList<>();
          }
          
          ArrayList<Integer> result = new ArrayList<>(); // to store results nodes
          int temp = 0; // trigger variable
          
          _Kdistance(root, k, result, temp);
          
          return result;
     }
     
     void _Kdistance(Node root, int k, ArrayList<Integer> result, int temp){
         if (root == null){
             return;
         }
         
         if (temp == k){ // if trigger variable is equal to k(distance) add that node
             result.add(root.data); 
         }
         
         if (temp > k){ // if trigger variable is greater than k(distance) then no meaning of going further
             return;
         }
         
         _Kdistance(root.left, k, result, temp + 1);
         _Kdistance(root.right, k, result, temp + 1);
     }
}
