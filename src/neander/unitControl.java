package neander;

public class unitControl {
	protected static int []control = new int[11];
	protected static int []selULA = new int[3];
	
	protected static int state;
	protected static int prox_state = 0;
	public unitControl() {
		// TODO Auto-generated constructor stub
	}
	
	public static int []set_state(int op, int []nz) {
		int []stt = new int [11];
		
		switch (state) {
			case 0:
				System.out.println("\n########### NOVA INSTRUÇÃO #############");
								//0 1 2 3 4 5 6 7 8 9 10
				int []tmp_ctrl = {0,0,0,1,0,0,0,0,0,0,0}; //start sel= 0,carga REM
				stt = tmp_ctrl;
				//System.out.println("\nfim estado 0");
			break;
			case 1:
				int []tmp_ctrl1 = {0,1,0,0,1,0,0,0,0,0,0}; //read PC + 1
				stt = tmp_ctrl1;
				//System.out.println("\nfim estado 1");
			break;
			case 2:
				int []tmp_ctrl2 = {0,0,0,0,0,0,0,0,0,0,1}; //RDM -> RI
				stt = tmp_ctrl2;
				//System.out.println("\nfim estado 2");
			break;
			case 3:
				if((op == 9 && nz[0] == 0) || (op == 10 && nz[1] == 0)) {	//JN if N=0 JZ if Z=0
					int []tmp_ctrl3 = {0,1,0,0,0,0,0,0,0,0,0}; //incrementaPC
					stt = tmp_ctrl3;
				}
				else if (op == 6) {	//NOT
					System.out.println("\nnot");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,0,1,0}; //cargaAC, cargaNZ, selULA
					int []tmp_selULA = {0,1,1};
					selULA = tmp_selULA;
					stt = tmp_ctrl7;
				}
				else if (op == 0) {	//NOP
					System.out.println("\nnop");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,0,0,0,0}; //NOP
					stt = tmp_ctrl7;
				}
				else {
					int []tmp_ctrl3 = {0,0,0,1,0,0,0,0,0,0,0}; //start
					stt = tmp_ctrl3;
				}
				
				//System.out.println("\nfim estado 3");
				break;
			case 4:
				if(op == 8 || (op == 9 && nz[0] == 1) || (op == 10 && nz[1] == 1)) {	//JMP JN if N=1 JZ if Z=1
					int []tmp_ctrl4 = {0,0,0,0,1,0,0,0,0,0,0}; //sel=1,carga RDM
					stt = tmp_ctrl4;
				}
				else {
					int []tmp_ctrl4 = {0,1,0,0,1,0,0,0,0,0,0}; //read PC + 1
					stt = tmp_ctrl4;
				}
				//System.out.println("\nfim estado 4");
			break;
			case 5:
				if(op == 8 || (op == 9 && nz[0] == 1) || (op == 10 && nz[1] == 1)) {	//JMP JN if N=1 JZ if Z=1
					int []tmp_ctrl5 = {1,0,0,0,0,0,0,0,0,0,0}; //cargaPC
					stt = tmp_ctrl5;
				}
				else {
					int []tmp_ctrl5 = {0,0,1,1,0,0,0,0,0,0,0}; //sel=1,carga REM
					stt = tmp_ctrl5;
				}
				//System.out.println("\nfim estado 5");
			break;
			case 6:
				int []tmp_ctrl6 = {0,0,0,0,1,0,0,0,0,0,0}; //sel=1,carga RDM
				stt = tmp_ctrl6;
				//System.out.println("\nfim estado 6");
			break;
			case 7:
				if(op == 2) {	//LDA
					System.out.println("\nload");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,1,1,0}; //cargaAC, cargaNZ, selULA
					int []tmp_selULA = {1,0,0};
					selULA = tmp_selULA;
					stt = tmp_ctrl7;
				}
				else if (op == 3) {	//ADD
					System.out.println("\nadd");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,0,1,0}; //cargaAC, cargaNZ, selULA
					int []tmp_selULA = {0,0,0};
					selULA = tmp_selULA;
					stt = tmp_ctrl7;
				}
				else if (op == 4) {	//OR
					System.out.println("\nor");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,0,1,0}; //cargaAC, cargaNZ, selULA
					int []tmp_selULA = {0,1,0};
					selULA = tmp_selULA;
					stt = tmp_ctrl7;
				}
				else if (op == 5) {	//AND
					System.out.println("\nand");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,0,1,0}; //cargaAC, cargaNZ, selULA
					int []tmp_selULA = {0,0,1};
					selULA = tmp_selULA;
					stt = tmp_ctrl7;
				}
				else if (op == 1) {	//STA
					System.out.println("\nsta");
					int []tmp_ctrl7 = {0,0,0,0,0,1,0,0,0,0,0}; //write
					stt = tmp_ctrl7;
				}
				// System.out.println("\nfim estado 7");
			break;
			}
		
		switch (state) { //atualiza valor próximo estado
			case 0:
				prox_state = 1;
			break;
			case 1:
				prox_state = 2;
			break;
			case 2:
				prox_state = 3;
			break;
			case 3:
				if((op == 9 && nz[0] == 0) || (op == 10 && nz[1] == 0) || op == 0 || op == 6) prox_state = 0;	//NOT,NOP,JN if N=0,JZ if Z=0
				else prox_state = 4;
			break;
			case 4:
				prox_state = 5;
			break;
			case 5:
				if(op == 8 || (op == 9 && nz[0] == 1) || (op == 10 && nz[1] == 1)) prox_state = 0; //JMP,JN if N=1,JZ if Z=1
				else prox_state = 6;
			break;
			case 6:
				prox_state = 7;
			break;
			case 7:
				prox_state = 0;
			break;
			
	}
		state = prox_state; //atualiza valor próximo estado
		return stt;
	}
	
	public static void main(String[] args) {
		
	}

	public int [] getControl() {
		return control;
	}

	public void setControl(int [] control) {
		this.control = control;
	}

	public static int [] getSelULA() {
		return selULA;
	}

	public void setSelULA(int [] selULA) {
		this.selULA = selULA;
	}

}
