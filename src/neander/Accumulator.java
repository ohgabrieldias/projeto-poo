package neander;

public class Accumulator {
	protected int []AC = {0,0,0,0,0,0,0,0};
	
	public Accumulator() {
		
	}
	
	public void cargaAC(int []ac){	//sinal de controle
		AC = ac;	
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
