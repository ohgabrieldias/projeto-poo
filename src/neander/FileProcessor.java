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
		 String fileName = "te.txt";

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
		matrix = new int[contaLinhas()][8]; //matriz de 8 bits
//      Scanner input = new Scanner(System.in);
//	      System.out.println(contaLinhas());
	      String fileName = "te.txt";

        try {
            Scanner file = new Scanner(new File(fileName));
            int lineCounter = 0;
            String t = "HHH"; 
            while (file.hasNextLine()) {
                String line = file.nextLine();
                
                if(line.length() >= 3){
                    t = line.substring(0, 3);
                }

                if (((lineCounter % 2 == 0) && (!(t.equals("NOP"))) && (!(t.equals("HLT"))))) { //linhas pares
                    String[] parts = line.split(" ");
                    String mnemonic = parts[0];
                    
                    int decimal = Integer.parseInt(parts[1]);
                    String binary = Integer.toBinaryString(decimal);
                    String tmp = mnemonic;

                    switch (tmp) {
                        case "NOP":
                            matrix[lineCounter][0] = 0;
                            matrix[lineCounter][1] = 0;
                            matrix[lineCounter][2] = 0;
                            matrix[lineCounter][3] = 0;
                            break;
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
                        case "NOT":
                            matrix[lineCounter][0] = 0;
                            matrix[lineCounter][1] = 1;
                            matrix[lineCounter][2] = 1;
                            matrix[lineCounter][3] = 0;
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
                        case "HLT":
                            matrix[lineCounter][0] = 1;
                            matrix[lineCounter][1] = 1;
                            matrix[lineCounter][2] = 1;
                            matrix[lineCounter][3] = 1;
                            break;
                    }
            

                int index = 0;
                while(index < (4 - binary.length() )){
                    matrix[lineCounter][index + 4] = 0;
                    index++;
                }

                for (int i = (index + 4); i < 8; i++) {
                    matrix[lineCounter][i] = Character.getNumericValue(binary.charAt(i - (index + 4)));                          
                }

                  
                } else { //linhas impares
                    if(line.equals("NOP")){
                        matrix[lineCounter][0] = 0;
                        matrix[lineCounter][1] = 0;
                        matrix[lineCounter][2] = 0;
                        matrix[lineCounter][3] = 0;
                    }
                    else if(line.equals("HLT")){
                        matrix[lineCounter][0] = 1;
                        matrix[lineCounter][1] = 1;
                        matrix[lineCounter][2] = 1;
                        matrix[lineCounter][3] = 1;
                    }
                    else{
                        int decimal = Integer.parseInt(line);
                        int i = 7;
		
                        while(decimal > 0){    
                            matrix[lineCounter][i--] = decimal%2;    
                            decimal = decimal/2;    
                        }
                        // int aux = 0;
                        // if(binary.length() > 7) aux = -7;
                        // else aux = 0;
                        // while(aux < (7 - binary.length() )){
                        //     matrix[lineCounter][aux + 4] = 0;
                        //     aux++;
                        // }
                        // System.out.println(binary);
                        // for (int i = (aux + 4); i < 8; i++) {
                        //     matrix[lineCounter][i] = Character.getNumericValue(binary.charAt(i - (aux + 7)));
                        // //matrix[lineCounter][i] = 0;                 	  
                                
                        // }
                }
              }
              lineCounter++;
//              System.out.println("nvo");
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

