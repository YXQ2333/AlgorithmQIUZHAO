package geek.firstweek.july_14;

import org.junit.Test;

/**
 * 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 *
 * @author yxq
 * @date 2020/7/14 14:04
 */
public class Ex42 {
    // 方法一 求列和 Time:O(n^2) Space:O(1)
    // 从当前位置，往左右找，如果两边的有比当前位置高的
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;

        for (int i = 1; i < len - 1; i++) {
            int leftMax = 0;
            // 往左找到最高的地方
            for (int j = i; j >= 0; j--) {
                if (height[j] > leftMax)
                    leftMax = height[j];
            }
            // 往右找到最高的地方
            int rightMax = 0;
            for (int j = i; j < len; j++) {
                if (height[j] > rightMax)
                    rightMax = height[j];
            }
            // 取两边最大值中的较小的值
            int min = Math.min(leftMax, rightMax);
            // 如果两边都存在高度大于当前位置，则可以接到雨水
            if (min > height[i])
                ans += min - height[i];
        }
        return ans;
    }


    // 方法二：动态规划 在方法一的基础上修改 O(n) O(n)
    public int trap2(int[] height) {
        int len = height.length;
        int ans = 0;
        // 记录 i 位置左边的最大值
        int[] leftMax = new int[len];
        // 记录 i 位置右边的最大值
        int[] rightMax = new int[len];
        for (int i = 1; i < len; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        for (int i = len - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i - 1], height[i + 1]);
        // 递归取两边最大值中的较小值，如果该值大于当前高度，则证明可以接到雨水
        // 且雨水的量为 min - height[i]
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i])
                ans += min - height[i];
        }
        return ans;
    }

    // 方法3 双指针 Time:O(n) Space:O(1)
    // https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/327718/ 评论
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                ans += Math.max(0,leftMax - height[left]);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            } else {
                ans += Math.max(0,rightMax - height[right]  );
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] height = {2, 0, 2};
        int ans = trap2(height);
        System.out.println(ans);
    }
}
