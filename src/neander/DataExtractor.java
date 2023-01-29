package neander;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DataExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        scanner.close();

        String[] mnemonics = new String[100];
        int[][] matrix = new int[100][8];
        int row = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                mnemonics[row] = line.substring(0, 3);
                if (mnemonics[row].equals("LDA")) {
                    matrix[row] = new int[]{0, 0, 1, 0, 0, 1, 0, 0};
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


