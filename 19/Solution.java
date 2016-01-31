/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode ptr = head;
        int size = 1;
        while (ptr.next != null) {
            size++;
            ptr = ptr.next;
        }
        if (size == n) {
            return head.next;
        }
        int count = 1;
        ptr = head;
        while (count+1 < size - n +1){
            count++;
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
