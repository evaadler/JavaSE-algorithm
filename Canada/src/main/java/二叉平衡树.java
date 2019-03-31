public class 二叉平衡树 {

    public static void main(String[] args) {

    }

    public boolean isBalance(TreeNode root){

      if (root == null)
          return true;

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
        && isBalance(root.left) && isBalance(root.right);
    }

    public int getHeight(TreeNode root){
        if (root == null)
            return 0;


        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }
}
