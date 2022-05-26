class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        q.add(new Pair(0, root));
        // vertical order traversal
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            // checking hd is present in map or not
            if(map.containsKey(curr.hd))
                map.get(curr.hd).add(curr.node.data);
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd, temp);
            }
            
            // if left present then add into queue
            if(curr.node.left != null)
                q.add(new Pair(curr.hd-1, curr.node.left));
            // if right present then add into queue
            if(curr.node.right != null)
                q.add(new Pair(curr.hd+1, curr.node.right));
            
        }
        
         ArrayList<Integer> ans=new ArrayList<>();
            for(Integer m:map.keySet()){
                ans.addAll(map.get(m));
            }
        return ans;
        
        
        
    }
    
}

class Pair{
    int hd;
    Node node;
    
    Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}
