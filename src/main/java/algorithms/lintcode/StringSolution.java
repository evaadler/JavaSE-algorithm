package algorithms.lintcode;

import java.util.*;

/**
 * Created by fifi on 2017/7/13.
 */
public class StringSolution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.equals(""))
            return 0;
        // Write your code here
        //Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars){
            nums[c] += 1;
        }

        int result = 0;
        for (char c : chars){
            if(nums[c] == 1){
                result = s.indexOf(c);
                break;
            }

        }

        return result;
    }

    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     * Error list:
     * 1. Memory Limit Exceed
     */
    public List<Integer> subStringAnagrams(String s, String p) {
        // Write your code here
        int[] chars = new int[128];
        char[] findStr = p.toCharArray();
        for (char c : findStr){
            chars[c] = 1;
        }

        int start = 0;
        int end = 0;
        int len = p.length();

        char[] strs = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        addIdx(chars, p, list, start, end, strs);
        //List<Integer> result = Collections.emptyList();
        //result.addAll(list);
        return list;

    }

    private void addIdx(int[] chars, String p, List<Integer> list, int start, int end, char[] strs){
       end = start+p.length();

       if(end>strs.length) return;
        char[] ps = p.toCharArray();
       boolean flag = true;

       for (int i = start; i<end; i++){

           /*
           if(p.indexOf(strs[start])==-1){
               flag = false;
           }
           */
          if( chars[strs[start]] != 1) {
              addIdx(chars, p, list, start + 1, end, strs);
          }
       }

        if(!list.contains(start)){
            list.add(start);
        }


    }

    public static void main(String[] args) {
        StringSolution ss = new StringSolution();
        System.out.println(ss.findAnagrams("cbaebabacd", "abc"));
    }


    public List<Integer> findAnagrams(String s, String p){
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        int left=0, right=0, count = p.length();

        int[] map = new int[256];
        char[] sc = s.toCharArray();

        for (char c: p.toCharArray()) map[c]++;

        while (right < s.length()) {
            if (map[sc[right++]]-->=1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && map[sc[left++]]++ > 0) count++;
        }
        return result;
    }
}
