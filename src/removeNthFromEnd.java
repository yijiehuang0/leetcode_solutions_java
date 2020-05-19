public class removeNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        int length = 0;
        while(first != null) {
            first = first.next;
            length++;
        } // this will give us five for the first run through

        // we should always index by zero for certain reasons of simplicity
        // length == 1 in this case.
        int target = length - n; // this should give use the second to last thing that we need in order to remove such thing
        // we should not just recurse upon the
        first = dummy;
        while(target > 0) {
            first = first.next;
            target--;
        }
        first.next = first.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        removeNthFromEnd(root, 1);
    }
}
