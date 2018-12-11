package Utils;

import java.util.*;

/**
 * Tree的层次化生成和遍历输出法
 *
 * @date 2018/11/20
 */
public class Tree {
    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(Integer x) {
            val = x;
        }
    }

    public TreeNode buildTree(List<Integer> nodeList) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(nodeList);
        TreeNode root = new TreeNode(linkedList.pollFirst());
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        return generate(root, true, linkedList, queue);
    }

    //nodelist存储所有未成树节点，queue存储所有未添加左右子树关系的节点
    public TreeNode generate(TreeNode root, boolean isLeft, LinkedList<Integer> nodeList, LinkedList<TreeNode> queue) {
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

    public void printPreTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreTree(root.left);
            printPreTree(root.right);
        }
    }

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

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, null, 2, null, null, 3);
        Tree tree = new Tree();
        TreeNode root = tree.buildTree(list);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
//        tree.printPreTree(node1);
//        System.out.println("");
//        tree.printTree(node1);
//        System.out.println("");
        tree.printTree(node1);
    }


}