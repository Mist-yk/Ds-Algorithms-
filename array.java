//to rotate any arry with k steps the intution is to reverse from begin to k and then k to n -1; then 0 to n-1;


//Rotate arry by k
class Solution {
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n;   
        
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }
    
    private static void reverse(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


//Greedy algo             the idea is to take farthest and current end where u can reach and then iterate and update farthest ,if i reach the cuurend we update currend and increase jump

class Solution {
    public int minJumps(int[] arr) {
        // code here
        int jump =0;
        int currend =0;
        int farthest = 0;
        
        for(int i =0; i <arr.length -1; i++){
            farthest = Math.max(farthest, i + arr[i]);
            
            if(i == currend){
                jump++;
                currend = farthest;
            }
        }
        return jump;
    }
}
