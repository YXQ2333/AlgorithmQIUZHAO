package geek.secondweek.work;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 2020年7月21日 ×
 *
 * @author yxq
 * @date 2020/7/20 20:26
 */
public class Ex590 {
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

    // 只要是后续遍历，
    // 就是把节点加到队尾，并且在取出节点的时候也是从队尾取
    // 结果加到队头
    public List<Integer> postorder(Node root) {
        if (root == null)
            return new LinkedList<>();

        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> ans = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            ans.addFirst(curr.val);
            for (Node child : curr.children) {
                if (child != null)
                    // add：添加到队尾
                    // push：添加到队头
                    stack.push(child);
            }
        }
        return ans;
    }
}
