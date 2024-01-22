import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;

public class Myclass {

    public static void encryption() {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            KeyGenerator keyg = KeyGenerator.getInstance("DES");
            Key key = keyg.generateKey();

            // Encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);
            CipherInputStream cipt = new CipherInputStream(new FileInputStream(new File("D:\\encryptdecrypt\\input.jpg")));
            FileOutputStream fileip = new FileOutputStream(new File("D:\\encryptdecrypt\\encrypt.jpg"));

            int i;
            while ((i = cipt.read()) != -1) {
                fileip.write(cipher.update((byte) i));
            }

            fileip.write(cipher.doFinal());
            fileip.close();

            // Decryption
            cipher.init(Cipher.DECRYPT_MODE, key);
            CipherInputStream ciptt = new CipherInputStream(new FileInputStream(new File("D:\\encryptdecrypt\\encrypt.jpg")));
            FileOutputStream fileop = new FileOutputStream(new File("D:\\encryptdecrypt\\decrypt.jpg"));

            int j;
            while ((j = ciptt.read()) != -1) {
                fileop.write(cipher.update((byte) j));
            }

            fileop.write(cipher.doFinal());
            fileop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Myclass.encryption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
