package com.tianyangche;

public class SodukuSolver {

    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     *
     * A sudoku solution must satisfy all of the following rules:
     *
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * Empty cells are indicated by the character '.'.
     *
     * Note:
     *
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     * @param board
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValid(board) && solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (!isValidCol(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidSubBoard(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] f = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') {
                continue;
            }
            int pos = board[row][i] - '1';
            if (f[pos]) {
                return false;
            }
            f[pos] = true;
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        boolean[] f = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            int pos = board[i][col] - '1';
            if (f[pos]) {
                return false;
            }
            f[pos] = true;
        }
        return true;
    }

    private boolean isValidSubBoard(char[][] board, int row, int col) {
        boolean[] f = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row * 3 + i][col * 3 + j] == '.') {
                    continue;
                }
                int pos = board[row * 3 + i][col * 3 + j] - '1';
                if (f[pos]) {
                    return false;
                }
                f[pos] = true;
            }
        }
        return true;
    }
}
