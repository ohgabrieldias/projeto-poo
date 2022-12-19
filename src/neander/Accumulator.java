package neander;

public class Accumulator {
	protected int []AC = {0,0,0,0,0,0,0,0};
	
	public Accumulator() {
		
	}
	
	public void cargaAC(int []ac){	//sinal de controle
		AC = ac;	
	}
	
	public boolean eh_negativo() {
		if(AC[0] == 1) return true;
		else return false;
	}
	
	int binaryToDecimal() {
		int result = 0;
		for(int i=(AC.length -1) ; i >= 0; i--){
			if(AC[i] == 1) {
				result += Math.pow(2,(AC.length -i -1));
				//System.out.println(result);
			}
        }
		//System.out.println(result);
		return result;
	}
	
	int getAC() {
		return binaryToDecimal();
	}
	
	void printAc() {
		System.out.print("AC = ");
		   for(int i = 0;i <=AC.length - 1;i++){    
		       System.out.print(AC[i]);    
		     }
		   System.out.println();  
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
