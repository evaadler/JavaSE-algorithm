package jianzhioffer;

import java.util.*;

/**
 * Created by fifi on 2017/6/6.
 */
public class Solution {
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        while(listNode!=null){

        }

        return null;
    }


    /**
     * 重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int root = pre[0];
        TreeNode tn = new TreeNode(root);

        //int[] leftNodes = Arrays.
        for (int i=0 ; i<in.length; i++){
            if (in[i]!=root){
                TreeNode tnc = new TreeNode(in[i]);
                if (i==0)
                    tn.left = tnc;
                else
                    tnc.left = tnc;
            }else {
                break;
            }
        }
        return null;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        int value = stack1.get(0);
        stack1.remove(0);
        return value;
    }

    public int Fibonacci(int n) {

        return 0;
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        for (int row=0; row<array.length; row++){
            for (int col=0; col<array[row].length; col++){
                if (array[row][col] == target) return true;
            }
        }
        return false;
    }

    /**
     * 连续自数组的最大和
     * @return
     */
    public int findGreatestSum(int[] array){
        if (array==null || array.length == 0)return 0;
        else {
            int total = array[0], max = array[0];
            for (int i=0; i<array.length; i++){
                if (total > 0 ){
                    total += array[i];
                }else {
                    total = array[i];
                }
                if (total > max){
                    max = total;
                }
            }
            return max;
        }


    }

    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        helper(root, target - root.val, list);
        return result;
    }
    public void helper(TreeNode root, int target, List<Integer> list ) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (root == null) {
            return;
        }

        if (root.left != null) {
            list.add(root.left.val);
            helper(root.left, target - root.left.val, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            helper(root.right, target - root.right.val, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] treeNodes = {1,2,4,2,3};



        //初始化整形数组
        TreeNode tree = createTree();
       Solution ts = new Solution();
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
