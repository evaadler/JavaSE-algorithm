package algorithms;

/**
 * Created by fifi on 2017/5/10.
 */
public class EndTreeNode {
    private class Node{
        Node left;
        Node right;
    }
    public int nodeNum(Node head) {
        if (head == null) return 0;
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    private int bs(Node node, int l, int h){
        if (l == h){
            return 1;
        }
        // 判断右子树的最左结点到没到h
        if (mostLeftLevel(node.right, l+1) == h ){
            // （左移：2的h-l次方）
            return (1 << (h - l)) + bs(node.right, l+1, h);
        }else {
            return (1 << (h - l - 1)) + bs(node.left, l+1, h);
        }

    }

    /**
     * 返回最左结点的层数
     * @param node
     * @param level
     * @return
     */
    private int mostLeftLevel(Node node, int level) {
        while (node!=null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }


}
