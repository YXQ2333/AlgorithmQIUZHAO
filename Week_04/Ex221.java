package geek.fourthweek.work;

/**
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 *
 * @author yxq
 * @date 2020/8/7 15:27
 */
public class Ex221 {
    // dp 无空间优化
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    // dp 空间优化
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            int northwest = 0;
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}
