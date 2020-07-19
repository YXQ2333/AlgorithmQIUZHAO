package geek.firstweek.July_10;

/**
 * 旋转数组 https://leetcode-cn.com/problems/rotate-array
 *
 * @author yxq
 * @date 2020/7/10 10:28
 */
public class Ex189 {
    //先全部反转，再反转前k个，和后 n - k 个
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //遍历，然后将 nums[start] 向前挪 k 个位置，直到移动的次数为数组的长度
    public void rotate2(int[] nums, int k) {
        if (nums == null)
            return;
        int len = nums.length;
        k %= len;   //取模，防止k > len，进行不必要的操作
        //记录移动的次数，一共需要移动 len 次
        int count = 0;
        for (int start = 0; count < len; start++) {
            // 记录当前位置
            int currIdx = start;
            // 记录当前位置的值，作为 currIdx + k 位置的值
            int currVal = nums[start];
            // currIdx 一直往前移动 k 个位置，直到又回到了起点 start
            // 并且把当前位置的值赋给 currIdx + k 位置
            do {
                int nextIdx = (currIdx + k) % len;
                int nextVal = nums[nextIdx];
                nums[nextIdx] = currVal;
                currIdx = nextIdx;
                currVal = nextVal;
                count++;
            } while (start != currIdx);
        }
    }
}
