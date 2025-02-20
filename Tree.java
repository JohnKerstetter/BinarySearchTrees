
// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
    // package access members
    TreeNode<T> leftNode; // left node
    T data; // node value
    TreeNode<T> rightNode; // right node
    // constructor initializes data and makes this a leaf node

    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(T insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode<>(insertValue);
            } else {// continue traversing left subtree recursively
                leftNode.insert(insertValue);
            }
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null) {
                rightNode = new TreeNode<>(insertValue);
            } else { // continue traversing right subtree recursively
                rightNode.insert(insertValue);
            }
        }
    }
}

// class Tree definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructor initializes an empty Tree of integers
    public Tree() {
        root = null;
    }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue); // create root node
        } else {
            root.insert(insertValue); // call the insert method
        }
    }

    // begin preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }

    // begin postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    // recursive method to perform postorder traversal
    private void postorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    // locate an element in the tree
    public T contains(T value) {
        TreeNode<T> current = root;
        while (current != null) {
            int result = value.compareTo(current.data);
            if (result < 0) {
                current = current.leftNode; // search left subtree
            } else if (result > 0) {
                current = current.rightNode; // search right subtree
            } else {
                return current.data; // element found
            }
        }
        return null; // element not found
    }
}