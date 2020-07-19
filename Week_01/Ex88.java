package geek.firstweek.July_10;

/**
 * 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * 20/7/12 √
 * 2020年7月13日 ×
 *
 * @author yxq
 * @date 2020/7/10 10:55
 */
public class Ex88 {
    //分别使用两个指针从nums1 和 nums2 往前遍历，比较值的大小
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int index = nums1.length - 1;   //指向较大元素当前应该放的位置
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        // 如果 n>=0 那就证明 nums2 中还有较小的元素未放到 nums1 中
        // 如果 是 n>=0 ，那就是nums1中还有较小的元素，但是本身就在nums1中，不需要移动
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
