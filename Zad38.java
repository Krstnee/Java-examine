import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

public class Zad38 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String SECRET_KEY = "mysecretkey"; // Секретный ключ (16 символов для AES-128)

    public static void main(String[] args) {
        String inputFile = "input.txt"; // Входной файл
        String encryptedFile = "encrypted.txt"; // Файл для сохранения зашифрованных данных

        try {
            byte[] key = generateKey(SECRET_KEY); // Генерация ключа из секретного ключа

            // Шифрование файла
            encrypt(inputFile, encryptedFile, key);
            System.out.println("Шифрование завершено.");

            // Дешифрование файла
            String decryptedFile = "decrypted.txt"; // Файл для сохранения расшифрованных данных
            decrypt(encryptedFile, decryptedFile, key);
            System.out.println("Дешифрование завершено.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Генерация ключа из секретного ключа
    private static byte[] generateKey(String secretKey) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = sha.digest(secretKey.getBytes("UTF-8"));
        return Arrays.copyOf(key, 16); // Возвращаем 16-байтовый ключ для AES-128
    }

    // Шифрование файла с использованием AES
    private static void encrypt(String inputFile, String encryptedFile, byte[] key) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, encryptedFile, key);
    }

    // Дешифрование файла с использованием AES
    private static void decrypt(String inputFile, String decryptedFile, byte[] key) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, decryptedFile, key);
    }

    // Общий метод для шифрования/дешифрования данных
    private static void doCrypto(int cipherMode, String inputFile, String outputFile, byte[] key) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            byte[] inputBytes = new byte[(int) new File(inputFile).length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            outputStream.write(outputBytes);
        }
    }
}
