import java.util.ArrayList;
import java.util.List;

/**
 * @author wangz
 * @date 2018/11/15
 */
public class _654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int startIndex = 0;
        int endIndex = list.size() - 1;
        while (endIndex > startIndex) {
            int sum = list.get(startIndex) + list.get(endIndex);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                endIndex -= 1;
            } else {
                startIndex += 1;
            }
        }
        return false;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
