package geek.firstweek.July_9;

/**
 * 移动0 https://leetcode-cn.com/problems/move-zeroes/
 * 20/7/10 √
 *
 * @author yxq
 * @date 2020/7/9 19:31
 */
public class Ex283 {
    public void moveZeroes(int[] nums) {
        int left = 0;  //左边的指针

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) { //如果右指针的数不为0
                nums[left] = nums[right];   //则应该将值赋值给左边指针的值
                if (left != right) {    //如果两个指针不是指向同一个位置，则应该将右边的值置为0
                    nums[right] = 0;
                }
                left++;
            }
        }
    }
}
