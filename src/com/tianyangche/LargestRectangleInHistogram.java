package com.tianyangche;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     *
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     *
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * Example:
     *
     * Input: [2,1,5,6,2,3]
     * Output: 10
     */
    public int largestRectangleArea(int[] heights) {
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
