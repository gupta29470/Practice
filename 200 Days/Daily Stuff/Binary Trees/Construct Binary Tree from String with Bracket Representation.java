/*
1. Create a global index of int type to traverse string
2. if string is null return null
3. else
	-> redirect to DFS function
		-> 1. every time start of function we create root because every element is 
		root or sub root
		-> 2. if current character is not '(' then we convert character value to int value 
		using getIntegerValue function because our Nodes class takes int parameter.
		-> 3. create left node and right node of Nodes type because every root has left 
		and right nodes
		-> 4. first building left sub tree if current char is '(' then index++ and
		left node = DFS(string) after building left we return
		-> building right sub tree if current char is '(' then index++ and
		right node = DFS(string) after building left we return
		-> if we encounter ')' or index == string.length we assign left node and
		right node to root.left = left node and root.right = right node and index++
		and return root
		
	-> getIntegerValue function
		-> Create String builder 
		-> while loop until index < string.length
			-> if current character is '(' or ')' break loop 
			-> else append to string builder because value can be single-digit(4) or
			multi-digit(444) and increment index
			-> convert string builder to int and return int
		
		
		
*/

public class vit {
	
	//global index of int type to traverse string
    static int index = 0;

    public static void main(String[] args) {

        /* Construct below BST
                  5
                /    \
               /      \
              3        8
             /  \     /  \
            /    \   /    \
           4      2  6    10
         */
        Nodes root = new Nodes(5);
        root.left = new Nodes(3);
        root.right = new Nodes(8);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(2);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(10);

        String s = "4(2(3)(1))(6(5))";
        root = stringToTree(s);

        inorder(root);

    }

    public static Nodes stringToTree(String string) {
        if (string == "") {
            return null; // if string is null return null
        }

        return DFS(string); // else
    }

    public static Nodes DFS(String string) {
		
		// every time start of function we create root because every element is
		// root or sub root
        Nodes root = null;
		
		// if current character is not '(' then we convert character value to 
		// int value using getIntegerValue function because our Nodes class takes 
		// int parameter.
        if (string.charAt(index) != '(') {
            root = new Nodes(getIntegerValue(string));
        }
		
		//create left node and right node of Nodes type because every root has left 
		//and right nodes
        Nodes leftNode = null, rightNode = null;
        
		//first building left sub tree if current char is '(' then index++ and
		//left node = DFS(string) after building left we return
        if (index < string.length() && string.charAt(index) == '(') {
            index++;
            leftNode = DFS(string);
        }
        
		//building right sub tree if current char is '(' then index++ and
		//right node = DFS(string) after building left we return
        if (index < string.length() && string.charAt(index) == '('){
            index++;
            rightNode = DFS(string);
        }
        
		//if we encounter ')' or index == string.length we assign left node and
		//right node to root.left = left node and root.right = right node and 
		//index++ and return root
        root.left = leftNode;
        root.right = rightNode;
        
        index++;
        
        return root;
    }
    
    public static int getIntegerValue(String string){
        StringBuffer sb = new StringBuffer(); //Create String builder 
        
		//while loop until index < string.length
        while (index < string.length()){
			
			//if current character is '(' or ')' break loop 
            if (string.charAt(index) == '(' || string.charAt(index) == ')'){
                break;
            }
            
			//else append to string builder because value can be single-digit(4) or
			//multi-digit(444) and increment index
            sb.append(string.charAt(index));
            index++;
        }
        
		// convert string builder to int and return int
        int val = Integer.valueOf(sb.toString());
        return val;
    }

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}

class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}

