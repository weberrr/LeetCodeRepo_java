import Utils.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @date 2019/3/4
 */
public class _83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        while (head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
