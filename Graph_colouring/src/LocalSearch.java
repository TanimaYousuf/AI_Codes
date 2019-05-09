import java.util.*;

public class LocalSearch {

	private static final int ArrayList = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G  = new Graph();
		int numColor = 4;
		
		Node stNode = G.startNode();
		simulatedAnnealing();
		beamSearch();
		
		System.out.println(stNode.toString());
		
	}

		public static void simulatedAnnealing() {
			// TODO Auto-generated method stub
			Graph G = new Graph();
			Node stNode = G.startNode();
			Node curNode = stNode;
			
			int temperature = 10000;
			
			int tempCounter = 0;
			
			while(temperature > 0){
				ArrayList<Node> neighbours = G.neighbourList(curNode);
				
				int bestIndex = findBestNei(neighbours);
				
				Node bestNeighbour = neighbours.get(bestIndex);
				
				if(bestNeighbour.score > curNode.score){
					curNode = bestNeighbour;
				}else{
					double delE = curNode.score - bestNeighbour.score;
					double expo = -1*(delE/temperature);
					double crossPoint = Math.exp(expo);
					
					double randomDraw = Math.random();
					if(randomDraw < crossPoint){
						curNode = bestNeighbour;
					}
					
				}
				
				if(tempCounter == 5){
					temperature --;
					tempCounter = 0;
				}else{
					tempCounter++;
				}
				
				
			}
			//System.out.println(curNode.toString());
			
			
		}

		private static int findBestNei(ArrayList<Node> neighbours) {
			// TODO Auto-generated method stub
			int bestIndex = 0;
			
			for(int i=1;i<neighbours.size();i++){
				if(neighbours.get(i).score > neighbours.get(bestIndex).score){
					bestIndex = i;
				}
			}
			return bestIndex;
		}
		



	
private static void beamSearch() {
	// TODO Auto-generated method stub
	Graph G = new Graph();
	Node stNode = G.startNode();
	
	ArrayList<Node> bestSols = new ArrayList<>();
	bestSols.add(stNode);
	int numBestSolsStored = 20;
	
	int numIter = 10000;
	Node globalBest = null;
	
	for(int i=0;i<numIter;i++){
		if(bestSols.isEmpty()){
			break;
		}
		
		Node curBest = bestSols.remove(bestSols.size()-1);
		if(globalBest == null || curBest.score > globalBest.score){
			globalBest = curBest;
		}
		if(curBest.score == 0){
			break;
		}
		
		ArrayList<Node> neighbours = G.neighbourList(curBest);
		
		for(int j=0;j<neighbours.size();j++){
			Node curNei = neighbours.get(j);
			if(bestSols.contains(curNei)){
				continue;
			}
			
			if(bestSols.size() < numBestSolsStored){
				bestSols.add(curNei);
				Collections.sort(bestSols);
			}else{
				if(curNei.score > bestSols.get(0).score){
					bestSols.remove(0);
					bestSols.add(curNei);
					Collections.sort(bestSols);
				}
			}
		}
	}
	
	System.out.println(globalBest.toString());
}}
