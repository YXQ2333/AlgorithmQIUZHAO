package geek.thirdweek.work;

/**
 * 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author yxq
 * @date 2020/7/30 19:25
 */
public class Ex122 {
    // greedy
    // 如果数据为[1,5,7]，最大利润为6，使用贪心算法时，可以理解为
    // 先是1买入，再是5卖出；然后再5买入，7卖出
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0)
                profit += tmp;
        }
        return profit;
    }
}
