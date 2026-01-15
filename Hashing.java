//Contains duplicates               //easy
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i <nums.length;i++){
            if(hs.contains(nums[i])){
                return true;
            }
            else{
                hs.add(nums[i]);
        
            }
        }
        return false;
    }
}

//Jweles and Stones                 //easy
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count =0;
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i < jewels.length(); i++){
            hs.add(jewels.charAt(i));
        }
        for(char ch : stones.toCharArray()){
            if(hs.contains(ch)){
                count++;
            }
        }
        return count;

    }
}
