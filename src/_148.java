import Utils.ListNode;

/**
 * 148. 排序链表
 *
 * @date 2019/3/14
 */
public class _148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = null;
        while (slow != null && quick.next != null) {
            pre = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        pre.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curNode.next = l;
                curNode = curNode.next;
                l = l.next;
            } else {
                curNode.next = r;
                curNode = curNode.next;
                r = r.next;
            }
        }
        if (l != null) {
            curNode.next = l;
        }
        if (r != null) {
            curNode.next = r;
        }
        return dummyNode.next;
    }

}
