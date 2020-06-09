package jianzhioffer;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
      8
    /  \
   6   10
  / \  / \
 5  7 9 11
 镜像二叉树
      8
    /  \
  10   6
 / \  / \
 11 9 7  5
 */
public class Mirror {
    public static void Mirror(TreeNode root){

        if (root == null) {return;}

        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;

        Mirror(root.left);

        Mirror(root.right);
    }





    private static TreeNode createTree(){


        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(10);
        root.left = left;
        root.right = right;

        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        root.left.left = ll;
        root.left.right = lr;


        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);
        root.right.left = rl;
        root.right.right = rr;

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createTree();

        Mirror(treeNode);

        treeDepth(treeNode);
    }


    public static int treeDepth(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null){ return 0;}

        queue.push(root);

        int depth = 0, count = 0, nextCount = 1;
        while (queue.size()!=0){
            // remove
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
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
}
