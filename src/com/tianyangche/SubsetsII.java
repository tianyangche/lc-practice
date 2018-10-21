package com.tianyangche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int pos, int[] nums) {
        res.add(new ArrayList<>(curr));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            dfs(res, curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
