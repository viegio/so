package view;
import java.util.concurrent.Semaphore;

import controller.TdSapo;

public class Main {
	public static int fim;
	public static String podio[] = new String[5];
	
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		int i;
		fim = 0;
		
		System.out.println("CORRIDA DE SAPOS\nPULO M�XIMO: 10M - DIST�NCIA: 1000M\nCOME�AR!");
		//iniciar threads
		for (i=0;i<5;i++) {
			TdSapo sapo = new TdSapo(i, semaforo);
			sapo.start();
		}
	}
}
