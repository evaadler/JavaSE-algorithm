public class 最长连续递增子序列 {

    public static void main(String[] args) {
        //int[] arr = {1,3,5,7};  // 3
        //int[] arr = {2,2,2,2};    // 1
        int[] arr = {1,3,5,4,2,3,4,5};
        //int[] arr = {2,1,3};

        int max = 0;
        int len = 0;
        for (int i=0; i<arr.length-1; i++){
            if(arr[i+1]<=arr[i]){
                len = 0;
            }else {
                len++;
            }

            max = Math.max(max, len);
        }

        if (max == 0) max = len;
        System.out.println(max+1);
    }
}
