package challenge;

import java.util.Arrays;

public class CriptografiaCesariana implements Criptografia {

    public static final Integer role = 3;

    public static void validarTexto(String texto) {
        String exceptionDescription = "O texto deve ser informado.";

        if (texto == null) throw new NullPointerException(exceptionDescription);
        if (texto.isEmpty()) throw new IllegalArgumentException(exceptionDescription);
    }

    @Override
    public String criptografar(String texto) {
        validarTexto(texto);
        String textToEncrypt = texto.toLowerCase();
        CaesarCipher.setNoMappedChars(Arrays.asList('.', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        return CaesarCipher.encrypt(textToEncrypt, role);
    }


    @Override
    public String descriptografar(String texto) {
        validarTexto(texto);
        String textToDecrypt = texto.toLowerCase();
        CaesarCipher.setNoMappedChars(Arrays.asList('.', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        return CaesarCipher.decrypt(textToDecrypt, role);
    }
}
