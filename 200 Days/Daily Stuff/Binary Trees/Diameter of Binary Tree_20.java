public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

        Nodes root = new Nodes(44);
        root.left = new Nodes(9);
        root.right = new Nodes(13);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        int diameter = getDiameter(roots);
        System.out.println(diameter);
    }
    
    public static int  getDiameter(Nodes root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);
        
        int diameter = Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
        return diameter;
    }

    public static int height(Nodes root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
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
 