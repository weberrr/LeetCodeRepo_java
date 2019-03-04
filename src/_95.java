import Utils.Tree;
import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @date 2019/3/4
 */

public class _95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTree(start, i - 1);
            List<TreeNode> subRightTree = generateTree(i + 1, end);
            for (TreeNode leftTree : subLeftTree) {
                for (TreeNode rightTree : subRightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
