class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums2){
           while(!st.isEmpty() && st.peek() < num){
                int smaller = st.pop();
                map.put(smaller,num);
           }
           st.push(num);
        }
        int nge[] = new int[nums1.length];
        for(int i =0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                nge[i] = map.get(nums1[i]);
            }
            else{
                nge[i] = -1;
            }
        }
        return nge;
    }
}