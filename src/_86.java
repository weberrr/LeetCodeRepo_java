import Utils.*;

/**
 * 86. 分隔链表
 *
 * @date 2019/2/25
 */
public class _86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(0);
        ListNode indexNode1 = dummyNode1;
        ListNode dummyNode2 = new ListNode(0);
        ListNode indexNode2 = dummyNode2;
        while (head != null) {
            if (head.val < x) {
                indexNode1.next = head;
                head = head.next;
                indexNode1 = indexNode1.next;
                indexNode1.next = null;
            } else {
                indexNode2.next = head;
                head = head.next;
                indexNode2 = indexNode2.next;
                indexNode2.next = null;
            }
        }
        indexNode1.next = dummyNode2.next;
        return dummyNode1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = node1;
        node3.val = 4;
        node3.next = node2;
        System.out.println(node1.val);
    }

}
