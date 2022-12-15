package neander;

public class Adder {
	private FullAdder fa0 = new FullAdder();
	private FullAdder fa1 = new FullAdder();
	private FullAdder fa2 = new FullAdder();
	private FullAdder fa3 = new FullAdder();
	
	protected int Cout;
	public Adder() {
		// TODO Auto-generated constructor stub
	}

	public int []sum(int []x, int []y){
		int []s = new int[4];
		
		int temp = y[7] ^ 0;
		s[3] = fa0.sum2(x[7], temp, 0);
		
		temp = y[6] ^ 0;
		s[2] = fa1.sum2(x[6], temp, fa0.Cout);
	
		temp = y[5] ^ 0;
		s[1] = fa2.sum2(x[5], temp, fa1.Cout);
		
		temp = y[4] ^ 0;
		s[0] = fa3.sum2(x[4], temp, fa2.Cout);
		
		Cout = fa3.Cout;
		return s;
	}
	

	public static void main(String[] args) {
		Pc pc = new Pc();
		Adder adder = new Adder();
		Accumulator ac = new Accumulator();
		Memoria mem = new Memoria();
		
		int s [] = adder.sum(mem.memo[2], mem.memo[1]);
		for(int count=0 ; count <= 3; count++){
            System.out.print(s[count]);
        }
		System.out.printf("\n%d Cout\n", adder.Cout);
	}
	

}
