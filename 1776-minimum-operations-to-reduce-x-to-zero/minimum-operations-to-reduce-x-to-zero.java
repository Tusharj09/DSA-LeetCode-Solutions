class Solution {
    public int minOperations(int[] nums, int x) {
        int l = nums.length;
        int minOp = 1000006;
        Map<Integer,Integer> sMap = new HashMap<>();
        int op = 0,  suffixSum= 0;
 
        for(int i = l - 1; i>=0 ; i--) {
            suffixSum += nums[i];
            sMap.put(suffixSum,++op);
        }
         if(sMap.containsKey(x)) {
            minOp =  Math.min(minOp,sMap.get(x));
        }
        int prefixSum  = 0 ;
        op = 0;
        for(int i = 0 ; i< l ; i++) {
            prefixSum += nums[i]; 
            if(prefixSum == x) {
                minOp = Math.min(minOp,i+1);
            }

            if(sMap.containsKey(x-prefixSum)) {
                int suffixOps = sMap.get(x-prefixSum);

                if(i + 1 + suffixOps <= l) {

                    op = suffixOps + (i + 1);

                    minOp = Math.min(minOp, op);
                }
            }
        }

       
        return minOp == 1000006 ? -1 : minOp;
    }
}