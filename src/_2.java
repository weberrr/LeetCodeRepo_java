import Utils.*;

/**
 * 2. 两数相加
 *
 * @date 2018/12/20
 */

public class _2 {

    /**
     * 关键词：链表
     * 时间复杂度：o(max(m,n))
     * 空间复杂度：o(max(m,n)) 新链表长最多为 max(m,n)+1
     * <p>
     * 思路：节点的值依次相加，注意进位
     **/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int bit = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + bit;
            bit = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (bit > 0) {
            curr.next = new ListNode(bit);
        }
        return dummyHead.next;
    }

}
