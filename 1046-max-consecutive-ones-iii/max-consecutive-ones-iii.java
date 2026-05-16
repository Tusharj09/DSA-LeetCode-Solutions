class Solution {
    public int longestOnes(int[] nums, int k) {

     int maxLen = 0,zeros = 0, i=0, len  = nums.length;

    for(int j = 0  ;j< len ; j++) {


        if(nums[j]== 0 )
            zeros ++;
        
        while(zeros > k) {
        
         if(nums[i] == 0)
                    zeros--;

                i++;

            
        
        }

        maxLen = Math.max(j- i +1 , maxLen);
    

     }
        return maxLen;
    }
}