package offer;

/**
 * Created by fifi on 2017/7/12.
 */
public class ReadTreeNode {

    /**
     * [1,2,4,2,3,-1,-1]
     * 以一个平横二叉树的形式建立树结构
     * @param nodes
     */
    public static TreeNode createTree(int[] nodes){
        TreeNode root = new TreeNode(nodes[0]);
        int height = 1;

            bfs(1, root, nodes);

            return root;
    }

    private static void bfs(int height, TreeNode root, int[] nodes){

        if (root == null) return;
            int idxLeft = 2 * height;
            if((idxLeft) > nodes.length || nodes[idxLeft-1] == -1)
                return;
            root.left = new TreeNode(nodes[idxLeft-1]);
            bfs(height+1, root.left, nodes);



            int idxRight = 2 * height + 1;
        if((idxRight+1) > nodes.length || nodes[idxRight + 1] == -1)
            root.right = new TreeNode(nodes[idxRight + 1]);
            bfs(height+1, root.right, nodes);



    }


}
