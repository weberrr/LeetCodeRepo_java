/**
 * 路径总和 III
 *
 * @date 2018/12/3
 */
import Utils.*;

public class _437 {

    public int num = 0;

    public int pathSum(TreeNode root, int sum) {
        boolean flag = false;
        dfs(root, sum, flag);
        return num;
    }

    private void dfs(TreeNode node, int sum, boolean start) {
        if (node != null) {
            if (node.val == sum) {
                num++;
            }
            if (!start) {
                dfs(node.left, sum, false);
                dfs(node.right, sum, false);
            }
            dfs(node.left, sum - node.val, true);
            dfs(node.right, sum - node.val, true);
        }
    }
}
