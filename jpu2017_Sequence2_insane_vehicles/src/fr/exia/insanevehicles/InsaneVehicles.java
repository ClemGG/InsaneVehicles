package fr.exia.insanevehicles;

import java.io.FileNotFoundException;

/**
 * <h1>The Class InsaneVehicles.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class InsaneVehicles {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws FileNotFoundException 
     */
    public static void main(final String[] args) throws FileNotFoundException {
        final InsaneVehiclesGames insaneVehiclesGame = new InsaneVehiclesGames();
        insaneVehiclesGame.Play();

    }
}
