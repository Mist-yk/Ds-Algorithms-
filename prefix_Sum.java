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
