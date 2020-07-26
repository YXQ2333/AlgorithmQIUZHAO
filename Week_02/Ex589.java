package geek.secondweek.work;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 2020年7月21日 ×
 *
 * @author yxq
 * @date 2020/7/20 20:38
 */
public class Ex589 {
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

    public List<Integer> preorder(Node root) {
        if (root == null)
            return new LinkedList<>();

        List<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            ans.add(curr.val);
            List<Node> children = curr.children;
            // 从右往左将子结点加入到栈中，这样子取出来的时候就是从左往右的顺序
            for (int i = children.size() - 1; i >= 0; i--) {
                if (children.get(i) != null)
                    stack.push(children.get(i));
            }
        }

        return ans;
    }
}
