package geek.thirdweek.work;

/**
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex33 {
    // 根据target和nums[0]判断答案是在左半段还是右半段
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // 先根据nums[0]和target判断在左半段还是右半段
            if (target >= nums[0]) {
                // target在左半段时，若mid在右半段，则将nums[mid]改为inf
                if (nums[mid] < nums[0])
                    nums[mid] = Integer.MAX_VALUE;
            } else {
                // target在右半段时，若mid在左半段，则将nums[mid]改为-inf
                if (nums[mid] >= nums[0])
                    nums[mid] = Integer.MIN_VALUE;
            }
            //
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 根据nums[mid]和nums[left]的关系，判断mid是在左半段还是右半段，
    // 再判断target是在mid左边还是右边，从而调整left，right
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // 先根据nums[mid]与nums[left]的关系判断mid是在左端还是右端
            if (nums[mid] >= nums[left]) {
                // 再判断target是在mid的左边还是右边，从而调整left,right
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
