import org.dreambot.api.data.requirements.SkillRequirement;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

public class TaskTypeUtility {

    private final SkillRequirement FISHING_LEVEL_SHRIMP = new SkillRequirement(Skill.FISHING, 1);
    private final SkillRequirement FISHING_LEVEL_ANCHOVIES = new SkillRequirement(Skill.FISHING, 15);
    private final SkillRequirement FISHING_LEVEL_SARDINE = new SkillRequirement(Skill.FISHING, 5);
    private final SkillRequirement FISHING_LEVEL_HERRING = new SkillRequirement(Skill.FISHING, 10);
    private final SkillRequirement COOKING_LEVEL_SHRIMP = new SkillRequirement(Skill.COOKING, 1);

    public FishingTask DecideTaskType(){
        int fishingLevel = myFishingLevel();
        int cookingLevel = myCookingLevel();
    }

    private enum FishingTask{
        SHRIMPS,
        ANCHOVIES,
        SARDINE,
        HERRING,

    }

    public int myFishingLevel(){
        return Skills.getRealLevel(Skill.FISHING);
    }

    public int myCookingLevel(){
        return Skills.getRealLevel(Skill.COOKING);
    }

    public int levelRequiredToFish(FishingTask fish){
        int level =
    }
}
