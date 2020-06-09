package algorithms.lintcode;

import jianzhioffer.ListNode;
import jianzhioffer.TreeNode;

import java.util.*;

/**
 * Created by fifi on 2017/6/17.
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        Math.abs(11);

        if (root == null) {
            return root;
        }
        TreeNode maxLeft = maxNode(root.left);
        TreeNode maxRight = maxNode(root.right);
        return max(root, max(maxLeft, maxRight));
    }

    public TreeNode max(TreeNode a, TreeNode b){
        if (a == null){
            return b;}
        if (b == null){
            return a;}
        if (a.val > b.val){
            return a;}
        else{
            return b;}
    }

    /**
     * @param a an integer array
     *
     */
    public void sortIntegers(int[] a) {
        // Write your code here
    }

    private void selectionSort(int[] arr){

    }

    private void bubbleSort(int[] arr){

    }

    private void insertionSort(int[] arr){

    }

    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        head = preNode;

        // Write your code here
        while(head.next!=null){
            ListNode node = head.next;
            if (val == node.val){
                head.next = node.next;
            }else{
                head = head.next;
            }
        }
        return preNode.next;
    }


    public ListNode removeElementsDemo(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            ListNode node = head.next;
            if (node.val == val) {
                node = node.next;
            } else {
                head = node;
            }
        }

        return dummy.next;
    }

    /**
     * @return: The same instance of this class every time
     */
    private static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if (instance == null){
            instance = new Solution();
        }
        return instance;
    }

    /**
     * @param board: the board
     @return: wether the Sudoku is valid
     分析：判断有效难，判断无效容易，分别从行遍历，列遍历，小的九宫格遍历判断失效
     */
    public boolean isValidSudoku(char[][] board) {
        // 九宫格
        int count = 9;
        boolean[] visited = new boolean[count];
        for (int i=0; i<count; i++){
            Arrays.fill(visited, false);
            for (int j=0; j<count; j++){
                if (!process(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i=0; i<count; i++){
            Arrays.fill(visited, false);
            for (int j=0; j<count; j++){
                if (!process(visited, board[j][i])) {
                    return false;
                }
            }
        }

        for (int i=0; i<count; i+=3){
           // Arrays.fill(visited, false); error position
            for (int j=0; j<count; j+=3){
                // fix at here
                Arrays.fill(visited, false);
                    for (int k=0; k<count; k++){
                        if (!process(visited, board[i+k/3][j+k%3])){
                            return false;
                        }
                    }
            }
        }

        return true;
    }

    private boolean process(boolean[] visited, char digit){
        if (digit == '.'){
            return true;}
        int num = digit - '0';

        if (num<1 || num>9 || visited[num-1]){
            return false;
        }

        visited[num-1] = true;
        return true;
    }


    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length == 0 ){
            return false;
        }

        if (matrix[0] ==  null || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[m-1].length;

        for(int i=0; i<m; i++){
            if(target == matrix[i][n-1]){
                return true;
            }

            if(target < matrix[i][n-1]) {
                m = i;
                break;
            }
        }

        m = matrix.length==m?m-1:m;

        for (int i=0; i<n; i++){
            if (target == matrix[m][i]){
                return true;
            }
        }
        return false;
    }

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int result = (int)Math.sqrt(Double.parseDouble(x+""));
        return result;
    }

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrtOfficial(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }

    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {

        // Write your code here
        if (A == null){return false;}
        if (B == null) {return false;}

        char[] as = A.toCharArray();
        char[] bs = B.toCharArray();
        char[] temp = new char[256];

        if (as.length != bs.length){return false;}

        for (int i=0; i<A.length(); i++) {
            temp[as[i]] = 1;
        }

        for (int i=0; i<B.length(); i++) {
           // if (temp[bs[i]] != 1) return false;
            temp[bs[i]] -= 1;
        }

        for (int i=0; i<temp.length; i++){
            if (temp[i] != 0){ return false;}
        }

        return true;
    }

    // 空间，时间复杂度都为 O(n)
    public boolean stringPermutationWithHash(String A, String B){
        if (A == B) {return true;}

        if (A == null || B == null || A.length() != B.length()){ return false;}

        if (A.equals(B)){ return true;}

        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        for (int i=0; i<A.length(); i++){
            char a = A.charAt(i);
            if (maps.containsKey(a)){
                if (maps.get(a)+1 == 0){
                    maps.remove(a);
                }else {
                    maps.put(a, maps.get(a)+1);
                }
            }else {
                maps.put(a, 1);
            }

            char b = B.charAt(i);
            if (maps.containsKey(b)){
                if (maps.get(b)-1 == 0){
                    maps.remove(b);
                }else {
                    maps.put(b, maps.get(b) - 1);
                }
            }else {
                maps.put(b, -1);
            }

        }

        if (maps.size() == 0){ return true;}

        return false;
    }

    /**
     * 判断是不是回文数
     * 解法：这道题是判断数字是不是回文数， 其实就是把一个数字翻转了后，和原来的数比较是否相等。这道题的难点是数字怎么翻转。
     * 有的同学可能认为可以把数字转换成为字符串来翻转，其实没有必要那么复杂，
     * 只用数字处理，每次模10得到每一位的数字，然后把数字翻转
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        // Write your code here


        if(num == 0){ return false;}

        int temp = num;   // 取余数，结尾的数

        int reverse = 0;  // 反转后的数

        while (temp != 0){
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }

        return reverse == num;

    }


    /**
     * 判断最大回文子串的长度
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || s == ""){ return 0;}

        boolean hasOdd = false;

        int[] record = new int[52];

        for (int i = 0; i < record.length; i++) {
            record[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (Character.isUpperCase(temp)) {
                record[temp - 'A']++;
            } else {
                record[temp - 'a' + 26]++;
            }
        }

        int result = 0;

        for (int i = 0; i < record.length; i++){
            result += (record[i]/2)*2;

            if (record[i] % 2 == 1){
                hasOdd = true;
            }
        }

        if (hasOdd){ result ++;}

        return result;
    }




        /**
         * Numbers of Islands
         * @param grid a boolean 2D matrix
         * @return an integer
         */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        LinkedList list = new LinkedList();

        return 0;
    }


    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0;i<s.length();i++){
            int count = 0;
            HashSet<Character> temp = new HashSet<Character>();
            temp.add(s.charAt(i));
            count++;
            for(int j = i+1;j<s.length();j++){
                if(temp.contains(s.charAt(j))){
                    break;
                }else{
                    temp.add(s.charAt(j));
                    count++;
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }

    /**
     * 判断两个字符串是不是同构的，比如："abb"与"egg"就是
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) {return false;}
        if((s == "" || t == "") && !s.equals(t)) {return false;}

        Hashtable ht = new Hashtable();


        for (int i = 0; i<s.length(); i++){

            if (ht.containsKey(s.charAt(i))){
               // if((char)ht.get(s.charAt(i)) != t.charAt(i)) return  false;
            }else {
                // 注意此句代码
                if (ht.containsValue(t.charAt(i))) {return false;}

                ht.put(s.charAt(i), t.charAt(i));
            }


        }

        return true;
    }


    /**
     * 第一个唯一的字符
     * @param s
     * @return
     */
    public int firstUniqChar(String s){

        return 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        //new Solution().sqrt(5);
        //System.out.println(s.lengthOfLongestSubstring("bb"));

        System.out.println(s.isIsomorphic("a`%ii,VEZQc_BSU%ObO5<sX81B/bOw+CNUd#Uav*P!Ax!#>hh,k#b/|>4ixFQZl+l!?bJjakbQbGglEb<g>Hf81m@A9GIvbd]qh?y__t+E(Iyv7zUEfZF{81VaM-0u?]tG=_fFR/XJ=X{-,oRpxE9u*VNYlM",
                "b`%ii-WE[Qc_BSV%OcO5<sX82B/cOw+CNVd#Vbv*P!Bx!#?hh-k#c/|?4ixFQ[l+l!?cJkbkcQcGhlEc<h?Hf82m@B9GIvcd]rh?y__t+E(Iyv7{VEf[F{82WbN/0u?]tG=_fFR/XJ=X{/-oRpxE9u*WNYlN"));
    }


}
