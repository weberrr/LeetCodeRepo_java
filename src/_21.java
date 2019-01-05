import Utils.*;

/**
 * 21. 合并两个有序链表
 *
 * @date 2019/1/5
 */
public class _21 {

    //法1：递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        else {
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    //法2：归并排序
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
}
