import Utils.*;

/**
 * 21. 合并两个有序链表
 *
 * @date 2019/1/5
 */
public class _21 {

    /**
     * 关键词：递归
     * 时间复杂度：o(min(m,n))
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 每次比较两个节点的值大小，然后取大的一个节点和小的节点的next继续递归，知道一边节点空掉即合并完毕
     **/

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


    /**
     * 关键词：循环/归并排序
     * 时间复杂度：o(min(m,n))
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 将之前的递归改用循环实现
     **/

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
