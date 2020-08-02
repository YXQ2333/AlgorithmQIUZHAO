package geek.thirdweek.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
 *
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex169 {
    // 哈希表
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > nums.length / 2)
                return nums[i];
        }
        return -1;
    }

    // 排序
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 分治：若a是众数，那么将数组分为左右两部分，在其中一部分中一定是众数
    public int majorityElement3(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private int partition(int[] nums, int lo, int hi) {
        // 只有一个元素的时候，该元素就是众数
        if (lo == hi)
            return nums[lo];
        // 递归左右两边
        int mid = lo + (hi - lo) / 2;
        int left = partition(nums,lo,mid );
        int right = partition(nums,mid + 1,hi);
        // 如果两边的众数相同，则证明该数就是该部分的众数
        if (left == right)
            return left;
        // 如果两边众数不一样，则计算两边众数的个数，并且返回出现此处较多的众数
        int leftCount = countInRange(nums,left,lo,hi);
        int rightCount = countInRange(nums,right,lo,hi);

        return leftCount > rightCount?left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i ++) {
            if (nums[i] == num)
                count++;
        }
        return count;
    }

    // Boyer-Moore 投票算法
    public int majorityElement4(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
