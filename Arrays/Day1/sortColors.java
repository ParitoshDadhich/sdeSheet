class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, mid = 0, two = n-1;
        
        while(mid <= two){
            if(nums[mid] == 0){
                swap(nums, mid, zero);
                zero++;
                mid++;
            } else if(nums[mid] == 2){
                swap(nums, mid, two);
                two--;
            } else
                mid++;
        }
    }
    
    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
