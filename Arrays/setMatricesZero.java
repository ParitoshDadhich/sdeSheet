// method 1
// PS: in this approach all numbers must be whole number;

// TIME O(n^3)
// SPACE O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    for(int k=0; k<n; k++)
                        if(matrix[i][k] != 0)
                            matrix[i][k] = Integer.MAX_VALUE;
                    
                    for(int k=0; k<m; k++)
                        if(matrix[k][j] != 0)
                            matrix[k][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
            }
        }
        
        
    }
}




// method 2
// TIME O(n2)
// SPACE O(m + n)


class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        int col[] = new int[n];
        int row[] = new int[m];
        
        Arrays.fill(col, -1);
        Arrays.fill(row, -1);
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0){
                    col[j] = 0;
                    row[i] = 0;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(col[j] == 0 || row[i] == 0)
                    arr[i][j] = 0;
            }
        }
        
    }
}


// method 3
// TIME O(n2)
// SPACE O(1)


class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
    
        int col0 = 1;    
        for(int i=0; i<m; i++){
            if(arr[i][0] == 0)
                col0 = 0;
            for(int j=1; j<n; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=1; j--){
                if(arr[i][0] == 0 || arr[0][j] == 0)
                    arr[i][j] = 0;
            }
            if(col0 == 0) arr[i][0] = 0;
        }
        
    }
}
