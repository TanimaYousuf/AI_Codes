import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class A_Star {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[][]={
				{0,0,0,0},
				{0,0,1,0},
				{1,1,1,0},
				{0,0,0,0}
				};	
		Graph g = new Graph();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		HashSet<Node> marked = new HashSet<Node>();
		HashMap<Node,Node> bp = new HashMap<Node,Node>();
		Node stNode=new Node(0,0);
		Node goalNode=new Node(3,0);
        stNode.predicted_transfer=g.manHeuristics(stNode,goalNode);
     	pq.add(stNode);
		marked.add(stNode);
		bp.put(stNode, null);
		
		Node finalNode = null;
		
		while(pq.isEmpty() == false){
			Node u = pq.poll();
			if(g.isDestination(u,goalNode)==0){
				finalNode = u;
				System.out.println("Reached!!!!");
				System.out.println("Distance" + finalNode.transfer_so_far);
				break;
			}
			
			
			ArrayList<Node> neighbours = g.getNeighbours(u,goalNode,p);
			for(int i=0;i<neighbours.size();i++){
				Node v = neighbours.get(i);
				
				if( marked.contains(v) == false){
					pq.add(v);
					marked.add(v);
					bp.put(v, u);
				}
				
			}
		}
		
		if(finalNode == null){
			System.out.println("Failed!!!!");
		}else{
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

}
