import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.items.Item;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class BankManagerSystem {


    public static int[] WhatIsToBeWithdrawn(){
        int[] toolsToHave = TaskTypeUtility.CorrectToolsForTask();

        int[] missingItems = WhatItemsAreMissingFromInventory(toolsToHave);

        return new int[0];
    }

    public static int[] WhatIsToBeKept(){
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
