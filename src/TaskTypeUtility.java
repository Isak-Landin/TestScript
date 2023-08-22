import org.dreambot.api.data.requirements.SkillRequirement;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.utilities.Logger;

import java.awt.*;

public class TaskTypeUtility {

    private static final SkillRequirement FISHING_LEVEL_SHRIMP = new SkillRequirement(Skill.FISHING, 1);
    private static final SkillRequirement FISHING_LEVEL_SARDINE = new SkillRequirement(Skill.FISHING, 5);
    private static final SkillRequirement FISHING_LEVEL_HERRING = new SkillRequirement(Skill.FISHING, 10);
    private static final SkillRequirement FISHING_LEVEL_TROUT = new SkillRequirement(Skill.FISHING, 20);
    private static final SkillRequirement FISHING_LEVEL_SALMON = new SkillRequirement(Skill.FISHING, 25);

    private static final SkillRequirement COOKING_LEVEL_SHRIMP = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_SARDINE = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_HERRING = new SkillRequirement(Skill.COOKING, 5);
    private static final SkillRequirement COOKING_LEVEL_TROUT = new SkillRequirement(Skill.COOKING, 15);
    private static final SkillRequirement COOKING_LEVEL_SALMON = new SkillRequirement(Skill.COOKING, 25);

    private static final SkillRequirement STOP_BURNING_SHRIMP = new SkillRequirement(Skill.COOKING, 34);
    private static final SkillRequirement STOP_BURNING_SARDINE = new SkillRequirement(Skill.COOKING, 38);
    private static final SkillRequirement STOP_BURNING_HERRING = new SkillRequirement(Skill.COOKING, 41);
    private static final SkillRequirement STOP_BURNING_TROUT = new SkillRequirement(Skill.COOKING, 49);
    private static final SkillRequirement STOP_BURNING_SALMON = new SkillRequirement(Skill.COOKING, 58);


    private static final int[] SHRIMP_FISHING_TOOLS = TaskRelatedItemIDs.ShrimpTools;
    private static final int[] SARDINE_FISHING_TOOLS = TaskRelatedItemIDs.SardineTools;
    private static final int[] HERRING_FISHING_TOOLS = TaskRelatedItemIDs.HerringTools;
    private static final int[] TROUT_FISHING_TOOLS = TaskRelatedItemIDs.TroutTools;
    private static final int[] SALMON_FISHING_TOOLS = TaskRelatedItemIDs.SalmonsTools;


    public static FishingTask DecideTaskType(){
        if (FISHING_LEVEL_HERRING.meetsRequirement() && COOKING_LEVEL_HERRING.meetsRequirement()){
            return FishingTask.HERRING;
        } else if (FISHING_LEVEL_SARDINE.meetsRequirement() && COOKING_LEVEL_SARDINE.meetsRequirement()){
            return FishingTask.SARDINE;
        } {
            return FishingTask.SHRIMPS;
        }
    }

    public static int[] correctToolsForTask(){
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
            case TROUT -> {
                return TROUT_FISHING_TOOLS;
            }
            case SALMON -> {
                return SALMON_FISHING_TOOLS;
            }
        }
        Logger.log(Color.RED, "This message showing means that when trying to determine the correct tools to withdraw; none of the cases were matched");
        Logger.log(Color.CYAN, myFishingTask);
        return SHRIMP_FISHING_TOOLS;
    }

    public enum FishingTask{
        SHRIMPS,
        SARDINE,
        HERRING,
        TROUT,
        SALMON

    }

    private static int myFishingLevel(){
        return Skills.getRealLevel(Skill.FISHING);
    }

    private static int myCookingLevel(){
        return Skills.getRealLevel(Skill.COOKING);
    }
}
