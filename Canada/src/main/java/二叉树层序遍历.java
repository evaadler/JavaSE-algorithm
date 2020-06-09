import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树层序遍历 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            ArrayList<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);

                if (head.left != null)
                    queue.offer(head.left);

                if (head.right != null)
                    queue.offer(head.right);
            }

            list.add(level);
        }



        return list;
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }


}
