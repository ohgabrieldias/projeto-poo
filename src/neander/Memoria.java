package neander;

public class Memoria {
	
	public int read = 0;
	public int write = 0;
	
	protected int[][] memo = {
			{0,0,0,0,0,1,0,0}, //AC← MEM(end) //LDA	4 
			{0,0,0,1,0,1,0,0}, //AC← MEM(end) + AC
			{0,0,0,1,0,1,0,1},
			{0,0,0,1,0,1,0,1},
			{0,0,0,0,0,1,0,1}, //4
			{0,0,0,1,0,1,0,1}
		};
	
	public void write(int []x, int y) {
		if (write == 1) {
			memo[y] = x;
		}
	}
	
	public int []read (int y) {
			return memo[y];
	}
	public Memoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
