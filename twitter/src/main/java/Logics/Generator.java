package Logics;

import java.util.Base64;

public class Generator {
    private static String[] set = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "w", "x", "y", "z"};

    public static String randomize(){

        String originalInput = "";
        for(int i = 0; i<12; i++){
            originalInput+=set[(int)(Math.random()*34)];
        }
        return Base64.getEncoder().encodeToString(originalInput.getBytes());
    }
}
