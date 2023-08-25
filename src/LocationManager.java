import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Tile;
import java.util.Arrays;

public class LocationManager {
    private static final Tile SHRIMP_LOCATION = new Tile();
    private static final Tile SARDINE_LOCATION = new Tile();
    private static final Tile HERRING_LOCATION = new Tile();
    private static final Tile SALMON_AND_TROUT_LOCATION = new Tile();
    private static final Tile OVER_LEVELED_LOCATION = new Tile();
    private static final Tile BANK_SHRIMP_LOCATION = new Tile();
    private static final Tile BANK_SARDINE_LOCATION = new Tile();
    private static final Tile BANK_HERRING_LOCATION = new Tile();
    private static final Tile BANK_TROUT_LOCATION = new Tile();
    private static final Tile BANK_SALMON_LOCATION = new Tile();


    public static Tile decideWhereToFish(){
        return switch (TaskTypeUtility.decideTaskType()) {
            case SHRIMPS -> SHRIMP_LOCATION;
            case SARDINE -> SARDINE_LOCATION;
            case HERRING -> HERRING_LOCATION;
            case SALMONANDTROUT -> SALMON_AND_TROUT_LOCATION;
            default -> OVER_LEVELED_LOCATION;
        };
    }

    public static Tile decideWhereToBank(){
        Tile[] allBankLocations = {
                BANK_SHRIMP_LOCATION, BANK_SARDINE_LOCATION,
                BANK_HERRING_LOCATION, BANK_TROUT_LOCATION,
                BANK_SALMON_LOCATION
        };

        double[] distances = Arrays.stream(allBankLocations)
                .mapToDouble(Tile::distance)
                .toArray();

        int minIndex = 0;
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < distances[minIndex]) {
                minIndex = i;
            }
        }

        return allBankLocations[minIndex];
    }


}
