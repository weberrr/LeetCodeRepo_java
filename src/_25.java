import Utils.*;

/**
 * 25. k个一组翻转链表
 *
 * @date 2019/1/5
 */
public class _25 {

    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode countLen = head;
        int len = 0;
        while (len < k && countLen != null) {
            countLen = countLen.next;
            len++;
        }
        if (len == k) {
            ListNode prev = null;
            ListNode next = null;
            ListNode cur = head;
            int count = 0;
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) head.next = reverseKGroup(next, k);
            return prev;
        } else {
            return head;
        }
    }

}
