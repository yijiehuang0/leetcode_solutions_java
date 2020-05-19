import  java.util.*;
public class sortedListToBST {
    static List<TreeNode> bst = new ArrayList<>();
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        addtolist(head);
        return find(0, bst.size());
    }
    public static void addtolist(ListNode head) {
        while(head != null) {
            bst.add(new TreeNode(head.val));
            head = head.next;
        }
    }

    public static TreeNode find(int start, int end) {
        if(end == start) {
            return null;
        }
        if(end -1 == start) {
            return bst.get(start);
        }
        int mid = start + (end - start)/2;
        TreeNode root = bst.get(mid);
        root.left = find(start, mid);
        root.right = find(mid +1, end);
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-10);
        root.next = new ListNode(-3);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(9);
        sortedListToBST(root);
    }
}
