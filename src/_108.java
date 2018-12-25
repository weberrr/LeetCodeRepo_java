import Utils.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @date 2018/12/25
 */

public class _108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBST(nums, l, mid - 1);
            node.right = buildBST(nums, mid + 1, r);
            return node;
        }
        else if (l == r) return new TreeNode(nums[l]);
        else return null;
    }

}
