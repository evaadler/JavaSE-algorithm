package jianzhioffer;


import java.util.LinkedList;

/**
 * Created by fifi on 2017/6/13.
 */
public class TreeAlgorithm {

    /**
     * 非递归，层序遍历
     * count : 已经遍历的结点数
     * nextCount: 下层的结点总数
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null){ return 0;}

        queue.push(root);

        int depth = 0, count = 0, nextCount = 1;
        while (queue.size()!=0){
            // remove
            TreeNode top = queue.poll();
            count++;
            if (top.left !=null) {
                queue.push(top.left);
            }
            if (top.right != null) {
                queue.push(top.right);
            }
            if (count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;

    }


    /**
     * 递归遍历
     * @param root
     * @return
     */
    public int treeDepthReverse(TreeNode root){
        if (root == null) {
            return 0;
        }
        System.out.print(root.val);
        int left = treeDepthReverse(root.left);
        int right = treeDepthReverse(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(4);
        TreeNode rLeft = new TreeNode(3);
        TreeNode rRight = new TreeNode(7);
        right.left = rLeft;
        right.right = rRight;

        root.right = right;

        new TreeAlgorithm().treeDepthReverse(root);
    }

}
