package neander;

public class PortasLogicas {
	private static final int maxLenght = 8;	
	
	static int[] and(int[] c, int[] b) {
		int i = 0;
		int[] result = new int[maxLenght];
		
		for(i = 0;i < maxLenght; i++) {
			result[i]= (c[i]&b[i]);
			System.out.print(result[i] + " ");  
		}
		return c;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,0,0,0,1,1,1};
		int[] b = {0,1,0,0,0,1,0,0};
		
		int[] temp = and(a, b);
		

	}

}
