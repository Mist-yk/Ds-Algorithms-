class Solution {
    public int countBinarySubstrings(String s) {
        int prevFreq =0;
        int currFreq = 1;
        int count =0;
        for(int i =1; i <s.length(); i++){ 
            if(s.charAt(i) == s.charAt(i-1)){
                currFreq++;
            }
            else{
                count += Math.min(prevFreq,currFreq);
                prevFreq = currFreq;
                currFreq = 1;
            }

        }
        count += Math.min(prevFreq,currFreq);
        return count;
    }
}