package geek.thirdweek.work;

import java.util.*;

/**
 * 51. N皇后 https://leetcode-cn.com/problems/n-queens/
 *
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex51 {
    private Set<Integer> columnSet = new HashSet<>();   // 列
    private Set<Integer> masterSet = new HashSet<>();   // 45°对角线
    private Set<Integer> slaveSet = new HashSet<>();    // 135°对角线

    public List<List<String>> solveNQueens(int n) {
        if (n < 1)
            return new ArrayList<>();
        List<List<String>> ans = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(charToString(board));
            return;
        }
        for (int column = 0; column < board[row].length; column++) {
            if (!isValid(board, row, column))
                continue;
            updateSet(board, row, column);
            backtrack(board, row + 1, ans);
            updateSet(board, row, column);
        }
    }

    private void updateSet(char[][] board, int row, int column) {
        if (columnSet.contains(column)) {
            board[row][column] = '.';
            columnSet.remove(column);
            masterSet.remove(row - column);
            slaveSet.remove(row + column);
        } else {
            board[row][column] = 'Q';
            columnSet.add(column);
            masterSet.add(row - column);
            slaveSet.add(row + column);
        }
    }

    // 判断该位置是否有效
    private boolean isValid(char[][] board, int row, int column) {
        return !columnSet.contains(column)
                && !masterSet.contains(row - column)
                && !slaveSet.contains(row + column);
    }

    private List<String> charToString(char[][] board) {
        List<String> ans = new LinkedList<>();
        for (char[] chars : board) {
            ans.add(String.valueOf(chars));
        }
        return ans;
    }
}
