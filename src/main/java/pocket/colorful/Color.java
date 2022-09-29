package pocket.colorful;

import java.util.ArrayList;

public class Color {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static String black(Object x) {
        return ANSI_BLACK + x.toString() + ANSI_RESET;
    }

    public static String red(Object x) {
        return ANSI_RED + x.toString() + ANSI_RESET;
    }

    public static String green(Object x) {
        return ANSI_GREEN + x.toString() + ANSI_RESET;
    }

    public static String yellow(Object x) {
        return ANSI_YELLOW + x.toString() + ANSI_RESET;
    }

    public static String blue(Object x) {
        return ANSI_BLUE + x.toString() + ANSI_RESET;
    }

    public static String purple(Object x) {
        return ANSI_PURPLE + x.toString() + ANSI_RESET;
    }

    public static String cyan(Object x) {
        return ANSI_CYAN + x.toString() + ANSI_RESET;
    }

    public static String white(Object x) {
        return ANSI_WHITE + x.toString() + ANSI_RESET;
    }
}
