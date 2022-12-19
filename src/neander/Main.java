package neander;

public class Main {
	
	public static int []opcode= new int[4];
	
	public static int cargaPC = 0;
	public static int incrementaPC = 0;
	public static int sel = 0;
	public static int cargaREM = 0;
	public static int read = 0;
	public static int write = 0;
	public static int cargaRDM = 0;
	public static int cargaAC = 0;
	public static int selULA = 0;
	public static int cargaNZ = 0;
	public static int cargaRI = 0;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getOpcode(int []mem) {
			//pega opcode
		for(int i=0 ; i <= 3; i++){
			opcode[i] = mem[i];
        }
	}
	
	public static void control(int []ctrl) {
		cargaPC 		= ctrl[0];
		incrementaPC 	= ctrl[1];
		sel 			= ctrl[2];
		cargaREM		= ctrl[3];
		read 			= ctrl[4];
		write 			= ctrl[5];
		cargaRDM 		= ctrl[6];
		cargaAC 		= ctrl[7];
		selULA 			= ctrl[8];
		cargaNZ			= ctrl[9];
		cargaRI 		= ctrl[10];
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
		NZ regNZ = new NZ();
		Ri ri = new Ri();
		int i = 0;
		
		unitControl.state = 0; //define estado inicial
		while(pc.getPc() < 12) {				
			control(unitControl.set_state(Decod.decod(ri.getOpcode()),regNZ.NZ));
			mux.sel = sel;
			ula.selULA = selULA;
			
			//System.out.println(sel);
			if(cargaREM == 1) {	//sinal de controle p/ pegar valor do pc
				rem.cargaREM(mux.getAddr(pc.PC, rdm.RDM));		//carrega REM com valor do PC
				//rem.printREM();
			}
			if(read == 1) rdm.cargaRDM(mem.read(rem.getREM()));		//lê da memória na posição REM e armazena do RDM
			if(write == 1) mem.write(ac.AC, rdm.getRDM());
			if(cargaRDM == 1) rdm.cargaRDM(pc.PC);
			if(cargaPC == 1) pc.cargaPC(rdm.RDM); 		//caso JMP JZ JN
			if(cargaRI == 1) ri.cargaRI(rdm.RDM); 		//etapa final busca da instrução
			if(cargaAC == 1) ac.cargaAC(ula.opULA(ac.AC, rdm.RDM));
			if(incrementaPC == 1) {
				pc.incrementa_pc();
			}
			if(cargaNZ == 1) {
				if(ac.getAC() == 0) regNZ.NZ[1] = 1;
				if(ac.eh_negativo())regNZ.NZ[0] = 1;
			}
			
			pc.printPc();			
			rem.printREM();
			rdm.printRDM();
			ri.printRI();
			ac.printAc();
			
			i++;
		}
	}
}
