// method 1
// time o(n^3)

class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k = i; k<=j; k++)
                    sum += arr[k];
                
                max = Math.max(sum, max);
            }
        }
        return max;
        
    }
}

// method 2
// time o(n^2)

class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
        
    }
}


// method 3
// time o(n)
// kadane's algo

class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++){
            if(sum < 0)
                sum = 0;
            
            sum += arr[i];
            max = Math.max(sum, max);
        }
        return max;
        
    }
}
