//Range Sum Query - Immutable                                 //easy
class NumArray {
    private int[] prefix_arr;
    public NumArray(int[] nums) {
        prefix_arr = new int[nums.length + 1];
        prefix_arr[0] = 0;
        for(int i=0; i < nums.length; i++){
            prefix_arr[i + 1] = prefix_arr[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // if(left == 0){
        //     return prefix_arr[right];                  //edge case 
        // }
        return prefix_arr[right  + 1] - prefix_arr[left];
        
    }
}

//Subarray Sum Equals K                                      //medium
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0,sum =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0; i < nums.length; i++){
            sum +=nums[i];    //stores the sum
            if(hm.containsKey(sum - k)){
                count += hm.get(sum - k);
            }
            hm.put(sum ,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}


//Continuous Subarray Sum                medium

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(0,-1);
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            int remainder = sum % k;

            if(hm.containsKey(remainder)){
                if(i - hm.get(remainder) > 1){
                    return true;
                }
            }
            else{
                hm.put(remainder,i);
            }
        }
        return false;
    }
}


//Find middle Index                                //easy
class Solution {
    public int findMiddleIndex(int[] nums) {
       int total =0;
    for(int num : nums){
        total += num;
    } 
    int left_sum = 0;
    for(int i =0; i < nums.length; i++){
        int right_sum = total - left_sum - nums[i];
        if(left_sum == right_sum){
            return i;
        }
        left_sum += nums[i];
    }
    return -1;
    }
}


//Product of Array Except Self                                   //medium
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []result = new int[n];

        result[0] = 1;
        for(int i =1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        } 
        int right = 1;
        for(int i = n-1; i >= 0;i--){
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
}



//Number of ways to split array                                      //medium
class Solution {
    public int waysToSplitArray(int[] nums) {

        int []arr = new int[nums.length + 1];
        long rightsum = 0,leftsum=0;
        for(int num : nums){
            rightsum += num;
        }

        int count =0;
        for(int i =0 ; i <nums.length -1; i++){
            leftsum += nums[i];
            rightsum -= nums[i];

            if(leftsum >= rightsum){
                count++;
            }
        }

            return count;
    }
}


//Contigious array                        //medium
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int zero =0; int one = 0; int maxLen =0;

        hm.put(0 , -1);
        for(int i=0; i < nums.length; i++){
            if(nums[i] ==0) zero++; else one++;
            int diff = zero - one;

            if(hm.containsKey(diff)){
                maxLen = Math.max(maxLen, i - hm.get(diff));
            }else{
                hm.put(diff,i);
            }
        }
        return maxLen;
    }
}
