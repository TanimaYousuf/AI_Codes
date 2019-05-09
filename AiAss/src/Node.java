
public class Node {
    int leftMis;
	int leftCan;
	int rightMis;
	int rightCan;
	boolean boat;
	public Node(int leftMis, int leftCan, int rightMis, int rightCan, boolean boat) {
		super();
		this.leftMis = leftMis;
		this.leftCan = leftCan;
		this.rightMis = rightMis;
		this.rightCan = rightCan;
		this.boat = boat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (boat ? 1231 : 1237);
		result = prime * result + leftCan;
		result = prime * result + leftMis;
		result = prime * result + rightCan;
		result = prime * result + rightMis;
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
		if (boat != other.boat)
			return false;
		if (leftCan != other.leftCan)
			return false;
		if (leftMis != other.leftMis)
			return false;
		if (rightCan != other.rightCan)
			return false;
		if (rightMis != other.rightMis)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [leftMis=" + leftMis + ", leftCan=" + leftCan + ", rightMis=" + rightMis + ", rightCan=" + rightCan
				+ ", boat=" + boat + "]";
	} 
	
	 public boolean validNode()
	 {
		 if(leftCan>leftMis && leftMis>0)
		 {
			 return false;
		 }
		 if(rightCan>rightMis && rightMis>0)
		 {
			 return false;
		 }
		 return true;
	 }
	    

	}

