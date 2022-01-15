// method 1
// time o(n2) and space o(n2)

class Solution {
    public void rotate(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        int temp[][] = new int[m][n];
        
        for(int i=m-1, l=0; i>=0 && l<m; i--, l++){
            for(int j=0; j<n; j++){
                temp[j][l] = arr[i][j];
            }
        }
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = temp[i][j];
    }
}

// method 2
// time o(n2)

class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        
        // finding transpose of matrix;
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
                swap(mat, i, j);
        
        // reverse column values;
        for(int i=0; i<n; i++){
            int low = 0;
            int high = n-1;
            while(low <= high){
                swap(mat, i, low, high);
                low++;
                high--;
            }
        }
    }
    
    
    private void swap(int mat[][], int i, int j){
        int temp = mat[j][i];
        mat[j][i] = mat[i][j];
        mat[i][j] = temp;
    } 
    
    private void swap(int mat[][], int index, int i, int j){
        int temp = mat[index][i];
        mat[index][i] = mat[index][j];
        mat[index][j] = temp;
    } 
}
