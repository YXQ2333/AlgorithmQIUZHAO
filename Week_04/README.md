# 学习心得
## 模板
```
// 初始化 base case
dp[0][0][...] = base;
// 状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)d
```

## dp的关键
1. 无后效性：一旦f(n)确定，我们就不关心f(n)是如何得到的，f(n)是如何得到的并不会影响之后的问题
2. 具有最优子结构