class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int len  = nums.length;
        int  min = Integer.MAX_VALUE ,flag = 0;
        int ans = min;
        

        for(int i =0  ;i< len-2; i++) {
        int left = i+1 , right = len-1;

        while(left < right) {

            int sum = nums[i] + nums[left] +nums[right];
            if( sum == target) return sum;
            
            
              if(Math.abs(sum-target) < min) {
                        min = Math.abs(sum-target);
                        ans = sum;
             }
             if(sum < target) left++;
             else right--;
            
        }
        }

    return ans==Integer.MAX_VALUE?0:ans;
}}