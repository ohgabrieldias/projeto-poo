package neander;

public class Ula {
	private Adder adder = new Adder();
	private And and = new And();
	private Or or = new Or();
	
	private int regN = 0;
	private int regZ = 0;
	
	public int selULA = 0; //sinal de controle
	
	public Ula() {
		// TODO Auto-generated constructor stub
	}
					//opernd  pc
	public int []opULA(int x[],int y[]) {
		int []tmp = new int [8];
		switch (selULA) {
			case 0:	tmp = adder.sum(x, y);		//ULA(ADD)
				break;
			case 1:			//ULA(LDA)
				break;
			case 2:			//ULA(OR)
				break;
			case 3:			//ULA(OR)
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
