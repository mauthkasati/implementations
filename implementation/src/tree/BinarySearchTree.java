package tree;

public class BinarySearchTree {

    // Define a class for each node of the tree
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    // Method to insert a new node into the tree
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        // If the tree is empty, create a new node and make it the root
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // Return the unchanged root
        return root;
    }

    // Method to delete a node from the tree
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        // If the tree is empty, return null
        if (root == null) {
            return root;
        }

        // Recur down the tree
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // If the node has only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // If the node has two children, get the inorder successor (smallest in the
            // right subtree)
            root.value = minValueRec(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        // Return the unchanged root
        return root;
    }

    // Method to search for a node in the tree
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        // If the tree is empty or the value is found at the root, return true
        if (root == null || root.value == value) {
            return root != null;
        }

        // Recur down the tree
        if (value < root.value) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    // Method to perform an inorder traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Method to perform a preorder traversal of the tree
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method to perform a postorder traversal of the tree
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Method to get the level of a node in the tree
    public int levelOfNode(int value) {
        return levelOfNodeRec(root, value, 1);
    }

    private int levelOfNodeRec(Node root, int value, int level) {
        // If the tree is empty or the value is found at the root, return the level
        if (root == null || root.value == value) {
            return level;
        }

        // Recur down the tree
        if (value < root.value) {
            return levelOfNodeRec(root.left, value, level + 1);
        } else {
            return levelOfNodeRec(root.right, value, level + 1);
        }
    }

    // Method to get the height of the tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Otherwise, recur down the tree and find the height of the left and right
        // subtrees
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        // Return the maximum of the left and right subtree heights plus 1 for the root
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to get the minimum height of the tree
    public int minHeight() {
        return minHeightRec(root);
    }

    private int minHeightRec(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Otherwise, recur down the tree and find the height of the left and right
        // subtrees
        int leftHeight = minHeightRec(root.left);
        int rightHeight = minHeightRec(root.right);

        // Return the minimum of the left and right subtree heights plus 1 for the root
        return Math.min(leftHeight, rightHeight) + 1;
    }

    // Method to get the maximum height of the tree
    public int maxHeight() {
        return maxHeightRec(root);
    }

    private int maxHeightRec(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Otherwise, recur down the tree and find the height of the left and right
        // subtrees
        int leftHeight = maxHeightRec(root.left);
        int rightHeight = maxHeightRec(root.right);

        // Return the maximum of the left and right subtree heights plus 1 for the root
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to get the height of a specific node in the tree
    public int heightOfNode(int value) {
        return heightOfNodeRec(root, value);
    }

    private int heightOfNodeRec(Node root, int value) {
        // If the tree is empty or the value is found at the root, return 0
        if (root == null || root.value == value) {
            return 0;
        }

        // Recur down the tree and add 1 for each level
        if (value < root.value)
            return heightOfNodeRec(root.left, value) + 1;
        else {
            return heightOfNodeRec(root.right, value) + 1;
        }
    }

    // Method to get the count of nodes in the tree
    public int countOfNodes() {
        return countOfNodesRec(root);
    }

    private int countOfNodesRec(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Otherwise, recur down the tree and add 1 for each node
        return countOfNodesRec(root.left) + countOfNodesRec(root.right) + 1;
    }

    // // Method to get the minimum value in the tree
    // public int minValue() {
    //     Node current = root;
    //     while (current.left != null) {
    //         current = current.left;
    //     }
    //     return current.value;
    // }

    // // Method to get the maximum value in the tree
    // public int maxValue() {
    //     Node current = root;
    //     while (current.right != null) {
    //         current = current.right;
    //     }
    //     return current.value;
    // }
    public int minValue(){
        return minValueRec(root);
    }
    private int minValueRec(Node root) {
        int min = root.value;
        
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        
        return min;
    }
    
    public int maxValue() {
        return maxValueRec(root);
    }
    
    private int maxValueRec(Node root) {
        int max = root.value;
        
        while (root.right != null) {
            max = root.right.value;
            root = root.right;
        }
        
        return max;
    }
    // Method to check if the tree is balanced
    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node root) {
        // If the tree is empty, return true
        if (root == null) {
            return true;
        }

        // Get the height of the left and right subtrees
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        // If the difference between the heights is greater than 1, return false
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Otherwise, check if the left and right subtrees are balanced recursively
        return isBalancedRec(root.left) && isBalancedRec(root.right);
    }

    // Main method to test all the above methods
    public static void main(String[] args) {
        BinarySearchTree  tree = new BinarySearchTree ();

        // Insert some nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        // tree.insert((10));
        
        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        // Test search method
        System.out.println("Search for 20: " + tree.search(20));
        System.out.println("Search for 90: " + tree.search(90));

        tree.delete(70);
        // Test inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        // Test preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.println();

        // Test postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postorder();
        System.out.println();

        // Test levelOfNode method
        System.out.println("Level of node with value 20: " + tree.levelOfNode(20));
        System.out.println("Level of node with value 70: " + tree.levelOfNode(70));

        // Test height and minHeight methods
        System.out.println("Height of tree: " + tree.height());
        System.out.println("Minimum height of tree: " + tree.minHeight());

        // Test maxHeight method
        System.out.println("Maximum height of tree: " + tree.maxHeight());

        // Test heightOfNode method
        System.out.println("Height of node with value 20: " + tree.heightOfNode(20));
        System.out.println("Height of node with value 70:" + tree.heightOfNode(70));
        // Test countOfNodes method
        System.out.println("Count of nodes in tree: " + tree.countOfNodes());

        // Test minValue method
        System.out.println("Minimum value in tree: " + tree.minValue());

        // Test maxValue method
        System.out.println("Maximum value in tree: " + tree.maxValue());

        // Test isBalanced method
        System.out.println("Tree is balanced: " + tree.isBalanced());
    }

}
