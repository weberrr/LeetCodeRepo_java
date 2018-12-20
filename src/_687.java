import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import Utils.*;
/**
 * @author wangz
 * @date 2018/12/3
 */
public class _687 {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return max;
        }
        dfs(root);
        return max;
    }

    //对于每个节点，计算当前节点为拐点时的最大路径长度
    private int dfs(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            if (node.left.val == node.val) {
                left = 1 + dfs(node.left);
            } else {
                //递归遍历它的左子树
                dfs(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.val == node.val) {
                right = 1 + dfs(node.right);
            } else {
                dfs(node.right);
            }
        }
        if (left + right > max) {
            max = left + right;
        }
        return left > right ? left : right;
    }

}
