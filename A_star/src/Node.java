public class Node implements Comparable<Node>{
    public static int jug1Cap;
	public static int jug2Cap;
	
	public int jug1Cur;
	public int jug2Cur;
	
	public int waterTransferredSoFar;
	public int predictedWaterTransfer;
	
	public Node(int jug1Cap, int jug2Cap, int jug1Cur, int jug2Cur,
			int waterTransferredSoFar) {
		super();
		this.jug1Cap = jug1Cap;
		this.jug2Cap = jug2Cap;
		this.jug1Cur = jug1Cur;
		this.jug2Cur = jug2Cur;
		this.waterTransferredSoFar = waterTransferredSoFar;
	}


	public Node(int jug1Cur, int jug2Cur, int waterTransferredSoFar) {
		super();
		this.jug1Cur = jug1Cur;
		this.jug2Cur = jug2Cur;
		this.waterTransferredSoFar = waterTransferredSoFar;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jug1Cur;
		result = prime * result + jug2Cur;
		result = prime * result + predictedWaterTransfer;
		result = prime * result + waterTransferredSoFar;
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
		if (jug1Cur != other.jug1Cur)
			return false;
		if (jug2Cur != other.jug2Cur)
			return false;
		if (predictedWaterTransfer != other.predictedWaterTransfer)
			return false;
		if (waterTransferredSoFar != other.waterTransferredSoFar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [jug1Cur=" + jug1Cur + ", jug2Cur=" + jug2Cur
				+ ", waterTransferredSoFar=" + waterTransferredSoFar
				+ ", predictedWaterTransfer=" + predictedWaterTransfer + "]";
	}


	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		int ownPriority = this.waterTransferredSoFar + this.predictedWaterTransfer;
		int otherPriority = o.waterTransferredSoFar + o.predictedWaterTransfer;
		
		return Double.compare(ownPriority, otherPriority);
	}
	
	
	
	

}
