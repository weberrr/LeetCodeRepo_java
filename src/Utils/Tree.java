package Utils;

import java.util.*;

/**
 * Tree的层次化生成和遍历输出法
 *
 * @date 2018/11/20
 */
public class Tree {

    /**
     * 通过节点列表生成二叉树
     * @param nodeList
     * e.g List<Integer> list = Arrays.asList(1, null, 2, null, null, 3);
     *
     * @return Node root
     *
     */
    public TreeNode buildTree(List<Integer> nodeList) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(nodeList);
        TreeNode root = new TreeNode(linkedList.pollFirst());
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        return generate(root, true, linkedList, queue);
    }

    /**
     * 前序遍历输出树节点的值
     *
     * @param root
     */
    public void printPreTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreTree(root.left);
            printPreTree(root.right);
        }
    }

    /**
     * 层次遍历输出节点的值
     *
     * @param root
     */
    public void printTree(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.print(currentNode.val + " ");
            if (currentNode.left != null) {
                list.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list.add(currentNode.right);
            }
        }
    }

    //辅助树生成方法
    private TreeNode generate(TreeNode root, boolean isLeft, LinkedList<Integer> nodeList, LinkedList<TreeNode> queue) {
        if (nodeList.size() == 0) {
            return root;
        } else {
            TreeNode node = new TreeNode(nodeList.pollFirst());
            queue.add(node);
            TreeNode temp = queue.peekFirst();
            if (isLeft) {
                temp.left = node;
                generate(root, false, nodeList, queue);
            } else {
                temp.right = node;
                queue.pollFirst();
                generate(root, true, nodeList, queue);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, null, 2, null, null, 3);
        Tree tree = new Tree();
        TreeNode root = tree.buildTree(list);
        tree.printPreTree(root);
        tree.printTree(root);
    }


}
