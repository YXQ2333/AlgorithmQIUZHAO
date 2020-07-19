package geek.firstweek.July_10;

/**
 * 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 20/7/12 √
 * 2020年7月13日 √
 *
 * @author yxq
 * @date 2020/7/10 9:48
 */
public class Ex26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
