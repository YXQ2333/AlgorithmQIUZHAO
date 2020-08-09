package geek.fourthweek.work;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 363. 矩形区域不超过 K 的最大数值和 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 * @author yxq
 * @date 2020/8/7 15:28
 */
public class Ex363 {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
