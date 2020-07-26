package geek.secondweek.work;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合 https://leetcode-cn.com/problems/combinations/
 *
 * @author yxq
 * @date 2020/7/20 12:47
 */
public class Ex77 {
    // 使用栈实现
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n < 1 || k < 1)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayDeque<>(),1,n,k);
        return ans;
    }

    // 递归
    private void backtrack(List<List<Integer>> ans, ArrayDeque<Integer> path, int start, int n, int k) {
        // 如果k为0，证明可以用的数的个数已经用完
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            path.push(i);
            backtrack(ans,path,i+1,n,k-1);
            // 回溯
            path.pop();
        }
    }

    // 使用队列实现
    public List<List<Integer>> combine2(int n, int k) {
        if (n < k || n < 1 || k < 1)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<Integer>(),1,n,k);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> path, int start, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            path.add(i);
            backtrack(ans,path,i+1,n,k-1);
            path.remove(path.size() - 1);
        }
    }

}
