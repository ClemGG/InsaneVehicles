package fr.exia.insanevehicles;

public class Utils {
	/**
	 * 
	 * @param delay En millisecondes
	 */
	public static void sleep(long delay){
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
}

	public static void clearConsole() {
		// TODO Auto-generated method stub
	/*	for(int x = 0; x < 50; x++)
		{
			System.out.println();
		}*/
		int repeat = 50;
		while(repeat-- > 0) System.out.println();
	}
}
