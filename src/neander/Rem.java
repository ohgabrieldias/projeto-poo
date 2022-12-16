package neander;

public class Rem {
	protected int []REM = {0,0,0,0,0,0,0,0};
	
	public Rem() {
		// TODO Auto-generated constructor stub
	}
	
	public void cargaREM(int []rem){	//sinal de controle
		REM = rem;	
	}
	void printREM() {
		System.out.print("REM = ");
		   for(int i = 0;i <=REM.length - 1;i++){    
		       System.out.print(REM[i]);    
		     }
		   System.out.println();  
		}
	
	int binaryToDecimal() {
		int result = 0;
		for(int i=(REM.length -1) ; i >= 0; i--){
			if(REM[i] == 1) {
				result += Math.pow(2,(REM.length -i -1));
				//System.out.println(result);
			}
        }
		//System.out.println(result);
		return result;
	}
	
	int getREM() {
		return binaryToDecimal();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
