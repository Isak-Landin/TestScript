public class AllowedDistanceForLocationData {
    /** Find out how to see if a fishing spot is x tiles away instead.*/
    private static final double allowedDistanceFromShrimpTile = 15;
    private static final double allowedDistanceFromSardineTile = 15;
    private static final double allowedDistanceFromHerringTile = 15;
    private static final double allowedDistanceFromSalmonAndTroutTile = 15;
    private static final double allowedDistanceFromGeneralFishingSpot = 15;


    public static double maximumAllowedDistanceForFishingTask(TaskTypeUtility.FishingTask myFishingTask){
        switch (myFishingTask){
            case SHRIMPS -> {
                return allowedDistanceFromShrimpTile;
            }
            case SARDINE -> {
                return allowedDistanceFromSardineTile;
            }
            case HERRING -> {
                return allowedDistanceFromHerringTile;
            }
            case SALMONANDTROUT -> {
                return allowedDistanceFromSalmonAndTroutTile;
            }
        }
        return allowedDistanceFromGeneralFishingSpot;
    }
}
