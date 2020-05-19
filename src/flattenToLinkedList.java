import java.util.Stack;

public class flattenToLinkedList {
    public static void flatten(TreeNode root) {
        // this looks like a pre order traversal.. the key here is to use another node since you know that java is pass by value and not pass by reference
        TreeNode start = new TreeNode(-1);
        TreeNode s = start;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode c = root;
        while(!stack.isEmpty() || c != null) {
            if(c!= null) {
                start.right = c;
                start = start.right;
                stack.push(c);
                c = c.left;
            } else {
                c = stack.pop();
                c = c.right;
            }
        }
        root = s.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        flatten(root);
    }
}
