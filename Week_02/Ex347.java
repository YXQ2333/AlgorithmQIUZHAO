package geek.secondweek.work;

import java.util.*;

/**
 * 347. 前 K 个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author yxq
 * @date 2020/7/21 19:24
 */
public class Ex347 {
    // 使用堆：Time:O(nlogk)（k为前参数k的值） Space：O(n)
    // 使用 Map 存储各个数字出现的次数
    // 然后使用大顶堆求前 k 个数
    // 或者使用小顶堆，当其中个数大于K时，就把最小的数给去掉
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k < 1)
            return new int[0];
        // key为出现的数字，value为出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (map.get(n1) - map.get(n2)));
        int[] ans = new int[k]; // 结果
        int idx = 0;    // 结果中位置的索引
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 若小顶堆中元素个数大于k，则将最小的元素去除，剩下的就是较大的元素
        for (Integer integer : map.keySet()) {
            heap.add(integer);
            if (heap.size() > k)
                // 去掉最小的元素
                heap.poll();
        }
        while (!heap.isEmpty()) {
            ans[idx++] = heap.poll();
        }

        return ans;
    }

    // 使用桶排序：Time:O(n) Space：O(n)
    // 先统计各个数字出现的个数，然后使用桶排序，从后往前遍历
    public int[] topKFrequent2(int[] nums, int k) {
        // key为出现的数字，value为出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 桶排序，将频率作为下标，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            // 获取出现的次数作为下标
            Integer i = map.get(key);
            if (list[i] == null)
                list[i] = new ArrayList<>();
            list[i].add(key);
        }

        int[] ans = new int[k]; // 结果
        int idx = 0;    // 结果中位置的索引
        // 倒序获取出现次数从大到小的数字
        for (int i = list.length - 1; i >= 0 && idx < k; i--){
            if (list[i] != null) {
                for (Integer integer : list[i]) {
                    ans[idx++] = integer;
                }
            }
        }

        return ans;
    }
}
