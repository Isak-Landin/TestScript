import org.dreambot.api.data.requirements.SkillRequirement;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.utilities.Logger;

import java.awt.*;

public class TaskTypeUtility {

    private static final SkillRequirement FISHING_LEVEL_SHRIMP = new SkillRequirement(Skill.FISHING, 1);
    private static final SkillRequirement FISHING_LEVEL_SARDINE = new SkillRequirement(Skill.FISHING, 5);
    private static final SkillRequirement FISHING_LEVEL_HERRING = new SkillRequirement(Skill.FISHING, 10);
    private static final SkillRequirement COOKING_LEVEL_SHRIMP = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_SARDINE = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_HERRING = new SkillRequirement(Skill.COOKING, 5);


    public static final int[] SHRIMP_FISHING_TOOLS = TaskRelatedItemIDs.ShrimpTools;
    public static final int[] SARDINE_FISHING_TOOLS = TaskRelatedItemIDs.SardineTools;
    public static final int[] HERRING_FISHING_TOOLS = TaskRelatedItemIDs.HerringTools;


    public static FishingTask DecideTaskType(){
        if (FISHING_LEVEL_HERRING.meetsRequirement() && COOKING_LEVEL_HERRING.meetsRequirement()){
            return FishingTask.HERRING;
        } else if (FISHING_LEVEL_SARDINE.meetsRequirement() && COOKING_LEVEL_SARDINE.meetsRequirement()){
            return FishingTask.SARDINE;
        } else {
            return FishingTask.SHRIMPS;
        }
    }

    public static int[] CorrectToolsForTask(){
        TaskTypeUtility.FishingTask myFishingTask = TaskTypeUtility.DecideTaskType();

        switch (myFishingTask) {
            case SHRIMPS -> {
                return SHRIMP_FISHING_TOOLS;
            }
            case SARDINE -> {
                return SARDINE_FISHING_TOOLS;
            }
            case HERRING -> {
                return HERRING_FISHING_TOOLS;
            }
        }
        Logger.log(Color.RED, "This message showing means that when trying to determine the correct tools to withdraw; none of the cases were matched");
        Logger.log(Color.CYAN, myFishingTask);
        return BankManagerSystem.SHRIMP_FISHING_TOOLS;
    }

    public enum FishingTask{
        SHRIMPS,
        SARDINE,
        HERRING,

    }

    private static int myFishingLevel(){
        return Skills.getRealLevel(Skill.FISHING);
    }

    private static int myCookingLevel(){
        return Skills.getRealLevel(Skill.COOKING);
    }
}
