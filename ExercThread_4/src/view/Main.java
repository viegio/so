package view;
import controller.TdSapo;

public class Main {
	public static int fim;
	public static String podio[] = new String[5];
	
	public static void main(String[] args) {
		int i;
		fim = 0;
		
		System.out.println("CORRIDA DE SAPOS\nPULO M�XIMO: 1.9M - DIST�NCIA: 10M\nCOME�AR!");
		//iniciar threads
		for (i=0;i<5;i++) {
			TdSapo sapo = new TdSapo(i);
			sapo.start();
		}
	}
}
