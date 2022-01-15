// method 1
// In Two pass

class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 0) count0++;
            if(arr[i] == 1) count1++;
            if(arr[i] == 2) count2++;
        }
        
        for(int i=0; i<n; i++){
            if(i < count0)
                arr[i] = 0;
            
            else if(i < count0 + count1)
                arr[i] = 1;
            
            else
                arr[i] = 2;
        }
        
    }
}

// method 2
// In One pass

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
