/**
 * 完全二叉树的节点个数
 *
 * @date 2018/12/18
 */

import Utils.*;

public class _222 {

    //当左子树和右子树一样高时，说明左子树本身是一颗满二叉树，它的元素个数为2^h左-1。
    //当左子树比右子树高时，说明右子树本身是一颗满二叉树，它的元素个数为2^h右-1(h为树的高度)
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
