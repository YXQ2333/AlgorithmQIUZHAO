package geek.thirdweek.work;

/**
 * 529. 扫雷游戏 https://leetcode-cn.com/problems/minesweeper/
 * @author yxq
 * @date 2020/7/30 19:26
 */
public class Ex529 {
    //八个方向
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int column = board[0].length;
        int m = click[0];
        int n = click[1];
        //如果点击的是未挖出的雷或者是已挖出的雷
        if (board[m][n] == 'M' || board[m][n] == 'X') {
            board[m][n] = 'X';
            return board;
        }
        //点击位置周围雷的数量
        int num = 0;
        for (int[] dir : dirs) {
            int newM = dir[0] + m;
            int newN = dir[1] + n;
            if (newM >= 0 && newM < row && newN >= 0 && newN < column && board[newM][newN] == 'M'){
                num++;
            }
        }
        //如果周围的雷的数量大于0，则将该位置的值修改为周围雷的数量
        if (num > 0) {
            board[m][n] = (char) (num + '0');
            return board;
        }
        //如果周围没有雷，则board[m][n]为B，需要向八个方向进行递归
        board[m][n] = 'B';
        for (int[] dir : dirs) {
            int newM = dir[0] + m;
            int newN = dir[1] + n;
            //如果在范围内，并且新的位置为为挖出的格子
            if (newM >= 0 && newM < row && newN >= 0 && newN < column && board[newM][newN] == 'E'){
                updateBoard(board,new int[]{newM,newN});
            }
        }
        return board;
    }
}
