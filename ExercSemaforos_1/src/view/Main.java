package view;
import java.util.concurrent.Semaphore;
import controller.Servidor;

public class Main {
	public static Semaphore semaforo = new Semaphore(1);
	
	public static void main(String[] args) {
		
		//iniciar threads
		for (int i=0; i<22; i++) {
			
			Servidor serv = new Servidor(i);
			serv.start();
		}
	}
}