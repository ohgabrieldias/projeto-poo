package neander;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.input.Mnemonic;

public class FileProcessor {
	private int [][]matrix;
	
	public int [][]obterData(){
		extrairDados();
		return matrix;
		
	}
	private static int contaLinhas() {
		int qtdLinhas = 0;
		 String fileName = "exemplo.txt";

	        try {
	            Scanner file = new Scanner(new File(fileName));
	            
	            while (file.hasNextLine()) {
	                String line = file.nextLine();
	            	qtdLinhas++;
	            }
	        }	catch (FileNotFoundException e) {
	        	System.out.println("Error: File not found");
	        }
	        
//	        System.out.println(qtdLinhas);
		return qtdLinhas;
		
	}
	
  public void extrairDados() {
    matrix = new int[contaLinhas()][8]; // matriz de 8 bits
    // Scanner input = new Scanner(System.in);
    // System.out.println(contaLinhas());
    int aux = -1;
    boolean resetou = false;
    String fileName = "exemplo.txt";
    try {
      Scanner file = new Scanner(new File(fileName));
      int lineCounter = 0;
      while (file.hasNextLine()) {
        String line = file.nextLine();

        if (line.length() > 3) {
          String[] parts = line.split(" ");
          String mnemonic = parts[0];

          aux += 1;

          int decimal = Integer.parseInt(parts[1]);
          String tmp = mnemonic;

          switch (tmp) {
            case "STA":
              matrix[lineCounter][0] = 0;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 0;
              matrix[lineCounter][3] = 1;
              break;
            case "LDA":
              matrix[lineCounter][0] = 0;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 1;
              matrix[lineCounter][3] = 0;
              break;

            case "ADD":
              matrix[lineCounter][0] = 0;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 1;
              matrix[lineCounter][3] = 1;
              break;
            case "OR":
              matrix[lineCounter][0] = 0;
              matrix[lineCounter][1] = 1;
              matrix[lineCounter][2] = 0;
              matrix[lineCounter][3] = 0;
              break;
            case "AND":
              matrix[lineCounter][0] = 0;
              matrix[lineCounter][1] = 1;
              matrix[lineCounter][2] = 0;
              matrix[lineCounter][3] = 1;
              break;
            case "JMP":
              matrix[lineCounter][0] = 1;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 0;
              matrix[lineCounter][3] = 0;
              break;
            case "JN":
              matrix[lineCounter][0] = 1;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 0;
              matrix[lineCounter][3] = 1;
              break;
            case "JZ":
              matrix[lineCounter][0] = 1;
              matrix[lineCounter][1] = 0;
              matrix[lineCounter][2] = 1;
              matrix[lineCounter][3] = 0;
              break;
          }

          lineCounter++;

          int i = 7;

          while (decimal > 0) {
            matrix[lineCounter][i--] = decimal % 2;
            decimal = decimal / 2;
          }
        } else {
          if ((lineCounter == 128) && !(resetou)) {
            lineCounter = lineCounter - aux;
            resetou = true;
          }

          if (line.equals("NOP")) {
            matrix[lineCounter][0] = 0;
            matrix[lineCounter][1] = 0;
            matrix[lineCounter][2] = 0;
            matrix[lineCounter][3] = 0;
          } else if (line.equals("HLT")) {
            matrix[lineCounter][0] = 1;
            matrix[lineCounter][1] = 1;
            matrix[lineCounter][2] = 1;
            matrix[lineCounter][3] = 1;
          } else if (line.equals("NOT")) {
            matrix[lineCounter][0] = 0;
            matrix[lineCounter][1] = 1;
            matrix[lineCounter][2] = 1;
            matrix[lineCounter][3] = 0;
          } else {
            int decimal = Integer.parseInt(line);
            int i = 7;

            while (decimal > 0) {
              matrix[lineCounter][i--] = decimal % 2;
              decimal = decimal / 2;
            }
          }
        }
        lineCounter++;
        // System.out.println("nvo");
      }

    } catch (FileNotFoundException e) {
      System.out.println("Error: File not found");
    }
  }
	
	public void imprimir() {
		for (int i = 0; i < matrix.length; i++) {
            System.out.print("#" + i + " = ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}
	
    public static void main(String[] args) {
    	FileProcessor dados = new FileProcessor();
    	dados.extrairDados();
    	dados.imprimir();
        
    }

}

