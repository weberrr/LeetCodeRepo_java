/**
 * 完全二叉树的节点个数
 *
 * @date 2018/12/18
 */

import Utils.Tree.*;

public class _222 {

    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        return height < 0 ? 0 : getHeight(root.right) == height - 1 ?
                (1 << height) + countNodes(root.right)
                : (1 << height - 1) + countNodes(root.left);
    }

    int getHeight(TreeNode root) {
        return root == null ? -1 : 1 + getHeight(root.left);
    }

    public static void main(String[] args) {

    }
}
