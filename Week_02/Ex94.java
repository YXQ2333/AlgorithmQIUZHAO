package geek.secondweek.work;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 * 2020年7月21日 √
 *
 * @author yxq
 * @date 2020/7/20 12:52
 */
public class Ex94 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new LinkedList<>();

        dfs(root);

        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = stack.pop();
            // 中序遍历
            ans.add(curr.val);
            curr = tmp.right;
        }
        return ans;
    }
}
