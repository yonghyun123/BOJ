package sw_expert.Tree.Inorder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inorder {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = 0;
		
		while(T++ < 10){
			BinarySearchTree root = new BinarySearchTree();
			int numOfNode = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < numOfNode; i++){
				String[] inputLine = sc.nextLine().split(" ");
				TreeNode node = new TreeNode(inputLine[1]);
				root.addNode(node);
			}
			System.out.print("#"+T+" ");
			root.inorder(root.root);
			System.out.println();
		}
	}

}

class TreeNode{
	String item;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){
		this.item = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(String inputLine){
		this.item = inputLine;
		this.left = null;
		this.right = null;
	}
	
	public String getItem(){
		return this.item;
	}
}

class BinarySearchTree{
	public TreeNode root;
	
	public void inorder(TreeNode rootNode){
		if(rootNode != null){
			inorder(rootNode.left);
			System.out.print(rootNode.item);
			inorder(rootNode.right);
		}

	}
	
	public void addNode(TreeNode node){
		if(root == null){
			this.root = node;
		} else {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			
			while(!q.isEmpty()){
				TreeNode temp = q.poll();
				if(temp.left == null){
					temp.left = node;
					break;
				} else {
					q.add(temp.left);
				}
				if(temp.right == null){
					temp.right = node;
					break;
				} else {
					q.add(temp.right);
				}
			}
		}
	}
}