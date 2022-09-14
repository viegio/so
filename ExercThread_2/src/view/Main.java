package view;
import controller.ThreadsId;

public class Main {

	public static void main(String[] args) {
		for (int idThread = 0; idThread<5; idThread++) {
		//	ThreadsId threadid = new ThreadsId(idThread);
			Thread threadid = new ThreadsId();
			threadid.start();
		}
	}

}
