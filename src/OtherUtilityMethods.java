public class OtherUtilityMethods {
    public static boolean doesArrayContainInt(int[] array_of_ints, int int_to_look_for){
        for (int intForIndex: array_of_ints){
            if (intForIndex == int_to_look_for){
                return true;
            }
        }
        return false;
    }

    public static boolean doesArrayContainOnlyInt(int[] array_of_ints, int int_to_be_alone){
        for (int intForIndex: array_of_ints){
            if (intForIndex != int_to_be_alone){
                return false;
            }
        }
        return true;
    }
}
