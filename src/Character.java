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
                    return 75;
                case 0:
                    return 200;
                case 3:
                    return 30;
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
                return 300;
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

    public static int getPunchDamage(int character) {
        int damage = 0;
        if (character == 0) {
            damage = 4;
        } else if (character == 1) {
            damage = 4;
        } else if (character == 2) {
            damage = 4;
        } else if (character == 3) {
            damage = 2;
        } else if (character == 4) {
            damage = 4;
        } else if (character == 5) {
            damage = 4;
        } else if (character == 6) {
            damage = 4;
        } else if (character== 7) {
            damage = 4;
        }
        return damage;
    }

    public static int getKickDamage(int character) {
        int damage = 0;
        if (character == 0) {
            damage = 8;
        } else if (character == 1) {
            damage = 8;
        } else if (character == 2) {
            damage = 8;
        } else if (character == 3) {
            damage = 4;
        } else if (character == 4) {
            damage = 8;
        } else if (character == 5) {
            damage = 8;
        } else if (character == 6) {
            damage = 8;
        } else if (character== 7) {
            damage = 8;
        }
        return damage;
    }

    public static int getSpecialDamage(int character) {
        int damage = 0;
        if (character == 0) {
            damage = 15;
        } else if (character == 1) {
            damage = 15;
        } else if (character == 2) {
            damage = 15;
        } else if (character == 3) {
            damage = 5;
        } else if (character == 4) {
            damage = 15;
        } else if (character == 5) {
            damage = 15;
        } else if (character == 6) {
            damage = 15;
        } else if (character== 7) {
            damage = 15;
        }
        return damage;
    }
}
