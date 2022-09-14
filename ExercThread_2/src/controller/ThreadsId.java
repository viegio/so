package controller;

public class ThreadsId extends Thread {
	
	public ThreadsId() {
		
	}

	@Override
	public void run() {
		System.out.println("TID ==> #" + getId());
	}
}
