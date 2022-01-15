// method 1
// o(n^2)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(prices[i] < prices[j])
                    profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        
        return profit;
    }
}

// method 2
// time o(n)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            if(prices[i] < min)
                min = prices[i];
            
            profit = Math.max(profit, prices[i] - min);
        }
        
        return profit;
    }
}
