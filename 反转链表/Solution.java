public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
             ListNode one = curr.next;
             curr.next = prev;
             prev = curr;
             curr = one;
        }
        return prev;
    }
}
