import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.wrappers.items.Item;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class BankManagerSystem {

    public static void withdrawBasedOnTaskMadeEasy() {
        int[] toolsMissingFromInventory = getItemsToBeWithdrawn();

        while (hasMissingItems(toolsMissingFromInventory)) {
            for (int itemID : toolsMissingFromInventory) {
                if (itemID != 0) {
                    Bank.withdraw(itemID);
                    Sleep.sleep(100, 300);
                }
            }
            toolsMissingFromInventory = getItemsToBeWithdrawn();
        }
    }

    public static boolean allTaskRelatedToolsInInventory(){
        return !hasMissingItems(getItemsToBeWithdrawn());
    }

    private static int[] getItemsToBeWithdrawn() {
        int[] toolsToHave = TaskTypeUtility.correctToolsForTask();
        return getMissingItemsFromInventory(toolsToHave);
    }

    private static int[] getMissingItemsFromInventory(int[] toolsToHave) {
        int[] itemsMissingFromInventory = new int[toolsToHave.length];

        int indexCounter = 0;
        for (int toolID : toolsToHave) {
            if (!Inventory.contains(toolID)) {
                itemsMissingFromInventory[indexCounter++] = toolID;
            }
        }

        return itemsMissingFromInventory;
    }

    private static boolean hasMissingItems(int[] items) {
        for (int item : items) {
            if (item != 0) {
                return true;
            }
        }
        return false;
    }
}
