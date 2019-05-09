


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	
	public Node startNode(){
		
		Node stNode = new Node(3,3,0,0,true,0);
		stNode.predicted_transfer=simpleHeuristics(stNode);
		return stNode;
		
	}
	public boolean reachedDestination(Node curNode){
		
		if(curNode.leftCan==0 && curNode.leftMis==0 && curNode.rightCan==3 && curNode.rightMis==3 && curNode.boat==false){
			return true;
		}else{
			return false;
		}
	}
	public int simpleHeuristics(Node curNode) {
		// TODO Auto-generated method stub
		if(curNode.leftCan==0 && curNode.leftMis==0)
		{
			return 0;
		}
		else
		{
		int totleft=curNode.leftCan+curNode.leftMis;
		int Transfer = totleft/2;
		return Transfer;
		}
	}

	
	public ArrayList<Node> getNeighbours(Node s){
		
		ArrayList<Node> neighbours = new ArrayList<Node>();
    	//left move
    	if(s.boat==true && s.validNode()){
   
    		if(s.leftMis>0)
    		{
    			int t=s.transfar_so_far+1;
    			Node n1=(new Node(s.leftMis-1, s.leftCan, s.rightMis+1, s.rightCan,false,t));
    		    n1.predicted_transfer=simpleHeuristics(n1);
    		    neighbours.add(n1);
    		}
    		if(s.leftCan>0)
    		{
    			int t=s.transfar_so_far+1;
	    	    Node n2=(new Node(s.leftMis, s.leftCan-1, s.rightMis, s.rightCan+1,false,t));
    		    n2.predicted_transfer=simpleHeuristics(n2);
	    	    neighbours.add(n2);
    		}
    		if(s.leftMis>1)
    		{
    			int t=s.transfar_so_far+2;
	    	    Node n3=(new Node(s.leftMis-2, s.leftCan, s.rightMis+2, s.rightCan,false,t));
	    	    n3.predicted_transfer=simpleHeuristics(n3);
	    	    neighbours.add(n3);
    		}
    		if(s.leftCan>1)
    		{   int t=s.transfar_so_far+2;
	    		Node n4=(new Node(s.leftMis, s.leftCan-2, s.rightMis, s.rightCan+2,false,t));
    		    n4.predicted_transfer=simpleHeuristics(n4);
	    		neighbours.add(n4);
    		}
	    	 if(s.leftMis>0 && s.leftCan>0)
	    	{
	    	int t=s.transfar_so_far+2;
	    	Node n5=(new Node(s.leftMis-1, s.leftCan-1, s.rightMis+1, s.rightCan+1,false,t));
    	    n5.predicted_transfer=simpleHeuristics(n5);
	    	neighbours.add(n5);
	    	}
	    	
    	}
    	else{    	
	    	//right move
           if(s.validNode())
           {	
    			if(s.rightMis>0)
    		{       
    				int t=s.transfar_so_far+1;
    				Node n1=(new Node(s.leftMis+1, s.leftCan, s.rightMis-1, s.rightCan,true,t));
    				n1.predicted_transfer=simpleHeuristics(n1);
    				neighbours.add(n1);
    		}
    		    if(s.rightCan>0)
    		{
    		    	int t=s.transfar_so_far+1;
    				Node n2=(new Node(s.leftMis, s.leftCan+1, s.rightMis, s.rightCan-1,true,t));
    		        n2.predicted_transfer=simpleHeuristics(n2);
    				neighbours.add(n2);
    		}
    			if(s.rightMis>1)
    		{
    				int t=s.transfar_so_far+2;
    				Node n3=(new Node(s.leftMis+2, s.leftCan, s.rightMis-2, s.rightCan,true,t));
    		        n3.predicted_transfer=simpleHeuristics(n3);
    				neighbours.add(n3);
    		}
    			if(s.rightCan>1)
    		{
    				int t=s.transfar_so_far+2;
    				Node n4=(new Node(s.leftMis, s.leftCan+2, s.rightMis, s.rightCan-2,true,t));
    		        n4.predicted_transfer=simpleHeuristics(n4);
    				neighbours.add(n4);
    		}
    			if(s.rightCan>0 && s.rightMis>0)
    		{
    				int t=s.transfar_so_far+2;
    				Node n5=(new Node(s.leftMis+1, s.leftCan+1, s.rightMis-1, s.rightCan-1,true,t));
    		        n5.predicted_transfer=simpleHeuristics(n5);
    				neighbours.add(n5);
    		}
           }
    	}
    	return neighbours;
	}
	
}

