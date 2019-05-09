
import java.util.*;
import java.math.*;


public class Pacman {
	static class Node implements Comparable<Node>{
		public int xPosition,yPosition;
		public double f,g,h ;
		protected static final int ROW = 4;
		protected static final int COL = 4;
		protected static final int MOVEMENT_COST = 1;

		public Node(int xPosition, int yPosition) {
			super();
			this.xPosition = xPosition;
			this.yPosition = yPosition;
		}
		
		public int getX(){
			return this.xPosition;
		}
		public int getY(){
			return this.yPosition;
		}
		
		public boolean isValid(){
			if((xPosition>=0) && (xPosition<ROW) && (yPosition>=0) && (yPosition<COL)){
				return true;
			}
			return false ;
		}
		
		public boolean isUnblocked(int grid[][],int row,int col){
			if(grid[row][col]==0){
				return true ;//0->unblocked,1->blocked				
			}
			else{
				return false ;
			}
		}
		
		public int isDestination(Node node){
			if((this.xPosition==node.xPosition) && (this.yPosition==node.yPosition)){
				return 0;//same
			}
			return 1;//not same
		}
		
		public double calculateH(Node node1){
			return (double)(Math.sqrt((Math.pow((xPosition-node1.xPosition),2)+
					Math.pow((yPosition-node1.yPosition),2))));	
		}
		
		public int calculateG(int depth){
			return (depth+MOVEMENT_COST);
		}
		
		public double getF(Node child,Node goal,int depth){
			return ((child.calculateG(depth))+(child.calculateH(goal)));
		}
		
		public void setG(double gNew){
			this.g = gNew;
		}

		public void setF(double fNew){
			this.f = fNew;
		}

		@Override
		public int compareTo(Node node) {
			if(xPosition<node.xPosition){return -1;}
			
			if(yPosition<node.yPosition){return -1;}
			
			if(xPosition>node.xPosition){return 1;}
			
			if(yPosition>node.yPosition){return 1;}
			
			return 0;
		}
		
		public String toString(){
			return "\n\n"+xPosition+"->"+yPosition;
		}
		
	}//end class node
	
	
	
	
	public static void aStarSearch(int grid[][],Node start,Node goal){
		
		int depth = 0 ;
		double fNew,gNew,hNew ;
		TreeMap<Node,Node> parent = new TreeMap<>();
		Set<Node> explored = new HashSet<Node>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(
                );//queue
        
        start.g=0.0;
        parent.put(start, start);
        queue.add(start);
        boolean goalFound = false;
        
        while((!queue.isEmpty())&&(!goalFound)){
        	
        	Node current = queue.poll();
        	explored.add(current);
        	
        	if(current.isDestination(goal)==0){
        		goalFound = true;
        	}
        	
        	Iterator<Node> i = getAdj(current).listIterator();
        	if(i.hasNext() && explored.contains(current) ){
        		depth++;
        		//System.out.println(depth);
            }
        	while(i.hasNext()){
        		Node child = i.next();
        		if(child.isValid()==true){
        			if(child.isDestination(goal)==0){
        				parent.put(child,current);
        				System.out.println("found");
        				goalFound = true ;
        			}else{
        				if(child.isUnblocked(grid,child.xPosition,child.yPosition)==true &&
        						!(explored.contains(child))){
        					gNew = current.g+Node.MOVEMENT_COST;
        					hNew = child.calculateH(goal);
        					fNew = gNew + hNew ;
        					
        					if(child.getF(child,goal,depth)>fNew){
        						
        						queue.add(child);
        						parent.put(child, current);
        						child.setG(gNew);
        						child.setF(fNew);
        					}
        					
        				}
        			}//destination check
        		}//valid check
        	}
        	
        }
    /*    List<String> path = new LinkedList<>();
        for(Node s = goal; s != start; s = parent.get(s)){
        	path.add(s.toString());
        }
        path.add(start.toString());
        Collections.reverse(path);
        for(String s: path){
        	System.out.println(s);
        }
		if(goalFound==false){
			System.out.print("Failed to find the Destination");
		}*/
	}//end aStarSearch()
	
	

	public static List<Node> getAdj(Node node){
		int row = node.xPosition;
		int col = node.yPosition;		
		LinkedList<Node> adj = new LinkedList<Node>();
		
		adj.add(new Node((row-1),(col)));//up
		adj.add(new Node((row+1),(col)));//down
		adj.add(new Node((row),(col-1)));//left
		adj.add(new Node((row),(col+1)));//right
		return adj;
	}


	public static void main(String[] args) {
		
/*		
		0->unblocked
		1->blocked
		
*/	
		int grid[][]={
				{0,0,0,0},
				{0,0,1,0},
				{1,1,1,0},
				{0,0,0,0}
				};	
		
		Node start = new Node(0,3);
		Node goal = new Node(3,0);
		
		aStarSearch(grid,start,goal);		
		
	}//main

}//end class pacman
