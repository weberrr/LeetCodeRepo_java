import Utils.TreeNode;

/**
 * 99. 恢复二叉搜索树
 *
 * @date 2019/3/4
 */
public class _99 {

    private TreeNode p, q, last;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);

        //找到p q
        if (last != null && last.val > root.val) {
            if (p == null) p = last;
            q = root;
        }
        last = root;

        traverse(root.right);
    }

}
