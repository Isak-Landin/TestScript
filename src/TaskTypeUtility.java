import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

public class TaskTypeUtility {
    public int myFishingLevel(){
        return Skills.getRealLevel(Skill.FISHING);
    }

    public int myCookingLevel(){
        return Skills.getRealLevel(Skill.COOKING);
    }
}
