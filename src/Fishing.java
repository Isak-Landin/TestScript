import org.dreambot.api.methods.container.impl.Inventory;

public class Fishing extends Node{
    @Override
    public boolean validate(){
        return !Inventory.isFull() && BankManagerSystem.allTaskRelatedToolsInInventory();
    }

    @Override
    public void execute(){
        double allowedDistanceFromFishingSpot = LocationManager.maximumAllowedDistanceForFishingTask(TaskTypeUtility.decideTaskType());
        if(MovingUtility.GoToLocation(allowedDistanceFromFishingSpot, LocationManager.decideWhereToFish())){
            if (FishingManager.doIHaveAllToolsNeeded(TaskTypeUtility.decideTaskType())){

            }
        }

    }
}