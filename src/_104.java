/**
 * 二叉树的最大深度
 *
 * @date 2018/12/17
 */

import Utils.Tree;
import Utils.Tree.*;

import java.util.Arrays;

public class _104 {

    public int maxDepth(TreeNode root) {
        int depth = 1;
        if (root == null) return 0;
        if (root.left != null || root.right != null) {
            depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = tree.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        tree.printPreTree(root);
        System.out.println(new _104().maxDepth(root));
    }
}
