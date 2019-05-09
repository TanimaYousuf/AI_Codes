import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Node implements Comparable<Node> {

	/**
	  @param args
	 */
	int[] colorAssignment;
	Graph G = null;
	double score = 0;
	int numColor = 4;

	public Node(int[] colorAssignment, Graph G) {
		super();
		this.colorAssignment = colorAssignment;
		this.G = G;
		score = this.getScore();
		
	}
	
	public Node(int numVertex, Graph G) {
		super();
		this.colorAssignment = new int[numVertex];
		this.G = G;
		this.score = this.getScore();
		
		for(int i=0;i<this.colorAssignment.length;i++){
			int randomNum = ThreadLocalRandom.current().nextInt(0, numColor);
			this.colorAssignment[i] = randomNum;
		}
	}
	
	//method incomplete
	public double getScore(){
		double score = 0;
		int score_val=0;
		for(int i=0;i<G.adjList.size();i++){
			int curVertex = i;
			ArrayList<Integer> adjacent = G.adjList.get(i);
			
			for(Integer adj:adjacent)
			{
			
					if(colorAssignment[curVertex]==colorAssignment[adj])
					{
						score_val++;
					}
				
		
			//Now calculate mismatch between the curVertex and
			//the elements in adjacent
			}
			}
		score=-1*score_val;
		return score;
	}
	@Override
	public String toString() {
		return "Node [colorAssignment=" + Arrays.toString(colorAssignment)
				+ "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Double.compare(this.score, o.score);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((G == null) ? 0 : G.hashCode());
		result = prime * result + Arrays.hashCode(colorAssignment);
		result = prime * result + numColor;
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (G == null) {
			if (other.G != null)
				return false;
		} else if (!G.equals(other.G))
			return false;
		if (!Arrays.equals(colorAssignment, other.colorAssignment))
			return false;
		if (numColor != other.numColor)
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}

}
