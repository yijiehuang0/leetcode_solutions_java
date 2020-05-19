public class validateBST {
//
//    public static boolean isValidBST(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        return valid(root);
//    }
//    public static boolean valid(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        if(root.left == null && root.right == null) {
//            return true;
//        }
//
//        boolean left = valid(root.left);
//        boolean right = valid(root.right);
//
//        if(left == false || right == false) {
//            return false;
//        }
//
//
//        if(root.right != null && root.val >= root.right.val) {
//            return false;
//        }
//        if(root.left != null && root.val <= root.left.val ) {
//            return false;
//        }
//        return true;
//    }





    public static boolean  helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;   // if this node is null then we are going to return true;

        int val = node.val; // we get the value of this node;
        if (lower != null && val <= lower) return false;  // then we check for the lower and the upper bounds.
        if (upper != null && val >= upper) return false; // then we check for the lower and the upper bounds.

        if (! helper(node.right, val, upper)) return false;    // we keep going until we are able to check for all of the bounds
        if (! helper(node.left, lower, val)) return false;
        return true;

        // this is to ensure that it holds for certain cases
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }



        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        isValidBST(root);
    }
}


// the problem with this solution is that you need to keep track of how a BST works. And this is just not how a BST works. BST's work with certain bounds
// that tell you where certain bounds lie.

// it is helpful to have ahelper function when you are trying to keep certain variables
