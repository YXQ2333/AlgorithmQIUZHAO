package geek.thirdweek.work;

/**
 * 153. 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex153 {
    // 旋转后的数组，应该有一部分单调递增，另外一部分也是递增的，但是整体不一定递增
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right])
                // 符合条件证明[left,right]递增，则nuns[left]为最小值
                return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
