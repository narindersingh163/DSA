package binaryTree;

public class NumberAndSumOfNodes {
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

    public static int size(Node root){
        if(root == null){
            return 0;
        }

        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,8,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(size(root));
        System.out.println(sum(root));
    }
}
