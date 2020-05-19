public class reorderList {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode first = head;

        while (first.next != null) {
            ListNode end = getEnd(first);
            ListNode temp = first.next;
            first.next = end;
            first = temp;

            end.next = first;
        }


    }

    public static ListNode getEnd(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        while (head.next != null) {
            if (head.next.next == null) {
                ListNode last = head.next;
                head.next = null;
                return last;
            } else {
                head = head.next;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        reorderList(root);
    }

}
