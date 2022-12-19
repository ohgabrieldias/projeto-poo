package neander;

public class Rdm {
	protected int []RDM = {0,0,0,0,0,0,0,0};
	
	public Rdm() {
		// TODO Auto-generated constructor stub
	}

	public void cargaRDM(int []rdm){	//sinal de controle
		RDM = rdm;	
	}
	
	int binaryToDecimal() {
		int result = 0;
		for(int i=(RDM.length -1) ; i >= 0; i--){
			if(RDM[i] == 1) {
				result += Math.pow(2,(RDM.length -i -1));
				//System.out.println(result);
			}
        }
		//System.out.println(result);
		return result;
	}
	
	int getRDM() {
		return binaryToDecimal();
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
