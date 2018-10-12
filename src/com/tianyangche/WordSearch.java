package com.tianyangche;

public class WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     * Example:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] f = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (foundWord(board, 0, word, f, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean foundWord(char[][] board, int pos, String word, boolean[][] f, int p, int q) {
        if (pos == word.length()) {
            return true;
        }
        if (p < 0 || p >= board.length || q < 0 || q >= board[0].length || word.charAt(pos) != board[p][q] || f[p][q]) {
            return false;
        }
        f[p][q] = true;
        if (foundWord(board, pos + 1, word, f, p - 1, q)
            || foundWord(board, pos + 1, word, f, p, q - 1)
            || foundWord(board, pos + 1, word, f, p + 1, q)
            || foundWord(board, pos + 1, word, f, p, q + 1)) {
                return true;
            }
        f[p][q] = false;
        return false;
    }
}
