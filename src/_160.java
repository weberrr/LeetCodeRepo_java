/**
 * 相交链表（Intersection of Two Linked Lists）
 *
 * @date 2018/11/16
 */
import Utils.ListNode;
public class _160 {

    // O(n) 时间复杂度，且仅用 O(1) 内存。
    // 思路：较长的链表先走多出的长度的步长，然后同长度链表比较两者的对象是否相同
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        while (tempA != null) {
            headA = headA.next;
            tempA = tempA.next;
        }
        while (tempB != null) {
            headB = headB.next;
            tempB = tempB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _160 test = new _160();
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(1);
        nodeA.next = nodeB;
        test.getIntersectionNode(null, null);
    }
}
