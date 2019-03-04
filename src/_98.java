import Utils.Tree;
import Utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 *
 * @date 2019/3/4
 */
public class _98 {


    //节点左子树的所有节点都小于当前节点

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        Integer preVal = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (preVal != null && preVal >= p.val) return false;
                preVal = p.val;
                p = p.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new Tree().buildTree(Arrays.asList(2,1,3));
        System.out.println(new _98().isValidBST(root));
    }
}
