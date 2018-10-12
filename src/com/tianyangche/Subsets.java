package com.tianyangche;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         if (nums == null || nums.length == 0) {
             return res;
         }
         dfs(res, new ArrayList<>(), nums, 0);
         return res;
     }

     private void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int pos) {
         res.add(new ArrayList<>(curr));
         for (int i = pos; i < nums.length; i++) {
             curr.add(nums[i]);
             dfs(res, curr, nums, i + 1);
             curr.remove(curr.size() - 1);
         }
     }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets solution = new Subsets();
        System.out.println(solution.subsets(nums));
    }
}
