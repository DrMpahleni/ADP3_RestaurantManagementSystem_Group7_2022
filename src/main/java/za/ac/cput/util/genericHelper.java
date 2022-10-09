package za.ac.cput.util;

import java.util.UUID;

public class genericHelper {

    public static String generateId() {

        return UUID.randomUUID().toString();
    }

    public static int generateIntId() {
        return UUID.randomUUID().toString().hashCode() & 0xffffff;
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }
    public static boolean isValid(String s){
        return s != null && s.trim() != "";
    }
    public static boolean isValid(int s){
        return s > 0;
    }
}
