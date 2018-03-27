import java.io.*;
import java.util.Scanner;

public class BST {
    public TreeNode root;

    public BST() {}

    /**
     * TreeNode class
     *
     */
    class TreeNode {
        public int val;
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){}

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Put
     *
     * @param key
     * @param val
     * @return
     */
    public void put(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
        }
        else {
            put(root, newNode);
        }
    }

    private TreeNode put(TreeNode node, TreeNode newNode) {
        if (node == null) {
            node = newNode;
            return node;
        }
        if (newNode.key == node.key) {
            node.val = newNode.val;
        }
        else if (newNode.key < node.key) {
                node.left = put(node.left ,newNode);
        }
        else if (newNode.key > node.key) {
            node.right = put(node.right, newNode);
        }
        return node;
    }

    /**
     * Rank
     *
     * @param key
     * @return
     */
    public int rank(int key) {
        //int keyInt = Integer.parseInt(key);
        return rank(key, root);
    }

    private int rank(int key, TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (key < node.key) {
            return rank(key, node.left);
        }
        else if (key > node.key) {
            return 1  + size(node.left) + rank(key, node.right);
        }
        else {
            return size(node.left);
        }
    }

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Select
     *
     * @param rank
     * @return
     */
    public int select(int rank) {
        return inorderSelect(root, rank) != null ? inorderSelect(root, rank).key : -1;
    }

    private TreeNode inorderSelect(TreeNode node, int rank) {
        if (node == null) {
            return null;
        }
        if (rank == size(node.left)) {
            return node;
        }
        else if (rank < size(node.left)) {
            return inorderSelect(node.left, rank);
        }
        else {
            return inorderSelect(node.right, rank - size(node.left) - 1);
        }
    }

    /**
     * Unit test
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BST bst = new BST();
        String filepath = "./select-data.txt";
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        int i = 0;
        while((s = br.readLine()) != null)
        {
            bst.put(Integer.parseInt(s), i);
            //System.out.println(Integer.parseInt(s) + " " + i);
            i++;
        }
        //System.out.println(bst.root.right.right.key + "s" + bst.size(bst.root.right.right));
        System.out.println("Please type the key to rank");
        Scanner input = new Scanner(System.in);
        int rankKey = input.nextInt();
        System.out.println("Rank " + rankKey + ": " + bst.rank(rankKey));
        System.out.println("Please type the rank to select");
        int keyRank = input.nextInt();
        System.out.println("Select " + keyRank + ": " + bst.select(keyRank));
    }
}