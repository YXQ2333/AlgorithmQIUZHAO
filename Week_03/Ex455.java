package geek.thirdweek.work;

import java.util.Arrays;

/**
 * 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex455 {
    // greedy
    public int findContentChildren(int[] g, int[] s) {
        if (g.length < 1 || s.length < 1)
            return 0;
        // 升序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int ans = 0;
        while (i != g.length && j != s.length) {
            // 如果能够给饼干
            if (g[i] <= s[j]) {
                ans++;
                i++;
            }
            // 无论是否能给，饼干索引应该后移
            j++;
        }
        return ans;
    }
}
