import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
		public double manHeuristics(Node curNode,Node goalNode) {
			// TODO Auto-generated method stub
			double transfer=Math.abs((curNode.row-goalNode.row)+(curNode.col-goalNode.col)); 
		   return transfer;
		}
		
		
		public int isDestination(Node curnode,Node goalnode){
			if((curnode.row==goalnode.row) && (curnode.col==goalnode.col)){
				return 0;//same
			}
			return 1;//not same
		}
		public ArrayList<Node> getNeighbours(Node s,Node g,int p[][]){
			int k = 0;
			int row = s.row;
			int col = s.col;	
			int sum=s.transfer_so_far;
			ArrayList<Node> neighbours = new ArrayList<Node>();
			if(s.isValid())
			{	if(s.getBlocked(p, s.row-1, s.col)==false)
			{
				int i=1;
				while(s.isValid() && s.getBlocked(p,s.row-1, s.col)==true)
				{
					sum=sum+i;
					s.row=row-i;
	                i++;
				}
			}
			Node n1=new Node(s.row,col,sum);//up
			n1.predicted_transfer=manHeuristics(n1,g);
			neighbours.add(n1);
			if(s.getBlocked(p, s.row+1, s.col)==false)
			{
				int i=1;
				while(s.isValid() && s.getBlocked(p,s.row+1, s.col)==true)
				{
					sum=sum+i;
					s.row=row+i;
	                i++;
				}
			}
			Node n2=new Node(s.row,col,sum);//down
			n2.predicted_transfer=manHeuristics(n2,g);
			neighbours.add(n2);
			if(s.getBlocked(p, s.row, s.col-1)==false)
			{
				int i=1;
				while(s.isValid() && s.getBlocked(p,s.row, s.col-1)==true)
				{
					sum=sum+i;
					s.col=col-i;
	                i++;
				}
			}
			Node n3=new Node(row,s.col,sum);//left
			n3.predicted_transfer=manHeuristics(n3,g);
			neighbours.add(n3);
			if(s.getBlocked(p, s.row, s.col+1)==false)
			{
				int i=1;
				while(s.isValid() && s.getBlocked(p,s.row, s.col+1)==true)
				{
					sum=sum+i;
					s.col=col+i;
	                i++;
				}
			}
			Node n4=new Node(row,s.col,sum);//right
			n4.predicted_transfer=manHeuristics(n4,g);
			neighbours.add(n4);
			}
			return neighbours;
		

	}
	}