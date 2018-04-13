package it.contrader.dispositivo.main;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Thread> threads = new ArrayList();
		
		for(int i = 0; i<1; i++) {
			
			threads.add(new WorkerThread(i)); 
			threads.get(i).run();
			
			}
		
	}

}
