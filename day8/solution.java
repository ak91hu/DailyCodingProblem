public class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }

    private boolean isUnival(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean leftIsUnival = isUnival(node.left);
        boolean rightIsUnival = isUnival(node.right);

        if (!leftIsUnival || !rightIsUnival) {
            return false;
        }

        if (node.left != null && node.left.val != node.val) {
            return false;
        }

        if (node.right != null && node.right.val != node.val) {
            return false;
        }

        count++;
        return true;
    }
}
