package controller;

import view.Main;

public class Servidor extends Thread {
	private int i;

	public Servidor(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		int res;
		
		res = i % 3;
		
		if (res == 0) {
			
			for (int v = 0; v<2 ; v++) {
				int sec_calc = (int)(Math.random() * 201) + 1000;
				int sec_trans = 1000;
				
				calc(sec_calc);
				
				try {
					Main.semaforo.acquire();
					trans(sec_trans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Main.semaforo.release();
				}
			}
		}
		
		else if (res == 1) {
			for (int v = 0; v<3 ; v++) {
				int sec_calc = (int)(Math.random() * 501) + 1000;
				int sec_trans = 1500;
				
				calc(sec_calc);
				
				try {
					Main.semaforo.acquire();
					trans(sec_trans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Main.semaforo.release();
				}
			}
		}
		else if (res == 2) {
			for (int v = 0; v<3 ; v++) {
				int sec_calc = (int)(Math.random() * 1001) + 1000;
				int sec_trans = 1500;
				
				calc(sec_calc);
				
				try {
					Main.semaforo.acquire();
					trans(sec_trans);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Main.semaforo.release();
				}
			}
		}
	}

	private void calc(int sec_calc) {
		int t = sec_calc;
		
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread #"+(i+1)+": Calculando...");
	}
	
	private void trans(int sec_trans) {
		int t = sec_trans;
		
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread #"+(i+1)+": Fazendo transação com o BD");
	}
}