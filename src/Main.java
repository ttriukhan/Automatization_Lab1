import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args) {

        System.out.println("MessageDigestHash___________________________________________________________________\n");
        String hashSHA1 = "";
        String hashSHA256 = "";
        String hashSHA512 = "";
        try {
            hashSHA1 = MessageDigestHash.getHashValueSHA1("input");
            hashSHA256 = MessageDigestHash.getHashValueSHA256("input");
            hashSHA512 = MessageDigestHash.getHashValueSHA512("input");
        }catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        }
        System.out.println("SHA-1: " + hashSHA1 + "\n");
        System.out.println("SHA-256: " + hashSHA256 + "\n");
        System.out.println("SHA-512: " + hashSHA512 + "\n");


        System.out.println("\nSecureRandomHash____________________________________________________________________\n");
        String hashSHA1PRNG = "";
        String hashDRBG = "";
        String hashWindowsPRNG = "";
        try {
            hashSHA1PRNG = SecureRandomHash.generateRandomSHA1PRNG("input");
            hashDRBG = SecureRandomHash.generateRandomDRBG("input");
            hashWindowsPRNG = SecureRandomHash.generateRandomWindowsPRNG("input");
        }catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        }
        System.out.println("SHA1PRNG: " + hashSHA1PRNG + "\n");
        System.out.println("DRBG: " + hashDRBG + "\n");
        System.out.println("Windows-PRNG: " + hashWindowsPRNG + "\n");


        System.out.println("\nCorrect + incorrect classes_________________________________________________________\n");
        CorrectCircle cc1 = new CorrectCircle(1, "Pink");
        CorrectCircle cc2 = new CorrectCircle(100, "Blue");
        IncorrectCircle ic1 = new IncorrectCircle(1, "Pink");
        IncorrectCircle ic2 = new IncorrectCircle(100, "Blue");
        Map<CorrectCircle, String> correctMap = new HashMap<>();
        correctMap.put(cc1, "Pink Circle of radius 1");
        correctMap.put(cc2, "Blue Circle of radius 100");
        System.out.println("CorrectCircle map : \n" + correctMap);
        System.out.println("CorrectCircle map size: " + correctMap.size() + "\n");

        Map<IncorrectCircle, String> incorrectMap = new HashMap<>();
        incorrectMap.put(ic1, "Pink Circle of radius 1");
        incorrectMap.put(ic2, "Blue Circle of radius 100");
        System.out.println("IncorrectCircle map : \n" + incorrectMap);
        System.out.println("IncorrectCircle map size: " + incorrectMap.size());


        try (FileWriter writer = new FileWriter("hashes.txt")) {
            writer.write("MessageDigestHash___________________________________________________________________\n");
            writer.write("SHA-1: " + hashSHA1 + "\n");
            writer.write("SHA-256: " + hashSHA256 + "\n");
            writer.write("SHA-512: " + hashSHA512 + "\n");

            writer.write("\nSecureRandomHash____________________________________________________________________\n");
            writer.write("SHA1PRNG: " + hashSHA1PRNG + "\n");
            writer.write("DRBG: " + hashDRBG + "\n");
/*
            writer.write("Windows-PRNG: " + hashWindowsPRNG + "\n");
*/

            writer.write("\nCorrect + incorrect classes_________________________________________________________\n");
            writer.write("Correct hash: " + cc1 + " - " + cc1.hashCode() + "\n");
            writer.write("Correct hash: " + cc2 + " - " + cc2.hashCode() + "\n");
            writer.write("Incorrect hash: " + ic1 + " - " + ic1.hashCode() + "\n");
            writer.write("Incorrect hash: " + ic2 + " - " + ic2.hashCode() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
