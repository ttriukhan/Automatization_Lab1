import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
1) Створити 3 хеш результати з використанням MessageDigest і 3-ох різних алгоритмів
4) Зберегти результати хешів у текстовий файл в репозиторії
*/

public class MessageDigestHash {

    public static String getHashValueSHA1(String input) throws NoSuchAlgorithmException {
        return getHashValue(input, "SHA-1");
    }

    public static String getHashValueSHA256(String input) throws NoSuchAlgorithmException {
        return getHashValue(input, "SHA-256");
    }

    public static String getHashValueSHA512(String input) throws NoSuchAlgorithmException {
        return getHashValue(input, "SHA-512");
    }

    private static String getHashValue(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] resultInBytes = md.digest(input.getBytes());
        StringBuilder result = new StringBuilder();
        for (byte b: resultInBytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

}
