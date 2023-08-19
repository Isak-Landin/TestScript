import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(name = "Re-testing", description = "Just testing setup before building anything", author = "Isak, Jacob",
        version = 1.0, category = Category.COOKING, image = "")
public class TestScript extends AbstractScript {

    @Override
    public int onLoop() {
        return 0;
    }

}