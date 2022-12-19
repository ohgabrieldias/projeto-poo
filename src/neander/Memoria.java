package neander;

public class Memoria {
	protected static int[][] memo = {
			{0,0,0,1,0,1,0,0}, //#0		AC← MEM(end) //LDA 4 
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
	
	public static void printMemo() {
		int result = 0;
		int tmp[] = new int [8];
		
		for(int i = 0 ; i <= (memo.length -1); i++){
			tmp = memo[i];
			
			for(int j = (tmp.length -1) ; j >= 0; j--){
				if(tmp[j] == 1) {
					result += Math.pow(2,(tmp.length -j -1));
					
				}
			}
			
			System.out.printf("\n%d# %d",i, result);
			result = 0;
        }
		//System.out.println(result);
		
	}

	public void write(int []x, int y) {
		memo[y] = x;
	}
	
	public int []read (int y) {
			return memo[y];
	}
	public Memoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		System.out.println(memo.length);
		printMemo();
	}

}
