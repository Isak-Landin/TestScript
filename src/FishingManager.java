import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.methods.filter.Filter;

import java.util.ArrayList;


public class FishingManager {
    private static final ArrayList<Integer> fishingOnTick = new ArrayList<>();
    private static final int animationForFishing = 1111;
    public static NPC getClosestFishingSpotOnLocation(Tile taskRelatedTile){
        Filter<NPC> fishingSpotFilter = npc -> npc.getName().equals("Fishing spot");
        return NPCs.closest(fishingSpotFilter, taskRelatedTile, true);
    }

    public static boolean isCurrentlyFishing(){
        int myAnimation = Players.getLocal().getAnimation();
        fishingOnTick.add(isIntThisInt(myAnimation));
        int size = fishingOnTick.size();
        if (size > 3){
            int lastValue = fishingOnTick.get(size - 1);
            int secondLastValue = fishingOnTick.get(size - 2);
            int thirdLastValue = fishingOnTick.get(size - 3);
            int fourthLastValue = fishingOnTick.get(size - 4);

            return lastValue == 1 || secondLastValue == 1 || thirdLastValue == 1 || fourthLastValue == 1;

        } else{
            return myAnimation == animationForFishing;
        }
    }

    private static int isIntThisInt(int integerToConvert){
        if (integerToConvert == FishingManager.animationForFishing){
            return 1;
        }
        return 0;
    }

    public static boolean doIHaveAllToolsNeeded(TaskTypeUtility.FishingTask currentTask){
        return BankManagerSystem.allTaskRelatedToolsInInventory();
    }
}
