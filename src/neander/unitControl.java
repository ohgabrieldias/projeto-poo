package neander;

public class unitControl {
	public int []control = new int[11];
	protected static int state;
	protected static int prox_state = 0;
	public unitControl() {
		// TODO Auto-generated constructor stub
	}
	
	public static int []set_state(int op) {
		int []stt = new int [11];
		
		switch (state) {
			case 0:
								//0 1 2 3 4 5 6 7 8 9 10
				int []tmp_ctrl = {0,0,0,1,0,0,0,0,0,0,0}; //start sel= 0,carga REM
				stt = tmp_ctrl;
				System.out.println("\nestado 0");
			break;
			case 1:
				int []tmp_ctrl1 = {0,1,0,0,1,0,0,0,0,0,0}; //read PC + 1
				stt = tmp_ctrl1;
				System.out.println("\nestado 1");
			break;
			case 2:
				int []tmp_ctrl2 = {0,0,0,0,0,0,0,0,0,0,1}; //RDM -> RI
				stt = tmp_ctrl2;
				System.out.println("\nestado 2");
			break;
			case 3:
				int []tmp_ctrl3 = {0,0,0,1,0,0,0,0,0,0,0}; //start
				stt = tmp_ctrl3;
				System.out.println("\nestado 3");
				break;
			case 4:
				if(op == 8) {
					int []tmp_ctrl4 = {0,0,0,0,1,0,0,0,0,0,0}; //sel=1,carga RDM
					stt = tmp_ctrl4;
				}
				else {
					int []tmp_ctrl4 = {0,1,0,0,1,0,0,0,0,0,0}; //read PC + 1
					stt = tmp_ctrl4;
				}
				System.out.println("\nestado 4");
			break;
			case 5:
				if(op == 8) {
					int []tmp_ctrl5 = {1,0,0,0,0,0,0,0,0,0,0}; //sel=1,carga REM
					stt = tmp_ctrl5;
				}
				else {
					int []tmp_ctrl5 = {0,0,1,1,0,0,0,0,0,0,0}; //sel=1,carga REM
					stt = tmp_ctrl5;
				}
				System.out.println("\nestado 5");
			break;
			case 6:
				int []tmp_ctrl6 = {0,0,0,0,1,0,0,0,0,0,0}; //sel=1,carga RDM
				stt = tmp_ctrl6;
				System.out.println("\nestado 6");
			break;
			case 7:
				if(op == 2) {
					System.out.println("load");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,1,1,0}; //sel=1,carga RDM
					stt = tmp_ctrl7;
				}
				else if (op == 3) {
					System.out.println("\nadd");
					int []tmp_ctrl7 = {0,0,0,0,0,0,0,1,0,1,0}; //sel=1,carga RDM
					stt = tmp_ctrl7;
				}
				System.out.println("\nestado 7");
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
				prox_state = 4;
			break;
			case 4:
				prox_state = 5;
			break;
			case 5:
				if(op == 8 || op == 9) prox_state = 0; //JMP JZ if Z=1
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

}
