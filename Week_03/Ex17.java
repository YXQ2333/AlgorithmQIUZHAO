package geek.thirdweek.work;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author yxq
 * @date 2020/7/30 19:27
 */
public class Ex17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits == null || digits.length() < 1)
            return ans;
        backtrack("", digits, 0, ans);
        return ans;
    }

    private void backtrack(String path, String digits, int index, List<String> ans) {
        if (index == digits.length()) {
            ans.add(path);
            return;
        }
        String letters = KEYS[(digits.charAt(index) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            backtrack(path + letters.charAt(i), digits, index + 1, ans);
        }
    }
}