package binaryTree;

public class IsSubTree {

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
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

    public static boolean isSubTree(Node root, Node subRoot){
        if(root == null)
            return false;

        if(root.val == subRoot.val){
            if(isIdentical(root, subRoot))
                return true;
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null)
            return true;

        if(root == null || subRoot == null)
            return false;

        if(root.val != subRoot.val)
            return false;

        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        boolean isSubTree = isSubTree(root, subRoot);
        System.out.println(isSubTree);
    }
}
