
public class Node {
	int Cleft, Cright, Mleft, Mright, boat;

	public Node(int cleft, int cright, int mleft, int mright, int boat) {
		super();
		Cleft = cleft;
		Cright = cright;
		Mleft = mleft;
		Mright = mright;
		this.boat = boat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cleft;
		result = prime * result + Cright;
		result = prime * result + Mleft;
		result = prime * result + Mright;
		result = prime * result + boat;
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
		if (Cleft != other.Cleft)
			return false;
		if (Cright != other.Cright)
			return false;
		if (Mleft != other.Mleft)
			return false;
		if (Mright != other.Mright)
			return false;
		if (boat != other.boat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [Cleft=" + Cleft + ", Cright=" + Cright + ", Mleft=" + Mleft + ", Mright=" + Mright + ", boat="
				+ boat + "]";
	}
	 public boolean isValid(){
	    	
			if(Cleft>Mleft&&Mleft>0){
				return false;
			}
			if(Cright>Mright&&Mright>0){
				return false;
			}

			return true ;	
	    	
	    }
	    
	    
	
}