class Solution {
    public int threeSumClosest(int[] nums, int target) {


        int len  = nums.length;
        int  min = Integer.MAX_VALUE ,flag = 0;
        int ans = min;
        

        for(int i =0  ;i< len-2; i++) {
            
            for(int j = i+1 ; j<len-1; j++) {

                for(int k =  j+1; k <len; k++) {

                    int sum = nums[i] + nums[j]+ nums[k];
                    if(sum == target) return sum;
                 
                    if(Math.abs(sum-target) < min) {
                        min = Math.abs(sum-target);
                        ans = sum;
                    }

                    }
                    
                }
            }
        
        return ans == Integer.MAX_VALUE? 0 :  ans;
    }
}