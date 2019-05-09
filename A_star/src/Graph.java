import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Scanner;


public class Graph {
	int targetMeasure;
	
	public Node startNode(){
		Scanner in = new Scanner(System.in);
		System.out.println("enter cap:");
		int jug1Cap = in.nextInt();
		int jug2Cap = in.nextInt();
		System.out.println("enter goal:");
		targetMeasure = in.nextInt();
		
		Node stNode = new Node(jug1Cap,jug2Cap,0,0,0);
		stNode.predictedWaterTransfer = simpleHeuristics(stNode);
		
		return stNode;
		
	}
	
	private int simpleHeuristics(Node curNode) {
		// TODO Auto-generated method stub
		int totWatAtHand = curNode.jug1Cur + curNode.jug2Cur;
		int neededToTransfer = Math.abs(targetMeasure - totWatAtHand);
		return neededToTransfer;
	}

	public boolean reachedDestination(Node curNode){
		int totWaterAtHand = curNode.jug1Cur + curNode.jug2Cur;
		
		if(totWaterAtHand == targetMeasure){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Node> getNeighbours(Node curNode){
		
		ArrayList<Node> neighbours = new ArrayList<Node>();
		
		//empty jug1
		int totTrans1 = curNode.waterTransferredSoFar + curNode.jug1Cur;
		Node nei1 = new Node(0,curNode.jug2Cur,totTrans1);
		nei1.predictedWaterTransfer = simpleHeuristics(nei1);
		neighbours.add(nei1);
		
		//empty jug2
		int totTrans2 = curNode.waterTransferredSoFar + curNode.jug2Cur;
		Node nei2 = new Node(curNode.jug1Cur,0,totTrans2);
		nei2.predictedWaterTransfer = simpleHeuristics(nei2);
		neighbours.add(nei2);
		
		//fill up jug1
		int totTrans3 = curNode.waterTransferredSoFar + (curNode.jug1Cap - curNode.jug1Cur);
		Node nei3 = new Node(curNode.jug1Cap,curNode.jug2Cur,totTrans3);
		nei3.predictedWaterTransfer = simpleHeuristics(nei3);
		neighbours.add(nei3);
		
		int totTrans4 = curNode.waterTransferredSoFar + (curNode.jug2Cap - curNode.jug2Cap);
		Node nei4 = new Node(curNode.jug1Cur,curNode.jug2Cap,totTrans4);
		nei4.predictedWaterTransfer = simpleHeuristics(nei4);
		neighbours.add(nei4);
		
		return neighbours;
	}
}
