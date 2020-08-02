package geek.thirdweek.work;

import java.util.LinkedList;
import java.util.Queue;

/**200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 * @author yxq
 * @date 2020/7/30 19:26
 */
public class Ex200 {
    // bfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int column = grid[0].length;
        int islandNum = 0;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    islandNum++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int r = node[0];
                        int c = node[1];
                        for (int[] move : moves) {
                            int r2 = r + move[0];
                            int c2 = c + move[1];
                            if (inArea(grid, r2, c2) && grid[r2][c2] == '1') {
                                grid[r2][c2] = '2';
                                queue.add(new int[]{r2, c2});
                            }
                        }
                    }
                }
            }
        }
        return islandNum;
    }

    // dfs
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
               if (grid[i][j] == '1') {
                   dfs(grid, i, j);
                   count++;
               }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断是否越界
    private boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}