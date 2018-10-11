package com.tianyangche;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * 76. Minimum Window Substring
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     * Example:
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * Note:
     *
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null || s.isEmpty() || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> curr = new HashMap<>();
        for (char c : t.toCharArray()) {
            curr.put(c, 0);
        }
        int count = target.size();
        int min = Integer.MAX_VALUE;
        int pos = 0;
        int i = 0;
        int j = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.containsKey(c)) {
                curr.put(c, curr.get(c) + 1);
            }
            if (curr.get(c).equals(target.get(c))) {
                count--;
            }
            if (count == 0) {
                if (min > i - j + 1) {
                    min = i - j + 1;
                    pos = j;
                }
                while (count == 0) {
                    char d = s.charAt(j++);
                    if (curr.containsKey(d)) {
                        curr.put(d, curr.get(d) - 1);
                        if (curr.get(d) < target.get(d)) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        if (min > i - j + 1) {
                            min = i - j + 1;
                            pos = j;
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(pos, pos + min);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
