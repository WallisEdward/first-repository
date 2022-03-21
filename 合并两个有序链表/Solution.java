/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode presNode = head;
        while (list1 != null && list2 != null){
            if (list1.val <=  list2.val){
                presNode.next = list1;
                list1 = list1.next;
            }else {
                presNode.next = list2;
                list2 = list2.next;
            }
            presNode = presNode.next;
        }
        presNode.next = (list1 == null ? list2 : list1);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(4);
        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);
        mergeTwoLists(l1,l2).print();
    }
}
