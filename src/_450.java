/**
 * 删除二叉搜索树中的节点(Delete Node in a BST)
 *
 * @date 2018/11/20
 */
public class _450 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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

    public void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null)
                printTree(root.left);
            if (root.right != null)
                printTree(root.right);
        }
    }

    public static void main(String[] args) {
        _450 test = new _450();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.right = treeNode2;
        test.printTree(treeNode1);
        System.out.println("");
        TreeNode res = test.deleteNode(treeNode1, 2);
        test.printTree(res);
    }


}
