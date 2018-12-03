import java.util.HashSet;
import java.util.Set;

/**
 * 路径总和
 *
 * @date 2018/12/3
 */
public class _112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //深度优先搜索
    public boolean hasPathSum(TreeNode root, int sum) {
        Set<Integer> set = new HashSet<>();
        dfs(set, root, 0);
        return set.contains(sum);
    }

    private void dfs(Set<Integer> set, TreeNode node, int sub) {
        if(node==null){
            return;
        }
        sub += node.val;
        if (node.left == null && node.right == null) {
            set.add(sub);
        } else {
            if (node.left != null) {
                dfs(set, node.left, sub);
            }
            if (node.right != null) {
                dfs(set, node.right, sub);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _112().hasPathSum(null,1));
    }
}
