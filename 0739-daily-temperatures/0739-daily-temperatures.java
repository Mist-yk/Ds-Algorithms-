class Solution {
    public int[] dailyTemperatures(int[] temprature) {
        Stack<Integer> st = new Stack<>();
        int []res = new int[temprature.length];
        for(int i =0; i <temprature.length; i++){
            while(!st.isEmpty() && temprature[i] > temprature[st.peek()]){
                int indx = st.pop();
                res[indx] = i - indx;
            }
            st.push(i);
        } 
        return res;
    }
}