package geek.thirdweek.work;

/**
 * 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 * @author yxq
 * @date 2020/7/30 19:28
 */
public class Ex45 {
    // greedy：方向查找出发位置
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    // greedy：正向查找可到达的最远位置
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
