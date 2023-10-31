package tree;
public class BST{

    private MyNode root;

    private class MyNode{
        int value;
        MyNode left, right;

        MyNode(int val){
            this.value = val;
            left = null;
            right = null;
        }
    }

    // insert method
    public void insret(int val){
        root = insertRec(root, val);
    }
    private MyNode insertRec(MyNode root, int val){
        if(root == null){
            root = new MyNode(val);
            return root;
        }
        if(val < root.value){
            root.left = insertRec(root.left, val);
        }
        else if(val > root.value){
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    // search method
    public boolean search(int val){
        return searchRec(root, val);
    }
    private boolean searchRec(MyNode root, int val){
        if(root == null || root.value == val){
            return root != null;
        }

        if(val < root.value){
            return searchRec(root.left, val);
        }
        else {
            return searchRec(root.right, val);
        }
    }


    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(MyNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(MyNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(MyNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }


    public int levelOfNode(int val){
        return levelOfNodeRec(root, val, 1);
    }
    private int levelOfNodeRec(MyNode root, int val, int level){
        // return level of added node if not exist
        if(root == null || root.value == val){
            return level;
        }

        // // other solution to return 0 if not exist
        // if(root == null)return 0;
        // if(root.value == val) return level;

        if(val < root.value){
            return levelOfNodeRec(root.left, val, level+1);
        }
        else {
            return levelOfNodeRec(root.right, val, level+1);
        }
    }


}