import java.util.ArrayList;

public class Solution 
{
	
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> list = new ArrayList<>(); 
		helper(list, root, 0);
		return list;
    }
	
	private static void helper(ArrayList<Integer> list, TreeNode<Integer> root, int level){
		if(root == null){
			return;
		}
		
		if(level == list.size())
			list.add(root.data);
		
		helper(list, root.left, level+1);
		helper(list, root.right, level+1);
	}
	
	
}
