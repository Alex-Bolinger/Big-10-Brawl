public class Character {

    public final static int PURDUE_PETE = 0;
    public final static int HERKY_THE_HAWKEYE = 1;
    public final static int BUCKY_THE_BADGER = 2;
    public final static int HOOSIER = 3;
    public final static int BRUTUS_THE_BUCKEYE = 4;
    public final static int SPARTY_THE_SPARTAN = 5;
    public final static int WOLVERINE = 6;
    public final static int GOLDY_GOPHER = 7;

    public static int getSpeed(int character) {
        switch (character) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                System.out.println("Please select a valid character.");
                return -1;
        }
    }

    public static int getHealth(int character) {

            switch (character) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                default:
                    System.out.println("Please select a valid character.");
                    return -1;
            }
    }

    public static int getCharge(int character) {
        switch (character) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                System.out.println("Please select a valid character.");
                return -1;
        }
    }

}
