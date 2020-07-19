package geek.firstweek.July_10;

/**
 * 加一 https://leetcode-cn.com/problems/plus-one/
 * 20/7/12 √
 *
 * @author yxq
 * @date 2020/7/10 11:00
 */
public class Ex66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        //如果各个数字都是9
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
