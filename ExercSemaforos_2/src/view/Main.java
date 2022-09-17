package view;

import java.util.concurrent.Semaphore;
import controller.Simulacao;

public class Main {
	public static Semaphore semaforo = new Semaphore(1);
	
	public static void main(String[] args) {
		
		//iniciar threads
		for (int i=0; i<5; i++) {
			Simulacao sim = new Simulacao(i);
			sim.start();
		}
	}
}