import Utils.ListNode;

/**
 * 147. 对链表进行插入排序
 *
 * @date 2019/3/14
 */
public class _147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        insertSort(dummyNode, head);
        return dummyNode.next;
    }

    private void insertSort(ListNode dummyNode, ListNode head) {
        ListNode curNode = null, preNode = dummyNode;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            if (curNode != null && curNode.val > temp.val) {
                preNode.next = temp;
                temp.next = curNode;
            } else {
                curNode = curNode.next;
            }
        }
    }

}
