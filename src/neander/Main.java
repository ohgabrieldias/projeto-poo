package neander;

public class Main {
		
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
		
		unitControl.state = 0; //define estado inicial
		while(pc.getPc() < Memoria.memo.length) {				
			control(unitControl.set_state(Decod.decod(ri.getOpcode()),regNZ.NZ));
			mux.sel = sel;
			ula.selULA = unitControl.getSelULA();
			
			if(cargaREM == 1) rem.cargaREM(mux.getAddr(pc.PC, rdm.RDM));	//sinal de controle p/ pegar valor do pc,carrega REM com valor do PC
			if(read == 1) rdm.cargaRDM(mem.read(rem.getREM()));		//lê da memória na posição REM e armazena do RDM
			if(write == 1) mem.write(ac.AC, rem.getREM());
			if(cargaRDM == 1) rdm.cargaRDM(pc.PC);
			if(cargaPC == 1) pc.cargaPC(rdm.RDM); 		//caso JMP JZ JN
			if(cargaRI == 1) ri.cargaRI(rdm.RDM); 		//etapa final busca da instrução
			if(cargaAC == 1) ac.cargaAC(ula.opULA(ac.AC, rdm.RDM));
			if(incrementaPC == 1) pc.incrementa_pc();
			if(cargaNZ == 1) {
				if(ac.getAC() == 0) regNZ.NZ[1] = 1;
				if(ac.eh_negativo())regNZ.NZ[0] = 1;
			}
			
			pc.printPc();			
			rem.printREM();
			rdm.printRDM();
			ri.printRI();
			ac.printAc();

		}
		Memoria.printMemo();
	}
}
