package geek.fifthweek.work;

/**
 * @author yxq
 * @date 2020/8/16 9:28
 */
public class Ex190 {
    // 求模取和
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }

    // 按位翻转
    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            // res += (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            // res |= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }
}
