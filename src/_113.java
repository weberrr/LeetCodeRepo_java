import java.util.*;

/**
 * 路径总和 II
 *
 * @date 2018/12/3
 */
public class _113 {
    public class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            int s = 0;
            for (int i = 0; i < list.size(); i++) {
                s += list.get(i);
            }
            if (s == sum)
                res.add(new ArrayList<Integer>(list));
        } else {
            if (node.left != null) {
                dfs(res, list, node.left, sum);
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                dfs(res, list, node.right, sum);
                list.remove(list.size() - 1);
            }
        }
    }

}
