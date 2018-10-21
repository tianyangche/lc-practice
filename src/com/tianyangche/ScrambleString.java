package com.tianyangche;

public class ScrambleString {
    /**
     *
     Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

     Below is one possible representation of s1 = "great":

     great
     /    \
     gr    eat
     / \    /  \
     g   r  e   at
     / \
     a   t
     To scramble the string, we may choose any non-leaf node and swap its two children.

     For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

     rgeat
     /    \
     rg    eat
     / \    /  \
     r   g  e   at
     / \
     a   t
     We say that "rgeat" is a scrambled string of "great".

     Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

     rgtae
     /    \
     rg    tae
     / \    /  \
     r   g  ta  e
     / \
     t   a
     We say that "rgtae" is a scrambled string of "great".

     Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

     Example 1:

     Input: s1 = "great", s2 = "rgeat"
     Output: true
     Example 2:

     Input: s1 = "abcde", s2 = "caebd"
     Output: false
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == null ? s2 == null || s2.isEmpty() : s1 == null || s1.isEmpty();
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        boolean[][][] f = new boolean[n + 1][n][n];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    f[i][j][k] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }


        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                for (int j = 0; j + l <= n; j++) {
                    for (int k = 1; k < l; k++) {
                        if ((f[k][i][j] && f[l - k][i + k][j + k] )
                                ||f[k][i][j + l - k] && f[l - k][i + k][j]) {
                            f[l][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[n][0][0];
    }
}
