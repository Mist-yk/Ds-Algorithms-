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
