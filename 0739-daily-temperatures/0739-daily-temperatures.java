class Solution {
    public int[] dailyTemperatures(int[] temprature) {
        Stack<Integer> stack = new Stack<>();
        int []res = new int[temprature.length];
        for(int i=0 ; i< temprature.length; i++){
            while(!stack.isEmpty() && temprature[i] > temprature[stack.peek()]){
                int indx = stack.pop();
                res[indx] = i - indx;
            }
            stack.push(i);
        }
        return res;
    }
}