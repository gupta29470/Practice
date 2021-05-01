/*
If we found node1 or node2 we return that node
4 conditions:
	1. if left and right are not null then we foudn LCA.
	2. if left is not null and right is null then we return left to upper.
	3. if right is not null and left is null then we return right to upper.
	4. if left is  null and right is null then we return null to upper.
*/

public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);

        Nodes lca = lowestCommonAncestor(root, root.left.right, root.right.left);
        System.out.println(lca.data);

    }

    public static Nodes lowestCommonAncestor(Nodes root, Nodes node1, Nodes node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Nodes left = lowestCommonAncestor(root.left, node1, node2);
        Nodes right = lowestCommonAncestor(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
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