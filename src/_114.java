/**
 * 二叉树展开为链表
 *
 * @date 2018/12/4
 */
public class _114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归：深度优先搜索
    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null) {
                flatten(right);
            } else {
                flatten(left);
                flatten(right);
                TreeNode temp = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.left = null;
                root.right = temp;
            }
        }
    }
}
