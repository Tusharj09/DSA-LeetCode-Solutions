class Solution {
    


    public int furthestBuilding(int[] heights, int bricks, int ladders) {

       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n= heights.length;
  
       for(int i = 0 ; i< n-1; i++ ) {

            if(heights[i] < heights[i+1]  ) {
                int diffHeight = heights[i+1] -heights[i];
               
                     minHeap.add(diffHeight);
                if(minHeap.size() > ladders) {
                    int smallJumps = minHeap.poll();
                    bricks = bricks - smallJumps;
                    if(bricks < 0 ) return i;
                }
            }
       }
       return n-1; 
        
    }
}