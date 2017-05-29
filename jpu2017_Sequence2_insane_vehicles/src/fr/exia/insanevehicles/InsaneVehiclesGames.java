package fr.exia.insanevehicles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fr.exia.insanevehicles.element.Element;
import fr.exia.insanevehicles.element.mobile.MobileElement;
import fr.exia.insanevehicles.element.mobile.MobileElementFactory;
import fr.exia.insanevehicles.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Class InsaneVehiclesGames.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class InsaneVehiclesGames {

	/** The Constant ROAD_WIDTH. */
	// public static final int ROAD_WIDTH = 9;

	/** The Constant ROAD_HEIGHT. */
	// public static final int ROAD_HEIGHT = 40;

	/** The Constant ROAD_VIEW. */
	public static final int ROAD_VIEW = 15;

	/** The Constant ROAD_QUOTA. */
	public static final int ROAD_QUOTA = 20;

	/** The road. */
	private Road road;

	private MobileElement voiture;

	/**
	 * Instantiates a new insane vehicles games.
	 * 
	 * @throws FileNotFoundException
	 */
	public InsaneVehiclesGames() throws FileNotFoundException {
		// this.setRoad(new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW,
		// ROAD_QUOTA));
		this.setRoad(createRoad("res/road.txt"));
		addVehicleOnRoad();
	}

	public Road createRoad(String file) throws FileNotFoundException {
		// CHemin vers le fichier texte road.Txt
		File target = new File(file);
		// Ouverture du fichier

		Scanner input = new Scanner(target);

		int width = Integer.parseInt(input.nextLine());
		int height = Integer.parseInt(input.nextLine());

		// On crée la route
		Road road = new Road(width, height, ROAD_VIEW, ROAD_QUOTA);

		int y = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();

			for (int x = 0; x < width; x++) {
				// System.out.print(line.charAt(i));
				// Je récupère c à la pos x/y
				char c = line.charAt(x);
				// La factory me crée un élément à partir de c
				Element e = MotionlessElementsFactory.create(c);
				// On le place
				road.setOnTheRoadXY(e, x, y);

			}
			y++;
			// System.out.print(/*"Ligne " + (c++) + " : " +*/ line);
			// System.out.print(/*"Ligne " + (c++) + " : " +*/ line);
			// System.out.println(/*"Ligne " + (c++) + " : " +*/ line);
		}
		// Fermeture du fichier
		input.close();

		return road;
	}

	private void addVehicleOnRoad() {
		voiture = MobileElementFactory.createVehicle();
		
		this.getRoad().setOnTheRoadXY(voiture, getRoad().getWidth() / 2, 1);
	}

	public void Play() {
		while (true) {
			moveY(getVehicle(), 1);
			Utils.clearConsole();
			this.getRoad().show(0);
			Utils.sleep(1000);
		}
	}

		
	private MobileElement getVehicle() {
		// TODO Auto-generated method stub
		return voiture;
	}

	public void moveY(MobileElement element, int nbrDePas)
	{
		Coordinate coor = getRoad().getOnTheRoad(element);
		
		getRoad().removeOnTheRoad(coor, MotionlessElementsFactory.createMacadam());
		coor.AddY(nbrDePas);
		Element e = getRoad().removeOnTheRoad(coor, element);
		//TODO Implémenter ces fonctions
	}
	

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	public final Road getRoad() {
		return this.road;
	}

	/**
	 * Sets the road.
	 *
	 * @param road
	 *            the new road
	 */
	private void setRoad(final Road road) {
		this.road = road;
	}

}
