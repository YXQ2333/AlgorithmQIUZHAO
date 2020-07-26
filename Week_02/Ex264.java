package geek.secondweek.work;

/**
 * 264. 丑数 II https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @author yxq
 * @date 2020/7/20 12:46
 */
public class Ex264 {
    // dp
    public int nthUglyNumber(int n) {
        // ugly[i] 存放的是第i个丑数
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++idx2];
            if (factor3 == min)
                factor3 = 3 * ugly[++idx3];
            if (factor5 == min)
                factor5 = 5 * ugly[++idx5];
        }
        return ugly[n-1];
    }
}
