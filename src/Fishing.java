import org.dreambot.api.methods.container.impl.Inventory;

public class Fishing extends Node{
    @Override
    public boolean validate(){
        if (!Inventory.isFull()){
            double allowedDistanceFromFishingSpot = AllowedDistanceForLocationData.maximumAllowedDistanceForFishingTask();
            MovingUtility.GoToLocation();
        }
    }

    @Override
    public void execute(){

    }
}