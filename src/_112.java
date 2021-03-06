import java.util.HashSet;
import java.util.Set;

/**
 * 路径总和
 *
 * @date 2018/12/3
 */
import Utils.*;
public class _112 {

    //深度优先搜索
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && (root.left == null && root.right == null && root.val == sum || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }


    public static void main(String[] args) {
        System.out.println(new _112().hasPathSum(null, 1));
    }
}
