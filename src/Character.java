public class Character {

    public final static int PURDUE_PETE = 0;
    public final static int HERKY_THE_HAWK = 1;
    public final static int BUCKY_BADGER = 2;
    public final static int HOOSIER = 3;
    public final static int BRUTUS_BUCKEYE = 4;
    public final static int SPARTY = 5;
    public final static int WOLVERINE = 6;
    public final static int GOLDY_GOPHER = 7;

    public static int getSpeed(int character) {
        switch (character) {
            case 1 :
            case 2 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
                return 100;

            case 0:
                return 150;
            case 3:
                return 50;
            default:
                System.out.println("Please select a valid character.");
                return -1;
        }
    }

    public static int getHealth(int character) {

            switch (character) {
                case 1 :
                case 2 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                    return 100;
                case 0:
                    return 200;
                case 3:
                    return 1;
                default:
                    System.out.println("Please select a valid character.");
                    return -1;
            }
    }

    public static int getMaxCharge(int character) {
        switch (character) {
            case 0 :
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
                return 100;
            default:
                System.out.println("Please select a valid character.");
                return -1;
        }
    }

    public static String getCharacterName(int character) {
        if (character == 0) {
            return "PURDUE_PETE";
        } else if (character == 1) {
            return "HERKY_THE_HAWK";
        } else if (character == 2) {
            return "BUCKY_BADGER";
        } else if (character == 3) {
            return "HOOSIER";
        } else if (character == 4) {
            return "BRUTUS_BUCKEYE";
        } else if (character == 5) {
            return "SPARTY";
        } else if (character == 6) {
            return "WOLVERINE";
        } else {
            return "GOLDY_GOPHER";
        }
    }

}
