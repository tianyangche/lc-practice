package com.tianyangche;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     * Example:
     *
     * Input: 3
     * Output:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res.addAll(dfs(1, n));
        return res;
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftRes = dfs(left, i - 1);
            List<TreeNode> rightRes = dfs(i + 1, right);
            for (TreeNode l : leftRes) {
                for (TreeNode r : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
