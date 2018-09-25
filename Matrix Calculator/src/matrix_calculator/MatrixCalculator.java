package matrix_calculator;

/**
 * Program that reads the content of a file and 
 * Collect the element and put it into a 2D array matrix 
 * perform a multiplication operation on it
 * Write the result to file
 * 
 * @author
 * @version 
 *
 */

import java.util.*;
import java.io.*;

public class MatrixCalculator {

	/**
	 * Program starting point
	 * @throws IOException throws any error that might occur
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		File fileA = new File("matrixA.txt");
		File fileB = new File("matrixB.txt");

		ArrayList<Integer> matrixB = getArray(fileB);

		ArrayList<Integer> matrixA = getArray(fileA);

		int[][] getmatrixA = matrix(matrixA,fileA);

		int[][] getmatrixB = matrix(matrixB,fileB);
		
		if( getmatrixA[0].length != getmatrixB.length){
			
			System.out.println("Operation cannot be performed. Column size of MatrixA unequal to Row size of MatrixB");
		}
		
		else{

		int[][] matrixAB = multiplyMatrixAB(getmatrixA, getmatrixB);

		printMatrix(matrixAB);
		
		}
	}

	/**
	 * @param newArray is the Integer arraylist
	 * @param file is the text file containing the element of the matrix
	 * @returns the matrix representation of the information present in the file
	 * @ @throws IOException throws any error that might occur
	 */

	public static int[][] matrix(ArrayList<Integer> newArray, File file) throws IOException {

		newArray = getArray(file);

		Scanner sc = new Scanner(file);

		String str = "";

		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);

		int numberRows = 0;

		int numberColumns = 0;

		while ((br.readLine()) != null) {

			numberRows++;
		}
		
		int[] tempArray = new int[newArray.size()];

		for (int i = 0; i < tempArray.length; i++) {

			tempArray[i] = newArray.get(i);
		}
		
		while (sc.hasNext()) {
			
			
			str = sc.nextLine();
			
			String [] ss = str.split(" ");
			 
			numberColumns = ss.length;
			

		}

		int[][] matrix = new int[numberRows][numberColumns];

		int count = 0;

		for (int i = 0; i < numberRows; i++) {

			for (int j = 0; j < numberColumns; j++) {

				if (count == tempArray.length)

					break;

				matrix[i][j] = tempArray[count];

				count++;
			}

		}
		br.close();
		return matrix;
	}

	/**
	 * Function that compute the product of two 2D array into a matrix form
	 * @param matrix is the first 2D integer array
	 * @param matrixB is the second 2D integer array
	 * @return the product of the two 2D matrix
	 */

	public static int[][] multiplyMatrixAB(int[][] matrixA, int[][] matrixB) {

		if (matrixA.length == 0)

			return new int[0][0];

		if (matrixA[0].length != matrixB.length)

			return null;
		
		int[][] matrixResult = new int[matrixA.length][matrixB[0].length];

		for (int i = 0; i < matrixA.length; i++) {

			for (int j = 0; j < matrixB[0].length; j++) {

				for (int k = 0; k < matrixA[0].length; k++) {

					matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}

		return matrixResult;

	}

	/**
	 * Function that prints and write the result of the product of two 2D array into a file
	 * @param result is the 2D integer array representing the product of two 2D array
	 * @throws FileNotFoundException throws any error that might occur
	 */

	public static void printMatrix(int[][] result) throws FileNotFoundException {

		PrintStream output = new PrintStream(new File("matrixAnswer.txt"));

		for (int i = 0; i < result.length; i++) {

			for (int j = 0; j < result[0].length; j++) {

				System.out.print(result[i][j] + "\t");

				output.print(result[i][j] + "\t");
			}
			output.println();

			System.out.println();
		}

	}

	/**
	 * @param file is the text file containing the array elements
	 * @return returns an arrayList
	 * @throws FileNotFoundException throws any error that might occur
	 */

	public static ArrayList<Integer> getArray(File file) throws FileNotFoundException {

		Scanner scan = new Scanner(file);

		ArrayList<Integer> getNumbers = new ArrayList<Integer>();

		int temp = 0;

		while (scan.hasNext()) {

			temp = scan.nextInt();

			getNumbers.add(temp);

		}
		return getNumbers;
	}

}
