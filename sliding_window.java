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



//Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, currsum =0;
        int minLen = n + 1;
        for(int right =0; right < n; right++){
            currsum += nums[right];
            while(currsum >= target){
                minLen = Math.min(minLen , right -left + 1); //currlen = right - left + 1
                currsum -= nums[left++];
            }
        }
        //if minLen is not updated it is as same as intialize at the begining return 0 else return minLen
        return minLen == n + 1 ? 0 : minLen;
    }
}
