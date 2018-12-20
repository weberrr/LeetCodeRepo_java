import Utils.*;

import java.util.Arrays;
import java.util.List;

/**
 * Invert Binary Tree(翻转二叉树)
 *
 * @date 2018/11/16
 */
public class _226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        List<Integer> list = Arrays.asList(4,2,7,1,3,6,9);
        TreeNode root = tree.buildTree(list);
        TreeNode res = new _226().invertTree(root);
        tree.printTree(res);
    }

}
