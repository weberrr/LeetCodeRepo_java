import Utils.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 *
 * @date 2019/1/5
 */
public class _23 {

    /**
     * 关键词：堆排序 优先队列
     * 时间复杂度：o(nklogk) ： 每个值都要取一次，一共取nk次。每次更新优先队列要logk的复杂度
     * 空间复杂度：o(k) : 优先队列所占的空间
     * <p>
     * 思路：
     * 构建一个让节点从小到大排序的优先队列（即利用堆排序的性质），
     * 起步输入所有链表的头节点。每次输出一个最小的节点，然后将该节点的next加入队列，使其继续输出
     * 最终形成一个链表
     **/

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
