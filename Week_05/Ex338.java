package geek.fifthweek.work;

/**
 * @author yxq
 * @date 2020/8/16 9:27
 */
public class Ex338 {
    // 动态规划 + 最高有效位
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    // 动态规划 + 最低有效位
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    // 动态规划 + 最后设置位
    public class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i & (i - 1)] + 1;
            return ans;
        }
    }
}
