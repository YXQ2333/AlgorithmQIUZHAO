package geek.thirdweek.work;

/**
 * 860. 柠檬水找零 https://leetcode-cn.com/problems/lemonade-change/
 *
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex860 {
    public boolean lemonadeChange(int[] bills) {
        // 初始有0张5元和10元
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {    // 付5元
                five++;
            } else if (bill == 10) {// 付10元
                five--;
                ten++;
            } else if (ten > 0) {   // 付20元，且手中有10元
                ten--;
                five--;
            } else {    // 付20元，且手中没有10元
                five -= 3;
            }
            if (five < 0)
                return false;
        }
        return true;
    }
}
