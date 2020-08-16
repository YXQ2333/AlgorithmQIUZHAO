package geek.fifthweek.work;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 433. 最小基因变化 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @author yxq
 * @date 2020/8/16 9:27
 */
public class Ex433 {
    // 双向bfs
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        HashSet<String> positive = new HashSet<String>(){{add(start);}};
        HashSet<String> negative = new HashSet<String>(){{add(end);}};
        HashSet<String> tempNewSet = new HashSet<>();
        int step = 0;
        while (positive.size() > 0 && negative.size() > 0) {
            step++;
            // 每次判断正向是否比负向的元素更多。我们选择元素更小的那个继续更新。
            if (positive.size() > negative.size()) {
                HashSet<String> temp = new HashSet<>(positive);
                positive = negative;
                negative = temp;
            }

            // 遍历每个正向的元素。
            for (String item : positive) {
                String str;
                char[] tempStringChars = item.toCharArray();
                for (int i = tempStringChars.length - 1; i >= 0; --i) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newString = new String(tempStringChars);
                        if (negative.contains(newString)) {
                            return step;
                        } else if (set.contains(newString)) {
                            set.remove(newString);
                            tempNewSet.add(newString);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
            positive = new HashSet<>(tempNewSet);
            tempNewSet.clear();
        }
        return -1;
    }
}
