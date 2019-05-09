
import java.io.*;
import java.util.*;
 

class Graph
{
	static class State implements Comparable<State>{
		
		int Cleft, Cright, Mleft, Mright, boat;
		
		public State(int CLeft, int CRight,int MLeft,int MRight,int boat){
			this.Cleft=CLeft;
			this.Cright = CRight ;
			this.Mleft = MLeft;
			this.Mright = MRight;
			this.boat=boat;//left=0,right=1
		}
		
		public int compareTo(State other){
			
			if(Cleft<other.Cleft){return -1 ;}
			if(Cleft>other.Cleft){return 1;}
			

			if(Mleft<other.Mleft){return -1 ;}
			if(Mleft>other.Mleft){return 1;}

			if(Cright<other.Cright){return -1 ;}
			if(Cright>other.Cright){return 1;}

			if(Mright<other.Mright){return -1 ;}
			if(Mright>other.Mright){return 1;}

			if(boat<other.boat){return -1 ;}
			if(boat>other.boat){return 1;}
			

			
			return 0;
		}
		public String toString(){
			return "\n\n"+Cleft+"C"+Mleft+"M"+"-----"+Cright+"C"+Mright+"M";
		}
	}
      
    Graph()
    {
       
    }
 
  
 

    void BFS(State start, State goal)
    {
    	System.out.println(goal.toString());
    	TreeMap<State, State> parent = new TreeMap<>();
        Queue<State> queue = new LinkedList<State>();
        parent.put(start, start);
        queue.add(start);
        
        while (queue.size() != 0)
        {
           
            State s = queue.poll();
            //path:
           //System.out.println(s.toString());
           
            if(s.compareTo(goal) == 0){ break;}
            
            Iterator<State> i = getAdj(s).listIterator();
       
            while (i.hasNext())
            {	            	
            	State n = i.next();
            	// System.out.println("\n\n n = "+n.Cleft+"C"+n.Mleft+"M"+"-----"+n.Cright+"C"+n.Mright+"M" + "isValid=" + isValid(n));
                 
                if (isValid(n) && parent.containsKey(n) == false)
                {
                	
                	parent.put(n, s);
                    queue.add(n);
                }
            }
        }
        System.out.println("Path: ");
        List<String> path = new LinkedList<>();
        for(State s = goal; s != start; s = parent.get(s)){
        	path.add(s.toString());
        }
        path.add(start.toString());
        Collections.reverse(path);
        for(String s: path){
        	System.out.println(s);
        }
    }
    
   public boolean isValid(State s){
    	
		if((s.Cleft>s.Mleft&&s.Mleft>0) || s.Cleft<0 || s.Mleft<0 || s.Cleft > 3 || s.Mleft > 3){
			return false;
		}
		if((s.Cright>s.Mright&&s.Mright>0) || s.Cright<0 || s.Mright<0 || s.Cright > 3 || s.Mright > 3){
			return false;
		}
		
		return true ;	
    	
    }
    
   
  
    public List<State> getAdj(State s){
    	
    	LinkedList<State> l = new LinkedList<State>();
    	//left move
    	if(s.boat==0){
	    	l.add(new State(s.Cleft-1, s.Cright+1, s.Mleft, s.Mright,1));
	    	l.add(new State(s.Cleft, s.Cright, s.Mleft-1, s.Mright+1,1));
	    	l.add(new State(s.Cleft-2, s.Cright+2, s.Mleft, s.Mright,1));
	    	l.add(new State(s.Cleft, s.Cright, s.Mleft-2, s.Mright+2,1));
	    	l.add(new State(s.Cleft-1, s.Cright+1, s.Mleft-1, s.Mright+1,1));
    	}else{    	
	    	//right move
	    	l.add(new State(s.Cleft+1, s.Cright-1, s.Mleft, s.Mright,0));
	    	l.add(new State(s.Cleft, s.Cright, s.Mleft+1, s.Mright-1,0));
	    	l.add(new State(s.Cleft+2, s.Cright-2, s.Mleft, s.Mright,0));
	    	l.add(new State(s.Cleft, s.Cright, s.Mleft+2, s.Mright-2,0));
	    	l.add(new State(s.Cleft+1, s.Cright-1, s.Mleft+1, s.Mright-1,0));
    	}
    	return l;
    }
    
    public static void main(String args[])
    {
        Graph g = new Graph();
        State start = new State(3,0,3,0,0);
        State goal = new State(0,3,0,3,1);
        g.BFS(start,goal);
        
    }
}