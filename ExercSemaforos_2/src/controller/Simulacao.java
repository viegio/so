package controller;

import view.Main;

public class Simulacao extends Thread{
	private int i;
	public Simulacao(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		int res;
		
		res = i % 2;
		
		//lasanha
		if (res == 0) {
			int sec_coz = (int)(Math.random() * 601) + 600;
			String prato = "lasanha";
			
			cozinhar(sec_coz, prato);
			
			try {
				Main.semaforo.acquire();
				entregar(prato);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				Main.semaforo.release();
			}
		}
		
		//sopa de cebola
		else {
			int sec_coz = (int)(Math.random() * 501) + 300;
			String prato = "sopa de cebola";
			
			cozinhar(sec_coz, prato);
			
			try {
				Main.semaforo.acquire();
				entregar(prato);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				Main.semaforo.release();
			}
		}

	}



	private void cozinhar(int sec_coz, String prato) {
		int t = sec_coz;
		double coz = 0; 
		double perc;
		
		System.out.println("Cozimento do prato `"+ prato + "` iniciado!");
		
		while (coz < t) {
			coz += 100;
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			perc = (1 - ((t-coz)/t))*100;
			if (perc > 100) {
				System.out.println(prato +" 100% concluído");
			}
			else{
				System.out.println(prato+ " "+(int)perc +"% concluído");
			}
		}
		System.out.println(prato +" finalizado!");
		
		
	}
	
	private void entregar(String prato) {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(prato + " entregue");
	}
}