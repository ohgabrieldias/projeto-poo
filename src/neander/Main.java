package neander;

public class Main {
	public static int []opcode= new int[4];
	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getOpcode(int []mem) {
			//pega opcode
		for(int i=0 ; i <= 3; i++){
			opcode[i] = mem[i];
        }
	}
	
	public static int binaryToDecimal(int []vect) {
		int result = 0;
		for(int i=(vect.length -1) ; i >= 0; i--){
			if(vect[i] == 1) {
				result += Math.pow(2,(vect.length -i -1));
				//System.out.println(result);
			}
        }
		//System.out.println(result);
		return result;
	}
	
	public static int getRDM(int []intrs) {
		int []rdm= new int[4];	//pega opcode
		
		for(int i=0 ; i <= 3; i++){
			rdm[i] = intrs[i+4];
        }
		//System.out.println();
		//for(int i=0 ; i <= 3; i++){
			//System.out.print(rdm[i]);
       // }
		
		return binaryToDecimal(rdm);
	}
	
	public static int [] instrLda() {
		return opcode;
		
	}
	
	public static void main(String[] args) {
		int op = 0;
		Pc pc = new Pc();
		Adder adder = new Adder();
		Accumulator ac = new Accumulator();
		Memoria mem = new Memoria();
		
		//getOpcode(memo[0]);
		ac.printAc();
		System.out.println(getRDM(mem.memo[0]));
		
		
		if(opcode[0]== 0 && opcode[1]== 0 && opcode[2]== 0 && opcode[3]== 0) ac.AC = mem.memo[getRDM(mem.memo[pc.getPc()])];
		ac.printAc();
		
	}

}
