package neander;

public class Memoria {
	
	public int read = 0;
	public int write = 0;
	
	protected int[][] memo = {
			{0,0,1,0,0,1,0,0}, //#0		AC← MEM(end) //LDA 4 
			{0,0,0,0,0,1,0,0}, //#1		end 4
			{0,0,1,1,0,1,1,1}, //#2		AC← AC + 7  ADD 3
			{0,0,0,0,0,0,1,1}, //#3		 7
			{1,0,0,0,0,0,1,1}, //#4		PC <- end
			{0,0,0,0,1,0,1,1}, //#5
			{0,0,0,0,0,1,0,1}, //#6
			{1,0,1,1,0,1,0,1},
			{0,0,0,0,0,1,1,1}, // 
			{0,0,0,0,0,0,1,1}, //#9
			{0,0,0,1,0,1,0,1},
			{0,0,0,0,0,1,0,1}, //#11
			{1,0,1,1,0,1,0,1},
			{0,0,0,0,0,1,0,1}, //#13
			{1,0,1,1,0,1,0,1}
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
