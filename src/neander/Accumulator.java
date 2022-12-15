package neander;

public class Accumulator {
	protected int []AC;
	
	public Accumulator() {
		int acc[] = {0,0,0,0,0,0,0,0};
		AC = acc;
	}
	
	void printAc() {
		   for(int i = 0;i <=AC.length - 1;i++){    
		       System.out.print(AC[i]);    
		     }
		   System.out.println();  
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
