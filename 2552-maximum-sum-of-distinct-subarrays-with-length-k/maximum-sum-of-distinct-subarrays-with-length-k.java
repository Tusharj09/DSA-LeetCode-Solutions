class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        long maxSum = 0;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];

        }
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k)
            maxSum = Math.max(maxSum, prefixSum[k - 1]);

        for (int i = k; i < n; i++) {
            map.put(nums[i-k], map.getOrDefault(nums[i-k], 0) - 1);
            if(map.get(nums[i-k] ) == 0 )
                map.remove(nums[i-k]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);



            if (map.size() == k) {
                maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - k]);
            }

        }
        return maxSum;

    }
}