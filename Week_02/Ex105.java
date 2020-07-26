package geek.secondweek.work;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author yxq
 * @date 2020/7/20 12:47
 */
public class Ex105 {
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
    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        if (left > right)
            return null;
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int mid = indexMap.get(rootVal);
        preIndex++;
        root.left = dfs(left, mid - 1);
        root.right = dfs(mid + 1, right);
        return root;
    }
}
