package geek.thirdweek.work;

/**
 * 55. 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex55 {
    // greedy：从前往后计算能达到的最远距离
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 目前所能达到的最远距离
        int mostRight = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= mostRight) {
                mostRight = Math.max(mostRight, i + nums[i]);
                if (mostRight >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
