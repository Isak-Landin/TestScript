import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.wrappers.items.Item;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class BankManagerSystem {
    public static void withdrawBasedOnTaskMadeEasy() {
        int[] toolsToHave = WhatIsToBeKept();
        int[] toolsMissingFromInventory = WhatIsToBeWithdrawn();

        do {
            toolsMissingFromInventory = WhatIsToBeWithdrawn();
            for (int itemID : toolsMissingFromInventory) {
                if (itemID != 0) {
                    Bank.withdraw(itemID);
                    Sleep.sleep(100, 300);
                }
            }
            toolsMissingFromInventory = WhatIsToBeWithdrawn();
        } while (OtherUtilityMethods.doesArrayContainOnlyInt(toolsMissingFromInventory, 0));
    }

    private static int[] WhatIsToBeWithdrawn(){
        int[] toolsToHave = TaskTypeUtility.CorrectToolsForTask();

        return WhatItemsAreMissingFromInventory(toolsToHave);
    }

    private static int[] WhatIsToBeKept(){
        return TaskTypeUtility.CorrectToolsForTask();
    }

    private static int[] WhatItemsAreMissingFromInventory(int[] toolsToHave){
        int[] itemsMissingFromInventory = new int[toolsToHave.length];

        // Let's make item ids represent an item missing, and let's make 0's represent
        // That way we won't have to indulge in extending or removing indexes from lists, since the max amount of items missing is toolsToHave.length
        for (int j : toolsToHave) {
            boolean itemIsInInventory = Inventory.contains(j);

            if (!itemIsInInventory) {
                int indexCounter = 0;
                for (int i: itemsMissingFromInventory){
                    if(i == 0){
                        itemsMissingFromInventory[indexCounter] = j;
                        indexCounter += 1;
                        break;
                    }
                }
            }
        }

        return itemsMissingFromInventory;
    }

}
