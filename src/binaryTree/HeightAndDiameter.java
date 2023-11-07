package binaryTree;

public class HeightAndDiameter {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info{
        int height;
        int diameter;
        public Info(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int idx = -1;

    public static Node buildTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static Info heightAndDiameter(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info left = heightAndDiameter(root.left);
        Info right = heightAndDiameter(root.right);

        int selfD = left.height + right.height + 1;
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(selfD, Math.max(left.diameter, right.diameter));

        return new Info(height, diameter);
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftD = diameter(root.left);
        int rightD = diameter(root.right);
        int leftH = height(root.left);
        int rightH = height(root.right);

        int selfD = leftH + rightH + 1;
        return Math.max(selfD, Math.max(leftD, rightD));
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(height(root));
        System.out.println(diameter(root));
        Info i = heightAndDiameter(root);
        System.out.println(i.diameter);
    }
}
