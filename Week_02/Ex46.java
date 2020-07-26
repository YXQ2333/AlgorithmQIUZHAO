package geek.secondweek.work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列 https://leetcode-cn.com/problems/permutations/
 *
 * @author yxq
 * @date 2020/7/20 12:48
 */
public class Ex46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 1)
            return ans;
        // 当前得到到情况
        Deque<Integer> path = new ArrayDeque<>();
        // 表示 nums[i] 是否已经使用
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, ans);
        return ans;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ans) {
        // 如果所用个数已经和数组长度相等，则证明已经结束
        if (depth == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i])
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, ans);
            // 回溯操作，做跟进入递归之前相反的操作
            path.removeLast();
            used[i] = false;
        }
    }
}
