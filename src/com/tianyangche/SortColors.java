package com.tianyangche;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int zero = 0;
        int two = nums.length - 1;
        int one = zero;
        while (one <= two) {
            if (nums[one] == 0) {
                int temp = nums[one];
                nums[one] = nums[zero];
                nums[zero] = temp;
                zero++;
                one++;
            } else if (nums[one] == 2) {
                int temp = nums[one];
                nums[one] = nums[two];
                nums[two] = temp;
                two--;
            } else {
                one++;
            }
        }
    }
}