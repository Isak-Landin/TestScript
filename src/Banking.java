import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.utilities.Sleep;

public class Banking extends Node{
    private static final int WALKING_ANIMATION = 1146; // Replace with the correct animation ID for walking
    private static final int RUNNING_ANIMATION = 11499; // Replace with the correct animation ID for running

    private static final int[] ITEMS_FOR_SHRIMPS = {1111, 2222, 3333, 4444};

    @Override
    public boolean validate(){
        return Inventory.isFull();
    }

    @Override
    public void execute() {

        Tile bankCenterTile = LocationManager.decideWhereToBank();
        double maximumAllowedDistanceBeforeBanking = 5.0;

        boolean hasReachedBank = MovingUtility.GoToLocation(maximumAllowedDistanceBeforeBanking, bankCenterTile);


        if (hasReachedBank) {
            while (!isPlayerInBankingState() && !Bank.isOpen()) {
                Bank.open();
                Sleep.sleep(1000, 2000);
            }

            if (Bank.isOpen()) {
                Sleep.sleep(500, 1200);
                depositItems();
                BankManagerSystem.withdrawBasedOnTaskMadeEasy();
            }
        }

    }

    private void depositItems(){
            Bank.depositAllExcept(TaskTypeUtility.correctToolsForTask());
    }

    private boolean isPlayerInBankingState() {
        int currentAnimation = Players.getLocal().getAnimation();
        return currentAnimation == WALKING_ANIMATION ||
                currentAnimation == RUNNING_ANIMATION ||
                Bank.isOpen();
    }
}
