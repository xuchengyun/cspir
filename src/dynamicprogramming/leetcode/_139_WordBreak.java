package dynamicprogramming.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordList) {
        return helper(s, new HashSet<>(wordList), 0);
    }

    private boolean helper(String s, Set<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordList) {
        return helper(s, new HashSet<>(wordList), 0, new Boolean[s.length()]);
    }

    private boolean helper(String s, Set<String> wordDict, int index, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public boolean wordBreak3(String s, List<String> wordList) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordList.contains(s.substring(j , i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
