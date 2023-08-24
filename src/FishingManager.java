import org.dreambot.api.methods.interactive.Players;

public class FishingManager {
    private static final int animationForFishing = 1111;
    public static double getClosestFishingSpotOnLocation(){

    }

    public static boolean isCurrentlyFishing(){
        int myAnimation = Players.getLocal().getAnimation();
        return myAnimation == animationForFishing;
    }

    public static boolean doIHaveAllToolsNeeded(TaskTypeUtility.FishingTask currentTask){

    }
}
