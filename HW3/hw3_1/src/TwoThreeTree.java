import apple.laf.JRSUIUtils;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;

public class TwoThreeTree<T extends Comparable<T>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private TreeNode<T> root;
    private int treeSize;

    // constructor
    public TwoThreeTree() {
        this.treeSize = 0;
        this.root = null;
    }

    // Inner class definition: TreeNode
    public class TreeNode<T extends Comparable<T>> {
        public T key;
        public int val;
        public boolean color;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public TreeNode<T> parent;
        // Inner class TreeNode constructor
        public TreeNode(T key, int val, boolean color, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }






    // --------------------------------- Basic APIs -------------------------------

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

        //平衡化操作
        if (parent.right.color == RED && parent.left.color == BLACK) {
            parent = rotateLeft(parent);
        }
        if (parent.left.color == RED && parent.left.left.color == RED) {
            parent = rotateRight(parent);
        }
        if (parent.left.color == RED && parent.right.color == RED) {
            parent = flipColor(parent);
        }

        return parent;
    }



    public int get(T key) {
       TreeNode temp = find(root, key);
       if (temp == null) {
           return -1;
       }
       else {
           return temp.val;
       }
    }

    // TODO: delete
    public void delete(T key) {
        if (!contains(root, key)) return;

        // if both children of root are black, set root to red
        if (root.left.color == BLACK && root.right.color == BLACK) {
            root.color = RED;
        }

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;


        this.treeSize--;
    }
    private TreeNode<T> delete(TreeNode<T> parent, T key) {
        // assert get(h, key) != null;

        if (key.compareTo(parent.key) < 0)  {
            if (parent.left.color == BLACK && parent.left.left.color == BLACK) {
                parent = moveRedLeft(parent);
            }
            parent.left = delete(parent.left, key);
        }
        else {
            if (parent.left.color == RED)
                parent = rotateRight(parent);
            if (key.compareTo(parent.key) == 0 && (parent.right == null))
                return null;
            if (parent.right.color == BLACK && parent.right.left.color == BLACK)
                parent = moveRedRight(parent);
            if (key.compareTo(parent.key) == 0) {
                TreeNode<T> x = min(parent.right);
                parent.key = x.key;
                parent.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                parent.right = deleteMin(parent.right);
            }
            else parent.right = delete(parent.right, key);
        }
        return balance(parent);
    }



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

    public boolean contains(TreeNode<T> parent, T key) {
        if (find(parent, key) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (this.treeSize == 0 || this.root == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return this.treeSize;
    }


    // TODO: write iterator
    public Iterable<T> keys() {
        Iterable<T> iterator = new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return null;
            }
        };
        return iterator;
    }

    // ---------------------- Rotation and Flip ---------------------------

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

    public TreeNode<T> flipColor(TreeNode<T> parent) {
        assert parent.color == BLACK;
        assert parent.left.color == RED;
        assert parent.right.color == RED;
        parent.color = RED;
        parent.left.color = BLACK;
        parent.right.color = BLACK;
        return parent;
    }

}
