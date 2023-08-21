import org.dreambot.api.wrappers.items.Item;

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
        return new int[0];
    }
}
