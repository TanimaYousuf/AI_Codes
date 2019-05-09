
public class Node implements Comparable<Node>{
	    int leftMis;
		int leftCan;
		int rightMis;
		int rightCan;
		boolean boat;
	    int transfar_so_far;
	    int predicted_transfer;
		@Override
		public String toString() {
			return "Node [leftMis=" + leftMis + ", leftCan=" + leftCan + ", rightMis=" + rightMis + ", rightCan="
					+ rightCan + ", boat=" + boat + ", transfar_so_far=" + transfar_so_far + ", predicted_transfer="
					+ predicted_transfer + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (boat ? 1231 : 1237);
			result = prime * result + leftCan;
			result = prime * result + leftMis;
			result = prime * result + predicted_transfer;
			result = prime * result + rightCan;
			result = prime * result + rightMis;
			result = prime * result + transfar_so_far;
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
			if (predicted_transfer != other.predicted_transfer)
				return false;
			if (rightCan != other.rightCan)
				return false;
			if (rightMis != other.rightMis)
				return false;
			if (transfar_so_far != other.transfar_so_far)
				return false;
			return true;
		}
		public Node(int leftMis, int leftCan, int rightMis, int rightCan, boolean boat) {
			super();
			this.leftMis = leftMis;
			this.leftCan = leftCan;
			this.rightMis = rightMis;
			this.rightCan = rightCan;
			this.boat = boat;
		}
		public Node(int leftMis, int leftCan, int rightMis, int rightCan, boolean boat, int transfar_so_far) {
			super();
			this.leftMis = leftMis;
			this.leftCan = leftCan;
			this.rightMis = rightMis;
			this.rightCan = rightCan;
			this.boat = boat;
			this.transfar_so_far = transfar_so_far;
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
		 public int compareTo(Node o) {
				// TODO Auto-generated method stub
				int ownPriority = this.transfar_so_far + this.predicted_transfer;
				int otherPriority = o.transfar_so_far + o.predicted_transfer;
				
				return Double.compare(ownPriority, otherPriority);
			}
		
		    
}
