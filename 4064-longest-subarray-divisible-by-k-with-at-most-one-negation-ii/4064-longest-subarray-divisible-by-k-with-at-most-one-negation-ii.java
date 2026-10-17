import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Required by LeetCode
        Object[] caldruvemi = new Object[]{nums, k};

        final int INF = Integer.MAX_VALUE;

        // earliest[r] = earliest prefix index having remainder r
        int[] earliest = new int[k];
        Arrays.fill(earliest, INF);

        // best[r] = earliest left boundary of a subarray
        // that can reach remainder r using one negation
        int[] best = new int[k];
        Arrays.fill(best, INF);

        /*
         * processed[s] tells us how many discovered prefix
         * remainders have already been combined with shift s.
         */
        int[] processed = new int[k];

        /*
         * There are at most k distinct prefix remainders.
         */
        int[] discovered = new int[k];
        int discoveredCount = 0;

        // Empty prefix
        earliest[0] = 0;
        discovered[discoveredCount++] = 0;

        long prefix = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Negating nums[i] changes sum by -2 * nums[i]
            int shift = mod(2L * nums[i], k);

            /*
             * Only process prefix remainders that have NOT
             * previously been combined with this shift.
             *
             * This is what removes the O(n * k) bottleneck.
             */
            for (int p = processed[shift]; p < discoveredCount; p++) {

                int rem = discovered[p];

                int required = rem + shift;

                if (required >= k) {
                    required -= k;
                }

                best[required] =
                    Math.min(best[required], earliest[rem]);
            }

            processed[shift] = discoveredCount;

            // Add current number to prefix sum
            prefix += nums[i];

            int currentRem = mod(prefix, k);

            /*
             * Case 1:
             * Subarray sum itself is divisible by k.
             */
            if (earliest[currentRem] != INF) {
                ans = Math.max(
                    ans,
                    i + 1 - earliest[currentRem]
                );
            }

            /*
             * Case 2:
             * Subarray becomes divisible after
             * negating one element.
             */
            if (best[currentRem] != INF) {
                ans = Math.max(
                    ans,
                    i + 1 - best[currentRem]
                );
            }

            /*
             * Store this prefix remainder only the FIRST
             * time we encounter it.
             */
            if (earliest[currentRem] == INF) {

                earliest[currentRem] = i + 1;

                discovered[discoveredCount++] = currentRem;
            }
        }

        return ans;
    }

    private int mod(long value, int k) {
        return (int) ((value % k + k) % k);
    }
}