package geek.firstweek.july_13;

import java.util.*;

/**
 * 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 * 2020年7月14日 ×
 *
 * @author yxq
 * @date 2020/7/13 15:35
 */
public class Ex49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new LinkedList<>();
        Map<String, List> ans = new HashMap<>();
        int[] counter;  //计算字符串中每种字符的个数
        for (String str : strs) {
            counter = new int[26];
            // 统计所有字符出现的次数
            for (char c : str.toCharArray())
                counter[c - 'a']++;
            // 将出现的次数转换成 "#1#0#12...#3" 格式
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counter.length; i++) {
                sb.append('#');
                sb.append(counter[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new LinkedList());
            ans.get(key).add(str);
        }
        return new LinkedList(ans.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
