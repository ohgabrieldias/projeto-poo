package neander;

public class Memoria {
	protected int[][] memo = {
			{0,0,0,0,0,1,0,0}, //LDA 4
			{0,0,0,1,0,1,0,0}, //AC <- ADD 4
			{0,0,0,1,0,1,0,1},
			{0,0,0,1,0,1,0,1},
			{0,0,0,0,0,1,0,1}, //4
			{0,0,0,1,0,1,0,1}
		};
	
	public Memoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
