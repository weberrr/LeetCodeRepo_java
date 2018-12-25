import Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 平衡二叉树
 *
 * @date 2018/12/25
 */

public class _110 {
    public boolean isBalanced(TreeNode root) {
        return root == null || isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        else return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
