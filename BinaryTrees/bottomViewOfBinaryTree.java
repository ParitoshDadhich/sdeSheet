class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            // whether the element is present or not we will add the node into the map
            map.put(curr.hd, curr.node.data);
            
            // add left and right elements into the queue;
            if(curr.node.left != null)
                q.add(new Pair(curr.hd-1, curr.node.left));
            
            if(curr.node.right != null)
                q.add(new Pair(curr.hd+1, curr.node.right));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer m: map.keySet())
            ans.add(map.get(m));
        
        return ans;
    }
    
    static class Pair{
        int hd;
        Node node;
        
        Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    
}
