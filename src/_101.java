import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @date 2018/12/4
 */
public class _101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || checkChild(root.left, root.right);
    }

    private boolean checkChild(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return checkChild(left.left, right.right) && checkChild(left.right, right.left);
            }
        }
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            else if (left == null || right == null) return false;
            else if (left.val != right.val) return false;
            else {
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
        }
        return true;
    }

}


