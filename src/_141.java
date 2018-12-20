/**
 * 环形链表(Linked List Cycle)
 */
import Utils.ListNode;
public class _141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
