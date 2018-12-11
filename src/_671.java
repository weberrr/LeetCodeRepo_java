import java.util.Arrays;
import java.util.List;

/**
 * 二叉树中第二小的节点
 *
 * @date 2018/12/11
 */
import Utils.Tree.TreeNode;
import Utils.Tree;

public class _671 {

    //递归， 空间复杂度o(n)
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left != null) {
            int left = root.left.val, right = root.right.val;
            if (left == root.val) {
                left = findSecondMinimumValue(root.left);
            }
            if (right == root.val) {
                right = findSecondMinimumValue(root.right);
            }
            if (left != -1 && right != -1) {
                return Math.min(left, right);
            } else {
                return left == -1 ? right : left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        List<Integer> list = Arrays.asList(2, 2, 5, null, null, 5, 7);
        Tree.TreeNode root = tree.buildTree(list);
        System.out.println(new _671().findSecondMinimumValue(root));
    }
}
