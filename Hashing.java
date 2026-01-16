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

//longest consecutive sequence                        //medium
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int maxlen =0;
        for(int num : hs){
            if(!hs.contains(num -1)){
                int currNum = num;
                int currLen = 1;

                while(hs.contains(currNum + 1)){
                    currNum++;
                    currLen ++;
                }
               if (currLen > maxlen) {
                      maxlen = currLen;
                    }
            }
        }
        return maxlen;
    }
}

//Intersectio of two arrays                //mid
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for(int i =0; i < nums1.length; i++){
            hs.add(nums1[i]);
        }

        for(int num : nums2){
            if(hs.contains(num)){
                res.add(num);
            }
        }
        int []result = new int[res.size()];
        int index =0;
        for(int num : res){
            result[index++] = num;
        }
        return result;
    }
}
