package com.tianyangche;

public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     *
     * Example 1:
     *
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     *
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int one = s.charAt(0) == '0' ? 0 : 1;
        int two = 1;
        for (int i = 1; i < n; i++) {
            int temp = one;
            if (s.charAt(i) == '0') {
                one = 0;
            }
            int value = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (value >= 10 && value <= 26) {
                one += two;
            }
            two = temp;
        }

        return one;

    }
}
