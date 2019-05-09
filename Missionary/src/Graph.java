
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	
	public Node startNode(){
		
		Node stNode = new Node(3,0,3,0,0);
		
		return stNode;
		
	}
	
	public ArrayList<Node> getNeighbours(Node s){
		
		ArrayList<Node> neighbours = new ArrayList<Node>();
    	//left move
    	if(s.boat==0 && s.isValid()){
   
    		if(s.Cleft>0)
    		{
    			neighbours.add(new Node(s.Cleft-1, s.Cright+1, s.Mleft, s.Mright,1));
    		}
    		if(s.Mleft>0)
    		{
	    	neighbours.add(new Node(s.Cleft, s.Cright, s.Mleft-1, s.Mright+1,1));
    		}
    		if(s.Cleft>1)
    		{
	    	neighbours.add(new Node(s.Cleft-2, s.Cright+2, s.Mleft, s.Mright,1));
    		}
    		if(s.Mleft>1)
    		{
	    		neighbours.add(new Node(s.Cleft, s.Cright, s.Mleft-2, s.Mright+2,1));
    		}
	    	 if(s.Cleft>0 && s.Mleft>0)
	    	{
	    	neighbours.add(new Node(s.Cleft-1, s.Cright+1, s.Mleft-1, s.Mright+1,1));
    	     }
	    	
    	}
    	else{    	
	    	//right move
           if(s.isValid())
           {	
    			if(s.Cright>0)
    		{
    				neighbours.add(new Node(s.Cleft+1, s.Cright-1, s.Mleft, s.Mright,0));
    		}
    		    if(s.Mright>0)
    		{
    				neighbours.add(new Node(s.Cleft, s.Cright, s.Mleft+1, s.Mright-1,0));
    		}
    			if(s.Cright>1)
    		{
    				neighbours.add(new Node(s.Cleft+2, s.Cright-2, s.Mleft, s.Mright,0));
    		}
    			if(s.Mright>1)
    		{
    				neighbours.add(new Node(s.Cleft, s.Cright,s.Mleft+2,s.Mright-2,0));
    		}
    			if(s.Cright>0 && s.Mright>0)
    		{
    				neighbours.add(new Node(s.Cleft+1, s.Cright-1, s.Mleft+1, s.Mright-1,0));
    		}
           }
    	}
    	return neighbours;
	}
	
}
