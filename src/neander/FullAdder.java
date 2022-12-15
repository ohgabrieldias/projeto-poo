package neander;

public class FullAdder {
	private And and = null;
	private Or or = null;
	private HalfAdder ha1 = null;
	private HalfAdder ha2 = null;
	protected int Cout;
	
	public FullAdder() {
		// TODO Auto-generated constructor stub
	}
	
	public int []sum(int []x, int []y){
		int s [] = new int[8];
		
		return s;
	}
	// public int []sum(int x, int y, int cIn){
	// 	ha1 = new HalfAdder();
	// 	ha2 = new HalfAdder();
		
	// 	int temp1 [] = new int[2];
	// 	int temp2 [] = new int[2];
		
	// 	temp1 = ha1.halfAdder(x, y);
	// 	temp2 = ha2.halfAdder(temp1[1], cIn);
	// 	return s;
	// }
	
	public int sum2(int x, int y, int cIn){
		or = new Or();
		ha1 = new HalfAdder();
		ha2 = new HalfAdder();
		
		int temp1 = ha1.s(x, y);
		int temp2 = ha2.s(temp1, cIn);
		//System.out.printf("%d Coutt, %d soma\n", ha1.Cout, ha2.Cout);
		Cout = or.or(ha1.Cout, ha2.Cout);
		
		return temp2;
	}
	public static void main(String[] args) {
		FullAdder fa = new FullAdder();
		int temp;
		temp = fa.sum2(1, 1, 0);
		
		System.out.printf("%d Cout, %d soma\n", fa.Cout, temp);

	}

}
