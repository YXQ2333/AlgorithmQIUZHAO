package geek.sixth.work;

/**
 * 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * @author yxq
 * @date 2020/8/23 20:32
 */
public class Ex242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--counter[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
