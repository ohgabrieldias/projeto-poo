package neander;

public class Ri {
	protected int []RI = {0,0,0,0,0,0,0,0};
	
	public Ri() {
		// TODO Auto-generated constructor stub
	}

	public void cargaRI(int []ri){	//sinal de controle
		RI = ri;	
	}
	
	void printRI() {
		System.out.print("RI = ");
		   for(int i = 0;i <=RI.length - 1;i++){    
		       System.out.print(RI[i]);    
		     }
		   System.out.println();  
		}
	public void getOpcode(int []mem) {
		int []opcode = new int[4];
		
		for(int i=0 ; i <= 3; i++){
			opcode[i] = mem[i];
    }
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
