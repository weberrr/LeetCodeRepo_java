import Utils.*;

import java.util.Arrays;
import java.util.List;

/**
 * 删除二叉搜索树中的节点(Delete Node in a BST)
 *
 * @date 2018/11/20
 */
public class _450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //找到要删除节点的左子树中最大的节点，替换到当前
                root.val = getLeftMax(root, root.left, true);
            }
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private int getLeftMax(TreeNode parent, TreeNode child, boolean isLeft) {
        if (child.right == null) {
            if (isLeft) {
                parent.left = child.left;
            } else {
                parent.right = child.left;
            }
            //把左边的最大值传回
            return child.val;
        } else {
            return getLeftMax(child, child.right, false);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        List<Integer> list = Arrays.asList(1, 2, 3);
        TreeNode root = tree.buildTree(list);
        TreeNode res = new _450().deleteNode(root, 3);
        tree.printTree(res);
    }


}
