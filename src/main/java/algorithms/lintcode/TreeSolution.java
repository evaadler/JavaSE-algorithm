package algorithms.lintcode;

import jianzhioffer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fifi on 2017/7/12.
 */
public class TreeSolution {

    /*
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }

    }
    */


    List<List<Integer>> list = new ArrayList<>();
    /**
     * 思路：深搜
     * @param node
     * @param target
     * @return
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode node, int target){
        TreeNode root = node;
        int sum = 0;

        List<Integer> l = new ArrayList<>();

        if(node == null) return list;

        dfs(root, target, sum, list, l);

        //helper(root, target - root.val, list, l);
        return list;
    }

    private void helper(TreeNode root, int target, List<List<Integer>> nums,List<Integer> num){
        if (target == 0){
            nums.add(new ArrayList<>(num));
            return;
        }

        if (root.left != null){
            num.add(root.left.val);
            helper(root.left, target-root.left.val, nums, num);
            num.remove(num.size()-1);
        }

        if (root.right !=null){
            num.add(root.right.val);
            helper(root.right, target-root.right.val, nums, num);
            num.remove(num.size()-1);
        }
    }

    private void dfs(TreeNode root, int target, int sum, List<List<Integer>> nums, List<Integer> num){
        sum += root.val;
        if (sum == target) {

            nums.add(new ArrayList(num));
            //list.add(num);
            return;
        }
        num.add(root.val);


        if(root.left != null) {
            dfs(root.left, target, sum, nums, num);
            num.remove(num.size()-1);
        }

        if(root.right != null) {
            dfs(root.right, target, sum, nums, num);
            num.remove(num.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] treeNodes = {1,2,4,2,3};



        //初始化整形数组
        TreeNode tree = createTree();
        TreeSolution ts = new TreeSolution();
        List<List<Integer>> list = ts.binaryTreePathSum(tree, 5);
        for(List l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }


    private static TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;

        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(3);
        root.left.left = ll;
        root.left.right = lr;

        return root;
    }


}
