package geek.thirdweek.work;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        // 记录障碍物位置，横纵坐标间用 # 隔开
        for (int[] obs : obstacles) {
            set.add(obs[0] + "#" + obs[1]);
        }
        // 所能控制的方向
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {  // 向右转90度
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {   // 向左转90度
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {    // 前进
                // 当步数没有用尽，且前方没有障碍物时，一直前进
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + "#" + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
