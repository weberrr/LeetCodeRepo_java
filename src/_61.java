import Utils.*;

/**
 * 61. 旋转链表
 *
 * @date 2019/1/17
 */
public class _61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode countLen = head;
        int len = 0;
        while (countLen != null) {
            countLen = countLen.next;
            len++;
        }
        k %= len;
        ListNode tail = head;
        for (int i = 0; i < len - k - 1; i++) {
            tail = tail.next;
        }
        ListNode prePartHead = tail.next;
        if (prePartHead != null) {
            ListNode prePartTail = prePartHead;
            while (prePartTail.next != null) {
                prePartTail = prePartTail.next;
            }
            prePartTail.next = head;
            tail.next = null;
            return prePartHead;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _61().rotateRight(null, 0).val);
    }
}
