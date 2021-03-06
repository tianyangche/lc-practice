package com.tianyangche;

public class RecoverBinarySearchTree {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    /**
     *
     Two elements of a binary search tree (BST) are swapped by mistake.

     Recover the tree without changing its structure.

     Example 1:

     Input: [1,3,null,null,2]

     1
     /
     3
     \
     2

     Output: [3,1,null,null,2]

     3
     /
     1
     \
     2
     Example 2:

     Input: [3,1,4,null,null,2]

     3
     / \
     1   4
     /
     2

     Output: [2,1,4,null,null,3]

     2
     / \
     1   4
     /
     3
     Follow up:

     A solution using O(n) space is pretty straight forward.
     Could you devise a constant space solution?
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        if (first != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            if (prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
        }
        prev = root;
        dfs(root.right);
    }
}
