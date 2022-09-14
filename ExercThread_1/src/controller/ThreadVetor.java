package controller;

public class ThreadVetor extends Thread {
	int num;
	int vet[] = new int[1000];
	
	//construtor
	public ThreadVetor(int vet[], int num) {
		this.vet = vet;
		this.num = num;
	}
	
	@Override
	public void run() {
		long time_start = System.nanoTime();
		
		//contar tempo para correr vetor se par
		if (num%2==0) {
			for(int i=0; i< vet.length; i++) {
				vet[i] = 0;
			}
			double elap_time = (System.nanoTime() - time_start) * (Math.pow(10, -9));
			System.out.println("Tempo para percorrer vetor (par) ==> " + elap_time + " S");
		}
		
		//contar tempo para correr vetor se ímpar
		else {
			for(int i : vet) {
				vet[i] = 1;
			}
			double elap_time = (System.nanoTime() - time_start) * (Math.pow(10, -9));
			System.out.println("Tempo para percorrer vetor (ímpar) ==> " + elap_time + " S");
		}
	}

}
