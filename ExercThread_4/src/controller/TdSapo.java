package controller;
import java.util.concurrent.Semaphore;

import view.Main;

public class TdSapo extends Thread {
	
	private Semaphore semaforo;
	private int i;
	
	//construtor
	public TdSapo(int i, Semaphore semaforo) {
		this.i = i;
		this.semaforo = semaforo;
	}
	
	//executar
	@Override
	public void run() {
		pulo();
		
//		chegada();
		try {
			semaforo.acquire();
			chegada();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
//		podio();
		try {
			semaforo.acquire();
			podio();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void pulo() {
		double pulo=0.0, dist=1000.0, percorrido=0;
				
		while (percorrido<dist) {
			pulo = (Math.random() * 10) + 1;
			percorrido = percorrido + pulo;
			
			if (percorrido > dist) {
				pulo = pulo - (percorrido - dist);
				percorrido = percorrido - (percorrido - dist);
			}
			
			try {
				semaforo.acquire();
				//pulo = Double.parseDouble(df.format(pulo));
				System.out.println("Sapo #"+(i+1) + " ==> "+ "Pulo: "+pulo + " Percorrido: " + percorrido);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			
		}
	}
	
	private void chegada() {
		System.out.println("Sapo #"+(i+1)+" Chegou ao final! " + (Main.fim+1) + "º lugar!");
		Main.podio[Main.fim] = "Sapo #" + (i+1);
		Main.fim = Main.fim + 1;
	}
	
	private void podio() {
		if (Main.podio[4] != null) {
			System.out.println("-------------------------------PÓDIO-------------------------------");
			for (int p=0; p<5; p++) {
				System.out.println(p+1 + "º lugar: " + Main.podio[p]);
			}
		}
	}
}
