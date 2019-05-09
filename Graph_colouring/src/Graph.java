import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;


public class Graph {
	
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    int numVertex = 0;
    int numColor = 4;
	public Graph() {
		super();
		// TODO Auto-generated constructor stub
		int counter = -1;
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
		    String line = null;
		   
		    while ((line = br.readLine()) != null) {
		       // process the line.
		       if(counter == -1){
		    		   numVertex = Integer.parseInt(line);
		    	   }else{
		    		   ArrayList<Integer> neigh = new ArrayList<Integer>();
		    		   for( String str : line.split(" ")){
				    	   neigh.add(Integer.parseInt(str));
				       }
		    		   
		    		   adjList.add(neigh);
		    		   
		    	   }
		       counter++;
		       
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(adjList.toString());
	}

    
	public Node startNode(){
		Node stNode = new Node(numVertex, this);
		return stNode;
	}
	
	//Method is incomplete
	@SuppressWarnings("unchecked")
	public ArrayList<Node> neighbourList(Node cur){
		ArrayList<Node> neighbours = new ArrayList<Node>();
		
		int numNeighbours = 20;
		
		for(int i=0;i<numNeighbours;i++){
			int[] copyColorAssign = Arrays.copyOf(cur.colorAssignment,cur.colorAssignment.length);
			//change the assignment slightly to form a new neighbour
			//add to the neighbours list
			int randIndex = (int) Math.floor(Math.random() * copyColorAssign.length);
			int randVal = ThreadLocalRandom.current().nextInt(0, numColor);
			//int randVal = (int) Math.floor(Math.random() * copyColorAssign.length);
			copyColorAssign[randIndex] = randVal;
			
			neighbours.add(new Node(copyColorAssign,this));
		}
		return neighbours;
	}
	
	
}

