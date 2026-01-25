//Fixed window size
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

//Maximum Sum of Distinct Subarrays With Length K

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       Set<Integer> s = new HashSet<>();
       long max=0, sum =0;
       int left = 0;
       for(int i=0; i<nums.length; i++){
        while(s.contains(nums[i]) || s.size() == k){
            s.remove(nums[left]);
            sum -= nums[left++];
        }
        sum += nums[i];
        s.add(nums[i]);
        if(s.size() == k){
            max = Math.max(max,sum);
        }
       }
       return max;
    }
} 



//variable size
//Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        int maxlen = 0;
        int left =0;
        
        for(int right =0; right < n; right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxlen = Math.max(maxlen , right - left + 1);
        }
        return maxlen;
    }
}
                      
