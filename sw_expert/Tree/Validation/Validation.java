package sw_expert.Tree.Validation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Validation {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		 int T = 0;
		 
		 while(T++ < 10){
			 BinaryTree rootTree = new BinaryTree();
			 ArrayList<String> resultList;
			 int result = 1;
			 
			 int numOfNode = sc.nextInt();
			 sc.nextLine();
			 
			 for(int i = 0; i < numOfNode; i++){
				 String[] input = sc.nextLine().split(" ");
				 TreeNode node = new TreeNode(input[1]);
				 
				 rootTree.addNode(node);
			 }
			 
			 rootTree.inorder(rootTree.getRoot());
//			 System.out.println();
			 resultList = rootTree.getResultList();
			
			 for(int i = 0; i < resultList.size() - 1; i++){
				 if(isOperand(resultList.get(i)) && isOperator(resultList.get(i+1).charAt(0))) continue;
				 if(isOperand(resultList.get(i+1)) && isOperator(resultList.get(i).charAt(0))) continue;
				 else result = 0; break;
			 }
			 
			 System.out.println("#"+T+" "+result);
		 }

	}
	
	public static boolean isOperator(Character op){
		if(op == '+' || op == '-' || op == '*' || op == '/'){
			return true;
		} else{
			return false;
		}
	}
	
	public static boolean isOperand(String s){
		try{
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

}

class TreeNode{
	String item;
	TreeNode right;
	TreeNode left;
	
	public TreeNode(){
		this.item = null;
		this.right = null;
		this.left = null;
	}
	
	public TreeNode(String item){
		this.item = item;
		this.right = null;
		this.left = null;
	}
}

class BinaryTree{
	private TreeNode root;
	private ArrayList<String> resultList;
	
	public BinaryTree(){
		resultList = new ArrayList<>();
		root = null;
	}
	
	public TreeNode getRoot(){
		return this.root;
	}
	
	public void addNode(TreeNode node){
		if(this.root == null){
			this.root = node;
		} else {
			Queue<TreeNode> q = new LinkedList<>();
			q.add(this.root);
			
			while(!q.isEmpty()){
				TreeNode tmpNode = q.poll();
				if(tmpNode.left == null){
					tmpNode.left = node; break;
				} else {
					q.add(tmpNode.left);
				}
				
				if(tmpNode.right == null){
					tmpNode.right = node; break;
				} else {
					q.add(tmpNode.right);
				}
				
			}
		}
	}
	
	public void inorder(TreeNode tree){
		if(tree != null){
			inorder(tree.left);
			resultList.add(tree.item);
//			System.out.print(tree.item);
			inorder(tree.right);
		}
	}
	
	public ArrayList<String> getResultList(){
		return resultList;
	}
}