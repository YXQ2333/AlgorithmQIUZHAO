package geek.thirdweek.work;

import org.junit.Test;

/**
 * 50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 *
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex50 {
    // 快速幂 + 递归
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? partition(x, N) : (1.0 / partition(x, -N));
    }

    private double partition(double x, long n) {
//         System.out.println(n);
        if (n == 0)
            return 1.0;
        double y = partition(x, n / 2);
        return (n % 2) == 0 ? (y * y) : (y * y * x);
    }

    // 快速幂 + 迭代
    public double myPow2(double x, int n) {
        long N = n;
        return n >= 0 ? partition2(x,N) : 1.0 / (partition2(x,-N));
    }

    private double partition2(double x, long n) {
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }


    @Test
    public void test() {
        double pow = myPow2(2.0, 7);
        System.out.println(pow);
        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(-min);
    }
}
