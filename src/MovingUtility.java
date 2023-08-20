import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;

import java.util.Random;

public class MovingUtility{
    private static double distance(Tile tile){
        return Players.getLocal().distance(tile);
    }

    /**
     * Determines if the target tile has been reached based on the maximum allowed distance.
     *
     * @param maximumAllowedDistance The maximum distance away from the target tile that is allowed
     *                               without triggering a walk action.
     * @param tile The target tile or destination.
     * @return True if the target has been reached; False otherwise.
     */
    public static boolean GoToLocation(double maximumAllowedDistance, Tile tile){
        if (distance(tile) > maximumAllowedDistance){
            toggleRun();
            moveTowardsLocation(tile);
            return false;
        }
        return true;
    }

    private static void moveTowardsLocation(Tile tile){
        Walking.walk(tile);
    }

    private static void toggleRun(){
        int runEnergy = Walking.getRunEnergy();
        Random randomObject = new Random();
        int runEnergyToToggleOn = randomObject.nextInt(50);

        if (runEnergy > runEnergyToToggleOn && !Walking.isRunEnabled()) {
            Walking.toggleRun();
        }
    }
}
