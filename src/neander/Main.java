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
		int []tmp;
		int op = 0;
		Pc pc = new Pc();
		Ula ula = new Ula();
		Adder adder = new Adder();
		Accumulator ac = new Accumulator();
		Memoria mem = new Memoria();
		Mux mux = new Mux();
		Rem rem = new Rem();
		Rdm rdm = new Rdm();
		
		rdm.cargaRDM(pc.PC);
		mux.sel = 0; //sinal de controle p/ pegar valor do pc
		mem.read = 1;
		rem.cargaREM(mux.getAddr(pc.PC, rdm.RDM));		//carrega REM com valor do PC
		rem.printREM();
		
		if(mem.read == 1) rdm.cargaRDM(mem.read(rem.getREM()));		//lê da memória na posição REM e armazena do RDM
		rdm.printRDM();
		
		pc.incrementa_pc();
		getOpcode(mem.memo[pc.getPc()]);
		pc.printPc();
		
		
		if(opcode[0]== 0 && opcode[1]== 0 && opcode[2]== 0 && opcode[3]== 1) {
			ula.selULA = 0;
			ac.AC = ula.opULA(mem.memo[pc.getPc()], pc.PC);
			System.out.print("add\n");
			ac.printAc();
			pc.incrementa_pc();
			pc.printPc();
		}
		
		if(opcode[0]== 0 && opcode[1]== 0 && opcode[2]== 0 && opcode[3]== 0) {
			ac.AC = mem.memo[getRDM(mem.memo[pc.getPc()])];
			System.out.print("lda\n");
			ac.printAc();
			pc.incrementa_pc();
			pc.printPc();
		}
		
		
	}
	

}
