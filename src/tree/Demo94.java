package tree;

import java.util.ArrayList;
import java.util.List;

public class Demo94 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while(node.left != null){
            node = node.left;
            if (node.left == null) res.add(node.val);
        }
        return res;
    }
}
