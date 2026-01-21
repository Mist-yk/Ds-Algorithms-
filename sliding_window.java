//Maximum subarray average

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum =0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int max_sum = sum;
        for(int i = k; i < n; i++){
            sum -= nums[i - k];
            sum += nums[i];
            max_sum = Math.max(max_sum , sum);
        }
        return (double)max_sum/k;
    }
}
