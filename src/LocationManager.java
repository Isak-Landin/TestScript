import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Tile;

public class LocationManager {
    private static final Tile SHRIMP_LOCATION = new Tile();
    private static final Tile SARDINE_LOCATION = new Tile();
    private static final Tile HERRING_LOCATION = new Tile();
    private static final Tile TROUT_LOCATION = new Tile();
    private static final Tile SALMON_LOCATION = new Tile();
    private static final Tile BANK_SHRIMP_LOCATION = new Tile();
    private static final Tile BANK_SARDINE_LOCATION = new Tile();
    private static final Tile BANK_HERRING_LOCATION = new Tile();
    private static final Tile BANK_TROUT_LOCATION = new Tile();
    private static final Tile BANK_SALMON_LOCATION = new Tile();


    public static Tile decideWhereToFish(){
        TaskTypeUtility.FishingTask fishingTask = TaskTypeUtility.DecideTaskType();
        switch (fishingTask){
            case SHRIMPS -> {
                return SHRIMP_LOCATION;
            }
            case SARDINE -> {
                return SARDINE_LOCATION;
            }
            case HERRING -> {
                return HERRING_LOCATION;
            }
        }
    }
}
