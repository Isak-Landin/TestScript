import org.dreambot.api.methods.container.impl.Inventory;

public class Fishing extends Node{
    @Override
    public boolean validate(){
        if (!Inventory.isFull()){
            double allowedDistanceFromFishingSpot =
            MovingUtility.GoToLocation()
        }
    }

    @Override
    public void execute(){

    }
}