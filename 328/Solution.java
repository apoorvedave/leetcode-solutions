/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddLast, evenLast, ptr, temp;
        oddLast = evenLast = null;
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        oddLast = head;
        evenLast = head.next;
        boolean isOdd = true;
        ptr = evenLast.next;
        while (ptr != null) {
            temp = ptr;
            ptr = ptr.next;
            if (isOdd) {
                evenLast.next = temp.next;
                temp.next = oddLast.next;
                oddLast.next = temp;
                oddLast = temp;
            } else {
                evenLast = evenLast.next;
            }
            isOdd = !isOdd;
        }
        return head;
    }
}
