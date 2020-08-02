package geek.thirdweek.work;

/**
 * 74. 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex74 {
    // 可以想象成将二维数组展开为一维，就可以使用二分搜索了
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1)
            return false;
        int row = matrix.length, column = matrix[0].length;
        int left = 0, right = row * column - 1;
        int mid = 0, midVal = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midVal = matrix[mid/column][mid%column];
            if (target == midVal) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
