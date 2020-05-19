import com.sun.source.tree.Tree;

import java.util.*;


// make something into a class variable if you want it to be changed by something

public class DeleteNodesAndReturnForeste {


    public static List<TreeNode> DeleteNodesAndReturnForest(TreeNode root, int[] vals) {
        List<TreeNode> ret = new ArrayList<>();
        Set<Integer> toDel = new HashSet<>();
        if(root == null) {
            return ret;
        }
        for(int i: vals) {
            toDel.add(i);
        }
        recurse(root, toDel, ret);
        if(!toDel.contains(root.val)) {
            ret.add(root);
        }
        return null;
    }

    public static TreeNode recurse(TreeNode root, Set<Integer> toDel, List<TreeNode> ret) {
        if(root == null) {
            return null;
        }
        root.right = recurse(root.right, toDel, ret);
        root.left = recurse(root.left, toDel, ret);  // this ensures that we get to the end of the recursion

        if(toDel.contains(root.val)) {
            if(root.left != null) {
                ret.add(root.left);
            }
            if(root.right != null) {
                ret.add(root.right);
            }
            return null;
            // effectively stops the recursion.
        }
        /*
        perform any operation on the tree
         */

        return root; // this is necessary for the final step of this recursion.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);


    }


}
