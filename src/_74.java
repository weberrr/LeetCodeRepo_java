/**
 * 搜索二维矩阵
 *
 * @date 2018/12/10
 */
public class _74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int[] array = new int[matrix.length * matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[k++] = matrix[i][j];
            }
        }
        return binarySearch(array, 0, array.length - 1, target);
    }

    public boolean binarySearch(int[] array, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                return binarySearch(array, mid + 1, right, target);
            } else {
                return binarySearch(array, left, mid - 1, target);
            }
        }
        return false;
    }
}
