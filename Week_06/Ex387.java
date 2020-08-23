package geek.sixth.work;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author yxq
 * @date 2020/8/23 20:33
 */
public class Ex387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
