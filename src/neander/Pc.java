package neander;

public class Pc {
	protected int []PC;
	
	public Pc() {
		int pc[] = {0,0,0,0,0,0,0,0};
		PC = pc;
	}
	
	public void cargaPC(int []pc){	//sinal de controle
		PC = pc;	
	}
	
	void incrementa_pc() {
		int temp = binaryToDecimal() + 1;
		decimalToBinary(temp);
	}
	
	int binaryToDecimal() {
		int result = 0;
		for(int i=(PC.length -1) ; i >= 0; i--){
			if(PC[i] == 1) {
				result += Math.pow(2,(PC.length -i -1));
				//System.out.println(result);
			}
        }
		System.out.println(result);
		return result;
	}
	
	int getPc() {
		return binaryToDecimal();
	}
	void decimalToBinary(int dec) {
		int i = 7;
		
		while(dec > 0){    
		   PC[i--] = dec%2;    
		   dec = dec/2;    
		}
	}
	void printPc() {
	   System.out.print("PC = "); 
	   for(int i = 0;i <=PC.length - 1;i++){    
	       System.out.print(PC[i]);    
	     }
	   System.out.println();  
	}
	
	public static void main(String[] args) {
		Pc pc = new Pc();
		pc.printPc();
		pc.incrementa_pc();
		
		pc.binaryToDecimal();
		pc.printPc();

	}

}
