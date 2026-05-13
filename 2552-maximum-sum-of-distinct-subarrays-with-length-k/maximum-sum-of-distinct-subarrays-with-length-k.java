class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        long maxSum = 0;
        long sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {

            while (st.contains(nums[end])) {
                st.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
            
            sum += nums[end];
            st.add(nums[end]);

            if (end - start + 1 > k) {
                st.remove(nums[start]);
                sum -= nums[start];
                start++;
            }

            if (end - start + 1 == k) {
                maxSum = Math.max(sum, maxSum);
            }


        }
        return maxSum;

    }
}