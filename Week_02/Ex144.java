package geek.secondweek.work;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 2020年7月21日 √
 *
 * @author yxq
 * @date 2020/7/20 13:44
 */
public class Ex144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    List<Integer> ans;

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new LinkedList<>();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    // 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                // 前序遍历
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = stack.pop();
            curr = tmp.right;
        }
        return ans;
    }

}
