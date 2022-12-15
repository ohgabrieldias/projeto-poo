package neander;

public class HalfAdder {
	private And and = null;
	protected int Cout;
	private int s;
	//private Xor xor = null;
	
	public HalfAdder() {
		// TODO Auto-generated constructor stub
	}
	
	int [] halfAdder(int x, int y) {
		and = new And();
		int temp [] = new int[2];
		
		temp[0] = and.and(x, y); //carry
		temp[1] = x ^ y;		//sum
		return temp;
	}
	
	
	int s(int x, int y) {
		and = new And();
		
		Cout = and.and(x, y); //carry
		return x ^ y;		//sum
		 
	}
	public static void main(String[] args) {
		HalfAdder ha = new HalfAdder();
		
		int temp [] = new int[2];
		temp = ha.halfAdder(1, 1);
		
		System.out.printf("%d carry, %d\n", temp[0], temp[1]);

	}

}
