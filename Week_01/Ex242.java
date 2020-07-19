package geek.firstweek.july_13;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * 2020年7月14日 √
 *
 * @author yxq
 * @date 2020/7/13 14:06
 */
public class Ex242 {
    public boolean isAnagram(String s, String t) {
        //一定要判断是否长度相等，否则 出现 s="ab",t="b"这种情况，会出错
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];

        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    //通用版本，字符串中不一定都是小写字母
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();   //存储s中的字符和对应个数
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            //如果有该字符，次数减一
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            //如果没有该字符或者该字符数量小于1，则直接返回false
            if (!map.containsKey(c) || map.get(c) < 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "anagram";
        String t = "nagaram";
        boolean b = isAnagram2(s, t);
        System.out.println(b);
    }
}
