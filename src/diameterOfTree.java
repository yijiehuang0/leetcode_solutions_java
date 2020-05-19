public class diameterOfTree {
    static int max = 0; // we need somethign that keeps track of the depths of the left and the right
    public static  int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return max;
    }

    public static int f(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        int left = 0;
        if(root.left != null) {
            left = 1 + diameterOfBinaryTree(root.left);
        }
        int right = 0;
        if(root.right != null) {
            right = 1 + diameterOfBinaryTree(root.right);
        }
        max = Math.max(left + right, max);
        return Math.max(right, left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        diameterOfBinaryTree(root);
    }
}
