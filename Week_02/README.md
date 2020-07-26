# 学习笔记

## 递归
1. 要点
    1. 抵制人肉递归
    2. 找最近重复性
    3. 数学归纳思维
2. 递归模板
```java
void recursion(level,param1,...) {
    // 递归终止条件
    if (level > MAX_LEVEL) {
        // 处理结果
        processResult;
        return;
    }

    // 中间处理
    process(level,data,...);

    // 递归
    process(level + 1,p1,..);

    // 后续处理

}
```

## BFS和DFS
### 模板
1. DFS模板
```java
void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```
2. BFS模板
```java
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```

### 图中的模板
1. BFS
```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```
2. DFS
```java
Set<Node> visited;

void dfs(node) {
    if (visited.contains(node)) {
        return;
    }
    visited.add(node);
    process(...);
    for (child : node.children) {
        if (!visited.contains(child))
            dfs(child);
    }
}
```