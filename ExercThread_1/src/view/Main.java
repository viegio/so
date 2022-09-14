package view;

import controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {
		int vetor[] = new int[1000];
	
		//preencher vetor
		for (int i=0; i<1000; i++) {
			vetor[i] = (int)((Math.random()*100)+1);
		}
		
		//iniciar threads
		ThreadVetor tdvet1 = new ThreadVetor(vetor, 1);
		tdvet1.start();
		ThreadVetor tdvet2 = new ThreadVetor(vetor, 2);
		tdvet2.start();
	}
}
