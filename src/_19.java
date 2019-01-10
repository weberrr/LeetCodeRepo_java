import java.util.HashMap;
import Utils.ListNode;
/**
 * 删除链表的倒数第N个节点（Remove Nth Node From End of List）
 *
 * @date 2018/11/16
 */

public class _19 {

    /**
     * 关键词：哈希表
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 将每个节点的下标i以及节点放入hashMap中
     * 删除第i个节点即将map中第i-1个节点的next指针指向i节点的next即可
     **/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        if(index == 1) return null;
        if (index - n == 0) return map.get(1);
        else {
            ListNode preNode = map.get(index - n - 1);
            ListNode node = map.get(index - n);
            preNode.next = node.next;
            return map.get(0);
        }
    }
}
