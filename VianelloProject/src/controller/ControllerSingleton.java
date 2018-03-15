package controller;

public class ControllerSingleton {

	private static IController gestore = null;
	
	protected static int istanze = 0;
	
	public static IController getIstance() {
		
		if(gestore == null) {
			
			gestore = new ControllerImpl();
	
		}
		
		return gestore;
	}
	
}
