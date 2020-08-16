package geek.fifthweek.work;

/**
 * 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/
 *
 * @author yxq
 * @date 2020/8/16 9:28
 */
public class Ex231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
