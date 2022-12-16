package neander;

public class Mux {
	public int sel = 0; //sinal de controle
	
	public Mux() {
		// TODO Auto-generated constructor stub
	}
	
	public int []getAddr(int []x, int []y){
		if(sel == 0) return x;
		else return y;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
