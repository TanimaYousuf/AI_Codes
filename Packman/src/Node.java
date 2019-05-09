

public class Node implements Comparable<Node>{
 
	public int row,col;
    public static final int row_size= 4;
	public static final int col_size = 4;
	public int transfer_so_far;
	public double predicted_transfer;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		long temp;
		temp = Double.doubleToLongBits(predicted_transfer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + row;
		result = prime * result + transfer_so_far;
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
		if (col != other.col)
			return false;
		if (Double.doubleToLongBits(predicted_transfer) != Double.doubleToLongBits(other.predicted_transfer))
			return false;
		if (row != other.row)
			return false;
		if (transfer_so_far != other.transfer_so_far)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [row=" + row + ", col=" + col + ", transfer_so_far=" + transfer_so_far + ", predicted_transfer="
				+ predicted_transfer + "]";
	}
	public Node(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public Node(int row, int col, int transfer_so_far) {
		super();
		this.row = row;
		this.col = col;
		this.transfer_so_far = transfer_so_far;
	}
	public boolean isValid(){
		if((row>=0) && (row<row_size) && (col>=0) && (col<col_size)){
			return true;
		}
		return false ;
	}
	public boolean getBlocked(int p[][],int r,int c){
		if(p[r][c]==0){
			return true ;			
		}
		else{
			return false ;
		}
	}
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		double ownPriority = this.transfer_so_far + this.predicted_transfer;
		double otherPriority = o.transfer_so_far + o.predicted_transfer;
		
		return Double.compare(ownPriority, otherPriority);
	}

}
