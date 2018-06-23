package sw_expert.Tree.Inorder;

import java.util.HashMap;
import java.util.Map;

public class Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	Map<Integer, Character> item;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){
		this.item = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(Map item){
		this.item = new HashMap<Integer, Character>(item);
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree{
	private TreeNode root = new TreeNode();
	
	
}