package view;

import controller.TdMtz;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] Mt = new int[3][5];
		int i, j;
		
		//generate matrix
		for (i = 0; i<3; i++) { 
			for (j=0; j<5; j++) {
				Mt[i][j] = (int)(Math.random() * 10);
			}
		}
		
		//print matrix
		System.out.println("  MATRIZ");
		for (i = 0; i<3; i++) { 
			for (j=0; j<5; j++) {
				System.out.print(Mt[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//call thread
		for (i=0; i<3; i++) {
			Thread td = new TdMtz(Mt[i], i);
			td.start();
		}
		
	}
}
