class Solution {

    public void merge(int low,int mid, int high, int[] nums ) {


        int m = low, n = mid+1, k =0; 
        int[] temp = new int[high - low + 1];

        while( m <= mid  && n <= high ) {


            if(nums[m] <= nums[n]){
                temp[k++] = nums[m++];
            }
            else if ( nums[n] < nums[m] ) {
                temp[k++]= nums[n++];
            }
            
        }

          while (m <= mid) {
            temp[k++] = nums[m++];
        }

        while (n <= high) {
            temp[k++] = nums[n++];
        }

        // copy back to original array
        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }

    }

    public void mergeSort(int low , int high , int [] nums) {
    

    if(low >= high) return;
       int mid = low + (high - low)/2;

       mergeSort(low, mid, nums);
       mergeSort(mid+1 , high , nums);
       merge(low,mid,high ,nums); 
    }


    public int[] sortArray(int[] nums) {

    int low = 0, high = nums.length-1;



    mergeSort(low, high , nums);

    return nums;
        
    }
}