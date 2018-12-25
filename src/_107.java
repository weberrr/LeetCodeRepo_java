import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Utils.*;

/**
 * 二叉树的层次遍历 II
 *
 * @date 2018/12/25
 */

public class _107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<List<TreeNode>> stack = new Stack<>();
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        stack.push(rootList);
        while (!stack.isEmpty()) {
            List<TreeNode> perTier = stack.pop();
            List<TreeNode> nextTier = new ArrayList<>();
            List<Integer> perList = new ArrayList<>();
            for (TreeNode node : perTier) {
                perList.add(node.val);
                if (node.left != null) nextTier.add(node.left);
                if (node.right != null) nextTier.add(node.right);
            }
            if (nextTier.size() != 0) stack.push(nextTier);
            res.add(0, perList);
        }
        return res;
    }
}
