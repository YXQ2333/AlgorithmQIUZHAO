package geek.firstweek.July_9;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 https://leetcode-cn.com/problems/two-sum/
 * 20/9/10 √
 *
 * @author yxq
 * @date 2020/7/9 19:53
 */
public class Ex1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //存储已经遍历过的nums[i] 和 i

        for (int i = 0; i < nums.length; i++) {
            int currVal = target - nums[i]; //计算target 与 nums[i]的差值
            if (map.containsKey(currVal))   //如果map已经存在差值，则找到
                return new int[]{map.get(currVal), i};
            map.put(nums[i], i);
        }

        return null;
    }
}
