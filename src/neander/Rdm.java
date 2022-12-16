package neander;

public class Rdm {
	protected int []RDM = {0,0,0,0,0,0,0,0};
	
	public Rdm() {
		// TODO Auto-generated constructor stub
	}

	public void cargaRDM(int []rdm){	//sinal de controle
		RDM = rdm;	
	}
	
	void printRDM() {
		System.out.print("RDM = ");
		   for(int i = 0;i <=RDM.length - 1;i++){    
		       System.out.print(RDM[i]);    
		     }
		   System.out.println();  
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
