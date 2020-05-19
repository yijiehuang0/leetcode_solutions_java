public class subTreeOfAnotherTree {
    public boolean traverse(TreeNode s, TreeNode t) {
        return s!=null && (equals(s,t) || traverse(s.right, t) || traverse(s.left, t));
    }


    // we use a couple of shell functions in order to dive deeper into this problem. For instance, we need something that checks if this subtree is equals or we can traverse the left or the right of this tree as well, and that would work as well.
    public boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val != t.val ) {
            return false;
        }

        return equals(s.right, t.right) && equals(s.left, t.left);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
}
