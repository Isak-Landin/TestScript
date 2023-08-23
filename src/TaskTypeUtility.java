import org.dreambot.api.data.requirements.SkillRequirement;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.utilities.Logger;

import java.awt.*;

public class TaskTypeUtility {

    // Fishing Requirements
    private static final SkillRequirement FISHING_LEVEL_SHRIMP = new SkillRequirement(Skill.FISHING, 1);
    private static final SkillRequirement FISHING_LEVEL_SARDINE = new SkillRequirement(Skill.FISHING, 5);
    private static final SkillRequirement FISHING_LEVEL_HERRING = new SkillRequirement(Skill.FISHING, 10);
    private static final SkillRequirement FISHING_LEVEL_TROUT = new SkillRequirement(Skill.FISHING, 20);
    private static final SkillRequirement FISHING_LEVEL_SALMON = new SkillRequirement(Skill.FISHING, 25);


    // Cooking Requirements
    private static final SkillRequirement COOKING_LEVEL_SHRIMP = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_SARDINE = new SkillRequirement(Skill.COOKING, 1);
    private static final SkillRequirement COOKING_LEVEL_HERRING = new SkillRequirement(Skill.COOKING, 5);
    private static final SkillRequirement COOKING_LEVEL_TROUT = new SkillRequirement(Skill.COOKING, 15);
    private static final SkillRequirement COOKING_LEVEL_SALMON = new SkillRequirement(Skill.COOKING, 25);


    // Stop Burning Requirements
    private static final SkillRequirement STOP_BURNING_SHRIMP = new SkillRequirement(Skill.COOKING, 34);
    private static final SkillRequirement STOP_BURNING_SARDINE = new SkillRequirement(Skill.COOKING, 38);
    private static final SkillRequirement STOP_BURNING_HERRING = new SkillRequirement(Skill.COOKING, 41);
    private static final SkillRequirement STOP_BURNING_TROUT = new SkillRequirement(Skill.COOKING, 49);
    private static final SkillRequirement STOP_BURNING_SALMON = new SkillRequirement(Skill.COOKING, 58);


    // Tools
    private static final int[] SHRIMP_FISHING_TOOLS = TaskRelatedItemIDs.ShrimpTools;
    private static final int[] SARDINE_FISHING_TOOLS = TaskRelatedItemIDs.SardineTools;
    private static final int[] HERRING_FISHING_TOOLS = TaskRelatedItemIDs.HerringTools;
    private static final int[] TROUT_FISHING_TOOLS = TaskRelatedItemIDs.TroutTools;
    private static final int[] SALMON_FISHING_TOOLS = TaskRelatedItemIDs.SalmonsTools;


    public static FishingTask decideTaskType() {
        FishingTask[] tasks = FishingTask.values();
        for (FishingTask task : tasks) {
            if (meetsFishingRequirement(task) && meetsCookingRequirement(task) && willItBurn(task)) {
                return task;
            }
        }
        return FishingTask.NO_TASK;
    }

    public static int[] correctToolsForTask(){
        TaskTypeUtility.FishingTask myFishingTask = TaskTypeUtility.decideTaskType();

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
        SALMON,
        NO_TASK
    }

    private static boolean willItBurn(FishingTask _task){
        return switch (_task) {
            case SHRIMPS -> !STOP_BURNING_SHRIMP.meetsRequirement();
            case SARDINE -> !STOP_BURNING_SARDINE.meetsRequirement();
            case HERRING -> !STOP_BURNING_HERRING.meetsRequirement();
            case TROUT -> !STOP_BURNING_TROUT.meetsRequirement();
            case SALMON -> !STOP_BURNING_SALMON.meetsRequirement();
            default -> false;
        };
    }

    private static boolean meetsFishingRequirement(FishingTask task) {
        return switch (task) {
            case SHRIMPS -> FISHING_LEVEL_SHRIMP.meetsRequirement();
            case SARDINE -> FISHING_LEVEL_SARDINE.meetsRequirement();
            case HERRING -> FISHING_LEVEL_HERRING.meetsRequirement();
            case TROUT -> FISHING_LEVEL_TROUT.meetsRequirement();
            case SALMON -> FISHING_LEVEL_SALMON.meetsRequirement();
            default -> false;
        };
    }

    private static boolean meetsCookingRequirement(FishingTask task) {
        return switch (task) {
            case SHRIMPS -> COOKING_LEVEL_SHRIMP.meetsRequirement();
            case SARDINE -> COOKING_LEVEL_SARDINE.meetsRequirement();
            case HERRING -> COOKING_LEVEL_HERRING.meetsRequirement();
            case TROUT -> COOKING_LEVEL_TROUT.meetsRequirement();
            case SALMON -> COOKING_LEVEL_SALMON.meetsRequirement();
            default -> false;
        };
    }

    private static int myFishingLevel(){
        return Skills.getRealLevel(Skill.FISHING);
    }

    private static int myCookingLevel(){
        return Skills.getRealLevel(Skill.COOKING);
    }
}
