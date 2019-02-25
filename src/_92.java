import Utils.*;

import java.util.Arrays;

/**
 * 92. 反转链表 II
 *
 * @date 2019/2/25
 */
public class _92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == 1 || m == n) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode mPre = dummyNode;
        ListNode nNext;
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
        }
        cur = mPre.next;
        next = cur.next;
        nNext = next;
        for (int i = 0; i < n - m; i++) {
            nNext = next.next;
            next.next = cur;
            cur = next;
            next = nNext;
        }
        mPre.next.next = nNext;
        mPre.next = cur;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode().createList(Arrays.asList(5, 1));
        head = new _92().reverseBetween(head, 1, 2);
        new ListNode().printList(head);
    }

}
