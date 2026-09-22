class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        // int []nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < n; i ++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                prices[stack.pop()] -= prices[i]; 
            }
             stack.push(i);
            }
            return prices;
        }
    }
