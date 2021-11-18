class Solve {
    int[] findTwoElement(int arr[], int n) {
        int xor = 0;
        for(int i: arr)
            xor ^= i;
            
        for(int i=1; i<=n; i++)
            xor ^= i;
            
        // find the set bit
        int setBit = xor & ~(xor-1);
        
        int x = 0; // bucket having set bit;
        int y = 0;  // bucket not having set bit;
        
        for(int i=0; i<n; i++){
            if((arr[i]&setBit) != 0)
                x ^= arr[i];
            else
                y ^= arr[i];
        }
        
        for(int i=1; i<=n; i++){
            if((i&setBit) != 0)
                x ^= i;
            else
                y ^= i;
        }
        
        boolean flagX = false;
        boolean flagY = false;
        
        for(int i: arr){
            if(i == x)
                flagX = true;
            if(i == y)
                flagY = true;
        }
        
        int ans[] = new int[2];
        
        // reapeating
        ans[0] = flagX == true ? x : (flagY == true ? y : x);
        // missing
        ans[1] = flagX == false ? x : (flagY == false ? y : x);
        
        return ans;
    }
}
 
