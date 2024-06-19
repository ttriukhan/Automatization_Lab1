import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*
2) Створити 3 хеш результати SecureRandom і 3-ох різних алгоритмів
4) Зберегти результати хешів у текстовий файл в репозиторії
 */

public class SecureRandomHash {

    public static String generateRandomSHA1PRNG(String input) throws NoSuchAlgorithmException {
        return generateRandom(input, "SHA1PRNG");
    }

    public static String generateRandomDRBG(String input) throws NoSuchAlgorithmException {
        return generateRandom(input, "DRBG");
    }

    public static String generateRandomWindowsPRNG(String input) throws NoSuchAlgorithmException {
        return generateRandom(input, "Windows-PRNG");
    }

    private static String generateRandom(String input, String algorithm) throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(algorithm);
        sr.setSeed(input.getBytes());
        byte[] resultInBytes = new byte[16];
        sr.nextBytes(resultInBytes);
        StringBuilder result = new StringBuilder();
        for (byte b: resultInBytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

}
