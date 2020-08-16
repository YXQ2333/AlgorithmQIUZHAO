# 学习心得

## 双向BFS
1. 模板
```java
public int binBfs(Node start, Node target) {
    Set<Node> q1 = new HashSet<>();
    Set<Node> q2 = new HashSet<>();
    Set<Node> visited = new HashSet<>();
    q1.add(start);
    q2.add(target);
    visited.add(start);
    int step = 0;
    while (!q1.isEmpty() && !q2.isEmpty()) {
        // 总是从较小的一端处理
        if (q1.size() > q2.size()) {
            Set<Node> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
        // 用于存储下一层的节点
        Set<Node> nextLevel = new HashSet<>();
        for (Node cur : q1) {
            // 两端相交
            if (q2.contains(cur)) {
                return  step;
            }
            if (cur.children == null) {
                continue;
            }
            for (Node child : cur.children) {
                if (!visited.contains(child)) {
                    nextLevel.add(child);
                }
            }
        }
        step++;
        // 覆盖
        q1 = nextLevel;
        visited.addAll(nextLevel);
    }
    return -1;
}
```

## 二叉搜索树
* 一棵空树也是二叉查找树。对于二叉搜索树中的每一个节点，其左子树上的每个节点的值都小于这个节点的值，而右子树上的每个节点的值都大于这个节点的值

## AVL树
* 平衡因子：左右子树的高度差，值可为-1,0,1。AVL是一棵严格平衡二叉搜索树，通过旋转操作(左旋、右旋、左右旋、右左旋)来维持树的平衡。

## 红黑树
* 红黑树是一棵近似平衡二叉搜索树，能够确保任何一个结点的左右子树的高度差小于两倍。

* 红黑树的特征：
    1. 每一个节点非红即黑
    2. 根节点是黑色
    3. 叶子节点是黑色且为空
    4. 相邻两个节点不能同时为红
    5. 从任意一个结点到可达叶子节点的路径包含的黑色节点数目相同

* 红黑树与AVL树的性能比较：
    1. AVL树有更好的查询性能。
    2. 红黑树提供了更好的删除和添加操作，因为AVL要维持严格的平衡，需要调整的次数比较多。
    3. AVL树需要的额外的空间比较多，需要存储平衡因子在每一个节点中。