package com.tianyangche;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }


    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                int h = heights[stack.pop()];
                int l = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * l);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int l = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, h * l);
        }
        return max;
    }
}
