package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * // Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.

 // For example, given
 // s = "leetcode",
 // dict = ["leet", "code"].

 // Return true because "leetcode" can be segmented as "leet code".
 * Created by fifi on 2017/4/22.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {

               if(dp[j] && wordDict.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;

                }

            }

        }

        return dp[s.length()];

    }

    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        boolean flag = wb.wordBreak("leetcode", set);
        System.out.println(flag);

    }
}
