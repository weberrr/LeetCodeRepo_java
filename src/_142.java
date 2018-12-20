/**
 * 环形链表 II (Linked List Cycle  II)
 *
 * @date 2018/11/26
 */
import Utils.ListNode;
public class _142 {

    //快慢双指针，注意快慢指针时间关系等式： (a+b+n*r)/2 = (a+b)/1 其中b+x=r（环长度）
    //可以得到 a = x + (n-1)r
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        else if (head.next == head) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
