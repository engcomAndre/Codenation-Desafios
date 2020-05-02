package challenge;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    /**
     *
     */
    private static List<Character> noMapChars = new ArrayList<>();
    private static Integer role = 0;

    static String encrypt(String texto, Integer role) {
        CaesarCipher.role = role;
        return swapChars(texto);
    }

    static String decrypt(String texto, Integer role) {
        CaesarCipher.role = role * -1;
        return swapChars(texto);
    }

    private static String swapChars(String texto) {
        StringBuilder res = new StringBuilder();
        for (char ch : texto.toCharArray()) {
            int chInt = ((int) ch + role);
            if (chInt < 97) chInt += 26;
            if (chInt > 122) chInt -= 26;
            res.append(noMapChars.contains(ch) ? ch : (char) (chInt));
        }
        return res.toString();
    }

    static void setNoMappedChars(List<Character> noMappedChars) {
        noMapChars.addAll(noMappedChars);
    }
}