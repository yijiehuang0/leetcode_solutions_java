import java.util.*;
public class iterativeTraversals {
//    public List<Integer> inorderTraversal(TreeNode root) {   // in order traversal uses a stack while the other traversals both use linkedLists instead
//        List < Integer > res = new ArrayList < > ();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root; // while the current node is not going to to be null we perform this operation a
//        while( current != null || !stack.isEmpty()) { // we learn that the order of these conditions do matter, and if we want something to terminate sooner than latter than we add it appropriately to the front whether it be a true or false statement depending on if it is an "and" or and "or" statement
//            while(current != null) {
//                stack.add(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            res.add(current.val);
//            current = current.right;
//        }
//
//
//
//        return res;
//
//    }

    public List<List<Integer>> levelOrder(TreeNode root) { // this is going to be similar to bfs
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());
            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>(); // we have a quee here
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);       // pushing makes it become a stack
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

}
