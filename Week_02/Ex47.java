package geek.secondweek.work;

import java.util.*;

/**
 * 47. 全排列 II https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author yxq
 * @date 2020/7/20 12:48
 */
public class Ex47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 1)
            return ans;
        // 排序，排序是剪枝的前提
        Arrays.sort(nums);

        // 是否使用过
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, used, path, ans);

        return ans;
    }

    private void dfs(int[] nums, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> ans) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, depth + 1, used, path, ans);
            used[i] = false;
            path.removeLast();
        }
    }
}
