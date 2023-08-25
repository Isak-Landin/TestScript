import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.methods.filter.Filter;


public class FishingManager {
    private static final int animationForFishing = 1111;
    public static NPC getClosestFishingSpotOnLocation(Tile taskRelatedTile){
        Filter<NPC> fishingSpotFilter = npc -> npc.getName().equals("Fishing spot");
        return NPCs.closest(fishingSpotFilter, taskRelatedTile, true);
    }

    public static boolean isCurrentlyFishing(){
        int myAnimation = Players.getLocal().getAnimation();
        return myAnimation == animationForFishing;
    }

    public static boolean doIHaveAllToolsNeeded(TaskTypeUtility.FishingTask currentTask){

    }
}
