package controller;
public class TdMtz extends Thread {
	private int mt[] = new int[5];
	private int i, lin;
	
	public TdMtz(int[] mt, int lin) {
		this.lin = lin;
		for(i=0; i<5; i++) {
			this.mt[i] = mt[i];
		}
		
	}
	
	@Override
	public void run() {
		int i;
		int sum=0;
		
		for (i=0; i<5; i++) {
			sum = sum + mt[i];
		}
		System.out.println("Soma da linha " + (lin+1) + ": " + sum);
	}
}
