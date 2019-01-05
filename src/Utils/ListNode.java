package Utils;

import java.util.List;

/**
 * 链表节点工具类
 *
 * @date 2018/12/20
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
        val = 0;
        next = null;
    }

    public ListNode createList(List<Integer> list) {
        if (list == null || list.size() == 0) return null;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return dummyNode.next;
    }

    public void printList(ListNode head) {
        StringBuilder res = new StringBuilder();
        while (head != null) {
            res.append(head.val).append("->");
            head = head.next;
        }
        System.out.println(res.length() > 2 ? res.toString().substring(0, res.length() - 2) : res.toString());
    }
}

