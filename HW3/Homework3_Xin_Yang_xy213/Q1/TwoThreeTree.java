import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;

public class TwoThreeTree<T extends Comparable<T>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private TreeNode<T> root;
    private int treeSize;

    /**
     * Constructor of Class TwoThreeTree
     *
     */
    public TwoThreeTree() {
        this.treeSize = 0;
        this.root = null;
    }

    /**
     * Inner Class TreeNode
     *
     * @param <T>
     */
    public class TreeNode<T extends Comparable<T>> {
        public T key;
        public int val;
        public boolean color;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public TreeNode<T> parent;

        /**
         * Constructor of Inner Class TreeNode
         *
         * @param key
         * @param val
         * @param color
         * @param left
         * @param right
         * @param parent
         */
        public TreeNode(T key, int val, boolean color, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }

    /***********************************************************
     *                     Basic APIs
     ***********************************************************/
    /**
     * Put node into the tree
     *
     * @param key
     * @param val
     */
    public void put(T key, Integer val) {
        root = put(root, key, val);
        root.color = BLACK;

        this.treeSize++;
    }

    private TreeNode<T> put(TreeNode<T> parent, T key, Integer val) {
        if (parent == null) {
            return new TreeNode<T>(key, val, RED, null, null, null );
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = put(parent.left, key, val);
        }
        else if (cmp > 0) {
            parent.right = put(parent.right, key, val);
        }
        else {
            parent.val = val;
        }
        // Balance the tree
        if ((parent.right != null && parent.right.color == RED) && (parent.left == null || parent.left.color == BLACK )) {
            parent = rotateLeft(parent);
        }
        if (parent.left != null && parent.left.left != null && parent.left.color == RED && parent.left.left.color == RED) {
            parent = rotateRight(parent);
        }
        if (parent.left != null && parent.right != null && parent.left.color == RED && parent.right.color == RED) {
            parent = flipColor(parent);
        }
        return parent;
    }

    /**
     * Return the value of the key, return -1 if key doesn't exist
     *
     * @param key
     * @return
     */
    public int get(T key) {
       TreeNode temp = find(root, key);
       if (temp == null) {
           return -1;
       }
       else {
           return temp.val;
       }
    }

    /**
     * Return the node having the key
     *
     * @param parent
     * @param key
     * @return
     */
    public TreeNode<T> find(TreeNode<T> parent, T key) {
        if (parent == null) {
            return null;
        }
        int cmp = key.compareTo(parent.key);
        if (cmp == 0) {
            return parent;
        }
        else if (cmp < 0) {
            return find(parent.left, key);
        }
        else if (cmp > 0) {
            return find(parent.right, key);
        }
        return null;
    }

    /**
     * Return true if the sub-tree with the root of the parent node contains the key
     *
     * @param parent
     * @param key
     * @return
     */
    public boolean contains(TreeNode<T> parent, T key) {
        if (find(parent, key) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Return true if the tree is empty
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.treeSize == 0 || this.root == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Return the size of the tree
     *
     * @return
     */
    public int size() {
        return this.treeSize;
    }


    /***********************************************************
     *                 Rotate and Flip Functions
     ***********************************************************/
    /**
     * Left Lean
     *
     * @param h
     * @return
     */
    public TreeNode<T> rotateLeft(TreeNode<T> h) {
        assert h.right.color == RED: "TreeNode " + String.valueOf(h.key) + "'s right link is not RED!";
        TreeNode<T> x = h.right;
        h.right = x.left;
        if (x.left != null) {
            x.left.parent = h;
        }
        x.parent = h.parent;

        if (h.parent == null) {
            this.root = x;
        }
        else if (h.parent.left == h) {
            h.parent.left = x;
        }
        else if (h.parent.right == h) {
            h.parent.right = x;
        }
        x.left = h;
        h.parent = x;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * Right Lean
     *
     * @param h
     * @return
     */
    public TreeNode<T> rotateRight(TreeNode<T> h) {
        assert h.left.color == RED: "TreeNode " + String.valueOf(h.key) + "'s left link is not RED!";
        TreeNode<T> x = h.left;
        h.left = x.right;
        if (x.right != null) {
            x.right.parent = h;
        }
        x.parent = h.parent;

        if (h.parent == null) {
            this.root = x;
        }
        else if (h.parent.left == h) {
            h.parent.left = x;
        }
        else if (h.parent.right == h) {
            h.parent.right = x;
        }
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * Flip the color when two children are red and parent is black, propagate the color upwards
     *
     * @param parent
     * @return
     */
    public TreeNode<T> flipColor(TreeNode<T> parent) {
        assert parent.color == BLACK;
        assert parent.left.color == RED;
        assert parent.right.color == RED;
        parent.color = RED;
        parent.left.color = BLACK;
        parent.right.color = BLACK;
        return parent;
    }

    /**
     * Print by pre-order traversal to show the result, empty nodes are shown as "E"
     *
     * @param node
     */
    public void print(TreeNode node) {
        if (node == null) {
            System.out.println("E");
            return;
        }
        else {
            System.out.println(node.key);
        }
        print(node.left);
        print(node.right);
    }

    /**
     * Main Function, Unit Test
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoThreeTree tree = new TwoThreeTree();
        // This loop determines the data set.
        for (int i = 1; i <= 15; i++) {
            tree.put(i, i);
        }
        tree.print(tree.root);
    }
}