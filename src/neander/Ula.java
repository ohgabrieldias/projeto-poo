package neander;

public class Ula {
	private Adder adder = new Adder();
	private And and = new And();
	private Or or = new Or();
	
	public int selULA = 0; //sinal de controle
	
	public Ula() {
		// TODO Auto-generated constructor stub
	}
					//opernd  pc
	public int []opULA(int x[],int y[]) {
		int []tmp = new int [8];
		System.out.printf("selULA = %d", selULA);
		switch (selULA) {
			case 0:	tmp = adder.sum(x, y);		//ULA(ADD)
				System.out.println("\nSOMA");
				break;
			case 1:		//ULA(LDA)
				tmp = y;
				System.out.println("\nLOAD");
				break;
			case 2:			//ULA(NOT)
				break;
			case 3:			//ULA(OR)
				break;
			case 4:			//ULA(AND)
				break;
		}
		return tmp;
	}
	
	public int []sum(int x[],int y[]){
		return adder.sum(x, x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
