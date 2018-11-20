/**
 * Invert Binary Tree(翻转二叉树)
 *
 * @date 2018/11/16
 */
public class _226 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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

    public void printTree(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                printTree(root.left);
            } else {
                System.out.println("null");
            }
            System.out.println(root.val);
            if (root.right != null) {
                printTree(root.right);
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        _226 test = new _226();
//        TreeNode treeNode1 = new TreeNode(4);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(7);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(3);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(9);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        TreeNode res = test.invertTree(treeNode1);
        test.printTree(res);
    }

}
