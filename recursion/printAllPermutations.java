// method 1
// time o(n!*n)
// space o(n) + 0(n) + o(n), for array, map and recursive stack

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        
        int n = nums.length;
        
        getAllPermuatation(ans, nums, list, map);
        return ans;
    }
    
    
    private void getAllPermuatation(List<List<Integer>> ans, int nums[], List<Integer> list, boolean map[]){
        // base case
        if(list.size() == map.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // traversing and generating every permutations;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!map[i]){
                map[i] = true;
                list.add(nums[i]);
                getAllPermuatation(ans, nums, list, map);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
        
    }
    
    
}



// method 2
// time o(n!*n) and space o(n), recursive space stack
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        
        return ans;
    }
    
    private void solve(int index, int arr[], List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i: arr)
                list.add(i);
            
            ans.add(new ArrayList<>(list));
            return;
        }   
        
    
        for(int i=index; i<arr.length; i++){
            swap(index, i, arr);
            solve(index+1, arr, ans);
            swap(index, i, arr);    // swaping again so that order will remain same ans we can put every element at each index
        }
    }
    
    private void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
