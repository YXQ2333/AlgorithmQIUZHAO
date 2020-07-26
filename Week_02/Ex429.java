package geek.secondweek.work;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 2020年7月21日 √
 *
 * @author yxq
 * @date 2020/7/20 21:47
 */
public class Ex429 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

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
}
