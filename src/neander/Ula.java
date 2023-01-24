package neander;

public class Ula {
	private Adder adder = new Adder();
	private static And and = new And();
	private static Or or = new Or();
	
	public int []selULA = new int[3]; //sinal de controle
	
	public Ula() {
		// TODO Auto-generated constructor stub
	}
					//opernd  pc
	public int []opULA(int x[],int y[]) {
		int []tmp = new int [8];
//		System.out.printf("selULA = %d", selULA);
		if(selULA[0] == 0 && selULA[1] == 0 && selULA[2] == 0) { 	//ULA(ADD)
			tmp = adder.sum(x, y);		
			System.out.println("\nSOMA");
		}
		else if(selULA[0] == 0 && selULA[1] == 0 && selULA[2] == 1) { 	//ULA(AND)
			tmp = andOp(x, y);
			System.out.println("\nAND");
		}
		else if(selULA[0] == 0 && selULA[1] == 1 && selULA[2] == 0) { 	//ULA(OR)
			tmp = y;
			System.out.println("\nOR");
		}
		else if(selULA[0] == 0 && selULA[1] == 1 && selULA[2] == 1) { 	//ULA(NOT)
			tmp = y;
			System.out.println("\nNOT");
		}
		else if(selULA[1] == 0 && selULA[1] == 0 && selULA[2] == 0) { 	//ULA(LDA)
			tmp = y;
			System.out.println("\nLOAD");
		}
		return tmp;
	}
	
	public int []sum(int x[],int y[]){
		return adder.sum(x, x);
	}
	
	public int []andOp(int x[],int y[]){
//		System.out.println("\naquiii");
		int []tmp = new int[8];
		for (int i = (x.length - 1); i >= 0 ; i --) {
			tmp[i] = and.and(x[i], y[i]);	
		}
		
		return tmp;
	}
	
	public static int []orOp(int x[],int y[]){
		int []tmp = new int[8];
		for (int i = (x.length - 1); i >= 0 ; i --) {
			tmp[i] = or.or(x[i], y[i]);	
		}
		
		return tmp;
	}
	
	public static int []not(int x[],int y[]){
		return y;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
