import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BFS {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		Queue<Node> q = new LinkedList<Node>();
		HashSet<Node> marked = new HashSet<Node>();
		//HashMap<Node,Integer> dist = new HashMap<Node, Integer>();
		HashMap<Node,Node> bp = new HashMap<Node,Node>();
		
		Node stNode = g.startNode(); 
		Node goalNode=new Node(0,3,0,3,1);
		q.add(stNode);
		marked.add(stNode);
		//dist.put(stNode, 0);
		bp.put(stNode, null);
		
		Node finalNode = null;
		
		while(q.isEmpty() == false){
			Node u = q.poll();
			
			if(stNode.equals(goalNode)){
				finalNode = u;
				System.out.println("Reached!!!!");
				//System.out.println("Distance" + dist.get(u));
				break;
			}
			
			ArrayList<Node> neighbours = g.getNeighbours(u);
			for(int i=0;i<neighbours.size();i++){
				Node v = neighbours.get(i);
				finalNode=v;
				if(marked.contains(v) == false){
					q.add(v);
					marked.add(v);
					bp.put(v, u);
				}
				
			}
		}
		
			Node curNode = finalNode;
			Stack<Node> path  = new Stack<Node>();
			while(curNode != null){
				path.add(curNode);
				
				Node parent = bp.get(curNode);
				curNode = parent;
			}
			
			while(path.isEmpty() == false){
				System.out.println(path.pop().toString());
			}
		}
		
		
	}

