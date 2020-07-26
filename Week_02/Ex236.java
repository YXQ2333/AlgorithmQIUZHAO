package geek.secondweek.work;

/**
 * @author yxq
 * @date 2020/7/20 12:47
 */
public class Ex236 {
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

    // dfs
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到或者已经到叶子节点
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 1. 说明root的左右子树中都不包含p,q，返回null
        if (left == null && right == null)
            return null;
        // 2. 当left为空，right不为空时，说明p,q都不在左子树中，返回right
        if (left == null)
            return right;
        // 3. 当right为空，left不为空时，说明p,q都不在右子树中，返回left
        if (right == null)
            return left;
        // 4. 左右子树均不为空，说明p,q分别就在root的左右两侧
        return root;
    }

}
