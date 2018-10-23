package com.tianyangche;

public class MedianOfTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (total % 2 == 1) {
            return helper(A, 0, m, B, 0, n, total / 2 + 1);
        } else {
            return ( helper(A, 0, m, B, 0, n, total / 2) + helper(A, 0, m, B, 0, n, total / 2 + 1) ) / 2.0;
        }
    }

    private int helper(int[] A, int a, int m, int[] B, int b, int n, int len) {
        if (m > n) {
            return helper(B, b, n, A, a, m, len);
        }

        if (m == 0) {
            return B[b + len - 1];
        }

        if (len == 1) {
            return Math.min(A[a], B[b]);
        }

        int mm = Math.min(len / 2, m);
        int nn = len - mm;

        if (A[a + mm - 1] < B[b + nn - 1]) {
            return helper(A, a + mm, m - mm, B, b, n, len - mm);
        } else {
            return helper(A, a, m, B, b + nn, n - nn, len - nn);
        }

    }
}
