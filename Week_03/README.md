# 学习心得
## 分治
1. 模板
```java
void partition(problem,params) {
    // 结束条件
    if (符合结束条件) {
        process_result;
        return;
    }
    
    // 处理当前问题
    subproblems = split_problem(problem,data);
    subresult1 = partition(subproblem[0],p1);
    subresult2 = partition(subproblem[1],p2);

    // 合并
    result = process_result(subresult1,subresult2);
}
```

## 回溯
1. 模板
```java
void backtrack(路径,选择列表,ans) {
    if (满足结束条件) {
        ans.add(路径);
        return;
    }

    for (选择 : 选择列表) {
        // 做选择
        将该选择从选择列表移除
        路径.add(选择)

        backtrack(路径, 选择列表)
        #// 撤销选择
        路径.remove(选择)
        将该选择再加入选择列表
    }
}
```

## DFS
1. 模板
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new Arraylist<>();
    if (root == null) 
        return ans;
    travel(root,0,ans);
    return ans;
}
private void travel(TreeNode root,int level,List<List<Integer>> ans) {
    if (ans.size() == level) {
        ans.add(new ArrayList<>());
    }
    ans.get(level).add(root.val);
    if (root.left != null) {
        travel(root.left,level + 1,ans);
    }
    if (root.right != null) {
        travel(root.right,level + 1,ans);
    }
}
```

## BFS
1. 模板
```java
public List<List<Integer>> levelOrder(Node root) {
    if (root == null)
        return new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
        List<Integer> level = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node curr = queue.poll();
            level.add(curr.val);
            // 将当前节点的所有子结点加入到队列中
            queue.addAll(curr.children);
        }
        ans.add(level);
    }

    return ans;
}
```

## 二分查找
1. 可以使用二分查找的情况
    1. 目标函数单调递增（递减）
    2. 存在上下界
    3. 能够通过索引访问
2. 模板
```java
int binarySearch(int[] arr) {
    int left = arr[0], right = arr.length - 1;
    while (left <= right) {
        mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```

## 使用二分查找，寻找数组中无序的地方
```java
// 题目与leetcode 153题相同，旋转后最小的数字的位置，就是无序的位置
// 旋转后的数组，应该有一部分单调递增，另外一部分也是递增的，但是整体不一定递增
public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        if (nums[left] < nums[right])
            // 符合条件证明[left,right]递增，则nuns[left]为最小值
            return nums[left];
        int mid = left + (right - left) / 2;
        if (nums[mid] >= nums[left]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return nums[left];
}
```