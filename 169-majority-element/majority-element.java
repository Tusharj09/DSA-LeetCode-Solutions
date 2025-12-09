class Solution {
    public int majorityElement(int[] nums) {

       int count = 1 , mElement = nums[0]; 
       for(int i = 1 ; i< nums.length; i++ ) {

        if(nums[i]== mElement  && count > 0) count ++;
        else {
            count --; 
            if(count == 0)  {
                mElement = nums[i];
                count =1;
            }
        }
       }
       return mElement; 
    }
}