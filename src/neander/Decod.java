package neander;

public class Decod {

	public Decod() {
		// TODO Auto-generated constructor stub
	}
	
	public static int decod(int []ri) {
		int tmp = 0;
		if(ri[0] == 0 && ri[1] == 0 && ri[2] == 0 && ri[3] == 0) {
			tmp = 0;	//NOP
		}
		if(ri[0] == 0 && ri[1] == 0 && ri[2] == 0 && ri[3] == 1) {
			tmp = 1;	//STA
		}
		if(ri[0] == 0 && ri[1] == 0 && ri[2] == 1 && ri[3] == 0) {
			tmp = 2;	//LDA
		}
		if(ri[0] == 0 && ri[1] == 0 && ri[2] == 1 && ri[3] == 1) {
			tmp = 3;	//ADD
		}
		if(ri[0] == 0 && ri[1] == 1 && ri[2] == 0 && ri[3] == 0) {
			tmp = 4;	//OR
		}
		if(ri[0] == 0 && ri[1] == 1 && ri[2] == 0 && ri[3] == 1) {
			tmp = 5;	//AND
		}
		if(ri[0] == 0 && ri[1] == 1 && ri[2] == 1 && ri[3] == 0) {
			tmp = 6;	//NOT
		}
		if(ri[0] == 1 && ri[1] == 0 && ri[2] == 0 && ri[3] == 0) {
			tmp = 8;	//JMP
		}
		if(ri[0] == 1 && ri[1] == 0 && ri[2] == 0 && ri[3] == 1) {
			tmp = 9;	//JZ
		}
		if(ri[0] == 1 && ri[1] == 0 && ri[2] == 1 && ri[3] == 0) {
			tmp = 10;	//LDA
		}
		if(ri[0] == 1 && ri[1] == 1 && ri[2] == 1 && ri[3] == 1) {
			tmp = 15;	//HLT
		}
		return tmp; 
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
