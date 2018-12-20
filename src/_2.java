import Utils.*;

/**
 * 两数相加
 *
 * @date 2018/12/20
 */

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + bit;
            bit = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + bit;
            bit = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + bit;
            bit = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l2 = l2.next;
        }
        while (bit != 0) {
            temp.next = new ListNode(bit % 10);
            temp = temp.next;
            bit = bit / 10;
        }
        return res.next;
    }

}
