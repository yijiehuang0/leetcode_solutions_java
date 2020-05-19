public class splits {
    public static class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode returnSolution = new ListNode(0);
        ListNode returns = returnSolution;
        int carry = 0;
        int sum  = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                sum = l2.val + carry;
            }
            else if(l2 == null) {
                sum = l1.val + carry;
            } else {
                sum = l1.val + l2.val + carry;
            }
            carry = 0;
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            returns.next = new ListNode(sum);
            returns = returns.next;
            if(l1 != null && l2 != null) {
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null) {
                l1 = l1.next;
            } else if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            returns.next = new ListNode(carry);
        }
        return returnSolution.next;

    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(1);
        addTwoNumbers(l1, l2);
    }
}
