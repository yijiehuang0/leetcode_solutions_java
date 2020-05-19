import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    public static List<List<Integer>>  levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList<TreeNode> a= new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                a.add(curr);
            }
            ArrayList<Integer> cumul = new ArrayList<>();
            for(TreeNode t : a) {
                cumul.add(t.val);
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(cumul);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);
    }

    // this just looks like an implementation of bfs
}
