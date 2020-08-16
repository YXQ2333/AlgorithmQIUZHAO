package geek.fifthweek.work;

/**
 * @author yxq
 * @date 2020/8/16 9:27
 */
public class Ex36 {
    public boolean isValidSudoku(char[][] board) {
        // 设置成为 10 是为了照顾到数字 9 的情况（下标 9 数字需要到 10）
        // 第 1 维表示行的下标
        boolean[][] row = new boolean[9][10];
        // 第 1 维表示列的下标
        boolean[][] col = new boolean[9][10];
        // 第 1 维表示 board 的下标
        boolean[][] box = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 只验证数字，因此 . 跳过
                if (board[i][j] == '.') {
                    continue;
                }

                // 提取出数字
                int num = board[i][j] - '0';
                // 重点：计算在第几格
                int boardIndex =  (i / 3) * 3 + j / 3;

                // 如果发现冲突，直接返回 false
                if (row[i][num] || col[j][num] || box[boardIndex][num]) {
                    return false;
                }

                // 然后占住位置
                row[i][num] = true;
                col[j][num] = true;
                box[boardIndex][num] = true;
            }
        }
        return true;
    }
}
