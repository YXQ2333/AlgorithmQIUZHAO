package geek.fourthweek.work;

/**
 * 32. 最长有效括号 https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author yxq
 * @date 2020/8/7 15:27
 */
public class Ex32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        // 到i时最大长度
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
