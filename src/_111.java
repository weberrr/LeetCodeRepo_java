import Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的最小深度
 *
 * @date 2018/12/25
 */
public class _111 {


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        else if (root.left == null && root.right == null) return 1;
        else {
            return Math.min(dfs(root.left), dfs(root.right)) + 1;
        }
    }

}
