/**
 * 相同的树
 *
 * @date 2018/12/18
 */

import Utils.Tree.*;

public class _100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) || ((p != null && q != null && p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = null;
        System.out.println(new _100().isSameTree(p, q));
    }
}
