import Utils.*;

/**
 * 25. k个一组翻转链表
 *
 * @date 2019/1/5
 */
public class _25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        if (len < k) {
            return head;
        } else {
            for (int i = 0; i < len; i+=k) {

            }
        }
        return head;
    }

}
