public class 二叉搜索树 {

    public static void main(String[] args) {

    }


    /**
     * 将有序数组转换为二叉搜索树
     */
    public TreeNode sortArrayToBST(int[] arr){
        if (arr.length == 0){
            return null;
        }

        return sortArrayToBST(arr, 0, arr.length-1);
    }

    public TreeNode sortArrayToBST(int[] arr, int start, int end){
        if (start > end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortArrayToBST(arr, start, mid-1);
        root.right = sortArrayToBST(arr, mid+1, end);

        return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
