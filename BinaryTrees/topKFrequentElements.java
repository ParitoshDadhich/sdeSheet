class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd, cur.node.data);
            }
            
            if(cur.node.left != null)
                q.add(new Pair(cur.hd-1, cur.node.left));
            
            if(cur.node.right != null)
                q.add(new Pair(cur.hd+1, cur.node.right));
            
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
            for(Integer m:map.keySet()){
                ans.add(map.get(m));
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
