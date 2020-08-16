package geek.fifthweek.work;

/**
 * 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
 * @author yxq
 * @date 2020/8/16 9:28
 */
public class Ex191 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
