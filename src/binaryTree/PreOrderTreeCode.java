package binaryTree;

public class PreOrderTreeCode {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
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
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node head = buildTree(nodes);
        System.out.println(head.val);
    }
}
