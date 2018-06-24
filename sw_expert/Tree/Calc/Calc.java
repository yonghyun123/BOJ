package sw_expert.Tree.Calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Calc {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		 int T = 0;
		 
		 while(T++ < 10){
			 BinaryTree rootTree = new BinaryTree();
			 Stack<Double> st = new Stack<>();
			 ArrayList<String> resultList;
			 Queue<Integer> inputQ = new LinkedList<>();
			 ArrayList<Map<Integer,Character>> opList = new ArrayList<>();
			 
			 int numOfNode = sc.nextInt();
			 sc.nextLine();
			 String[] tempInput = sc.nextLine().split(" ");
			 if(tempInput[2] != null && tempInput[3] != null){
				 inputQ.add(Integer.parseInt(tempInput[2]));
				 inputQ.add(Integer.parseInt(tempInput[3]));
			 }
			 TreeNode tmpNode = new TreeNode(tempInput[1]);
			 rootTree.addNode(tmpNode);
			 
			 for(int i = 0; i < numOfNode-1; i++){
				 String[] input = sc.nextLine().split(" ");
				 if(Integer.parseInt(input[0]) == inputQ.peek()){
					 //pop 시켜야하고
					 //q에도 넣어줘야해
					 inputQ.poll();
					 if(input[2] != null && input[3] != null){
						 inputQ.add(Integer.parseInt(input[2]));
						 inputQ.add(Integer.parseInt(input[3]));
					 }
					 TreeNode node = new TreeNode(input[1]);
					 rootTree.addNode(node);
				 }
				 //다르면 
				 else {
					 int nodeNum = Integer.parseInt(input[0]);
					 char op = input[1].charAt(0);
					 Map<Integer,Character> temp = new HashMap<>();
					 //oplist에 
					 for(Map<Integer, Character> item: opList){
						 if(item.containsKey(inputQ.peek())){
							 TreeNode node = new TreeNode(item.get(inputQ.peek()).toString());
							 rootTree.addNode(node);
							 opList.remove(inputQ.peek());
							 inputQ.poll();
						 } 
					 }
					 temp.put(nodeNum, op);
					 opList.add(temp);
					 if(input[2] != null && input[3] != null){
						 inputQ.add(Integer.parseInt(input[2]));
						 inputQ.add(Integer.parseInt(input[3]));
					 }
				 }
			 }
			 
			 rootTree.postorder(rootTree.getRoot());
			 System.out.println();
			 resultList = rootTree.getResultList();
			 
			 for(int i = 0; i < resultList.size(); i++){
				 if(isOperator(resultList.get(i).charAt(0))){
					 double op1 = st.pop();
					 double op2 = st.pop();
					 
					 switch(resultList.get(i).charAt(0)){
						 case '+' : st.push(op2 + op1); break;
						 case '-' : st.push(op2 - op1); break;
						 case '*' : st.push(op2 * op1); break;
						 case '/' : st.push(op2 / op1); break;
						 default: break;
					 }
				 } else {
					 st.push(Double.parseDouble(resultList.get(i)));
				 }
			 }
			 System.out.println(st.peek());
			 
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
	
	public void postorder(TreeNode tree){
		if(tree != null){
			postorder(tree.left);
			postorder(tree.right);
			resultList.add(tree.item);
//			System.out.print(tree.item);
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