package controller;

import view.Main;

public class TdSapo extends Thread {
	private int i;
	
	//construtor
	public TdSapo(int i) {
		this.i = i;
	}
	
	//executar
	@Override
	public void run() {
		double pulo=0.0, dist=10.0, percorrido=0;
		
		while (percorrido<dist) {
			pulo = (Math.random() * 10) % 2;
			percorrido = percorrido + pulo;
			
			if (percorrido > dist) {
				pulo = pulo - (percorrido - dist);
				percorrido = percorrido - (percorrido - dist);
			}
			
			//pulo = Double.parseDouble(df.format(pulo));
			System.out.println("Sapo"+(i+1) + " ==> "+ "Pulo: "+pulo + " Percorrido: " + percorrido);
		}
		System.out.println("Sapo"+(i+1)+" Chegou ao final! " + (Main.fim+1) + "º lugar!");
		Main.fim = Main.fim + 1;
	}
}
