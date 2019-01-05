import Utils.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 *
 * @date 2019/1/5
 */
public class _23 {


    //时间复杂度 o(nlogk)  空间复杂度 o(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        //创建优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
        //添入首轮节点
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.offer(lists[i]);
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            //加入最小值的下个节点 o(logk)
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummyNode.next;
    }
}
