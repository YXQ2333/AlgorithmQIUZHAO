package geek.fifthweek.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxq
 * @date 2020/8/16 9:27
 */
public class Ex22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs("", n, n, ans);
        return ans;
    }

    /**
     * @param curStr 当前的字符串
     * @param left   左括号剩余个数
     * @param right  右括号剩余个数
     * @param ans    结果
     */
    private void dfs(String curStr, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(curStr);
            return;
        }
        // 如果左括号剩余的个数比右括号多，则肯定不正确
        if (left > right)
            return;
        if (left > 0)
            dfs(curStr + "(", left - 1, right, ans);
        if (right > 0)
            dfs(curStr + ")", left, right - 1, ans);
    }

    public List<String> generateParenthesis2(int n) {
        if (n == 0)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs2("", n, 0, 0, ans);
        return ans;
    }

    /**
     * @param curStr 当前字符串
     * @param n 括号的个数
     * @param left   左括号的使用个数
     * @param right  右括号的使用个数
     * @param ans    结果
     */
    private void dfs2(String curStr, int n, int left, int right, List<String> ans) {
        if (left == n && right == n) {
            ans.add(curStr);
            return;
        }
        if (left < right)
            return;
        if (left < n)
            dfs2(curStr+"(",n,left+1,right,ans);
        if (right < n)
            dfs2(curStr + ")",n,left,right + 1,ans);
    }
}
