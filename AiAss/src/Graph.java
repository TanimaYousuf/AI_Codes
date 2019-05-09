
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	
	public Node startNode(){
		
		Node stNode = new Node(3,3,0,0,true);
		
		return stNode;
		
	}
	
	public ArrayList<Node> getNeighbours(Node s){
		
		ArrayList<Node> neighbours = new ArrayList<Node>();
  
	 if(s.boat==true && s.validNode()){
   if(s.leftMis>0)
   {     neighbours.add(new Node(s.leftMis-1, s.leftCan, s.rightMis+1, s.rightCan,false));
   
   }
   if(s.leftMis>=2)
   {
            neighbours.add(new Node(s.leftMis-2, s.leftCan, s.rightMis+2, s.rightCan,false));
   }
   if(s.leftCan>0)
   {
	   neighbours.add(new Node(s.leftMis, s.leftCan-1, s.rightMis, s.rightCan+1,false));
	   }
   if(s.leftCan>=2)
   {
	    	neighbours.add(new Node(s.leftMis, s.leftCan-2, s.rightMis, s.rightCan+2,false));
   }
   if(s.leftMis>0 && s.leftCan>0)
   {
	   neighbours.add(new Node(s.leftMis-1, s.leftCan-1, s.rightMis+1, s.rightCan+1,false));
   }
    	     }
	    	
    
    	else 
    	{
       if(s.validNode())
    	{
    	   if(s.rightMis>0)
    	{
    		   neighbours.add(new Node(s.leftMis+1, s.leftCan, s.rightMis-1, s.rightCan,true));
    	}
    	   if(s.rightMis>=2)
    	   {
    	neighbours.add(new Node(s.leftMis+2, s.leftCan, s.rightMis-2, s.rightCan,true));
    	   }
    	   if(s.rightCan>0)
    	{
    		   neighbours.add(new Node(s.leftMis, s.leftCan+1, s.rightMis, s.rightCan-1,true));
    	}
    	   if(s.rightCan>=2)
    	{
    		   neighbours.add(new Node(s.leftMis, s.leftCan+2, s.rightMis, s.rightCan-2,true));
    	}
    	   if(s.rightMis>0 && s.rightCan>0)
    	   {
    		   
    	neighbours.add(new Node(s.leftMis+1, s.leftCan+1, s.rightMis-1, s.rightCan-1,true));
    	}
    	}
    	}
    	return neighbours;
	}
	
	
}
