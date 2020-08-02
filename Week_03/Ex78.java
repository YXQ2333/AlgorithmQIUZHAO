package geek.thirdweek.work;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 78. 子集 https://leetcode-cn.com/problems/subsets/
 * @author yxq
 * @date 2020/7/30 19:26
 */
public class Ex78 {
    // 回溯
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(0,nums, new ArrayList<>(),ans);
        return ans;
    }

    private void backtracking(int start, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i + 1,nums,path,ans);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
