package kdf;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KDF;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.HKDFParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

class KDFExample {
  private static final String TRANSFORMATION = "AES/GCM/NoPadding";
  private static final int GCM_TAG_LENGTH = 128;

  void main() throws NoSuchAlgorithmException,
      InvalidAlgorithmParameterException,
      NoSuchPaddingException,
      IllegalBlockSizeException,
      BadPaddingException,
      InvalidKeyException {
    // yes, for some reason you can use emoticons in passwords
    String password = "s3cr3t💩";
    String plaintext = "Hello, World!";

    byte[] salt = new byte[32];
    new SecureRandom().nextBytes(salt);

    KDF kdf = KDF.getInstance("HKDF-SHA256");
    HKDFParameterSpec params = HKDFParameterSpec.ofExtract()
        .addIKM(password.getBytes(StandardCharsets.UTF_8))
        .addSalt(salt)
        .thenExpand("enc".getBytes(), 32);

    byte[] keyBytes = kdf.deriveData(params);
    byte[] ciphertext = encrypt(plaintext, keyBytes);
    String decrypted = decrypt(ciphertext, keyBytes);

    IO.println("Original: " + plaintext);
    IO.println("Decrypted: " + decrypted);
    IO.println("Match: " + plaintext.equals(decrypted));
  }

  private static byte[] encrypt(String plaintext, byte[] keyBytes) throws NoSuchPaddingException,
      NoSuchAlgorithmException,
      InvalidAlgorithmParameterException,
      InvalidKeyException,
      IllegalBlockSizeException,
      BadPaddingException {
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    byte[] iv = new byte[12];
    new SecureRandom().nextBytes(iv);
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), new GCMParameterSpec(GCM_TAG_LENGTH, iv));
    byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    byte[] cipherAndIv = new byte[iv.length + encrypted.length];
    System.arraycopy(iv, 0, cipherAndIv, 0, iv.length);
    System.arraycopy(encrypted, 0, cipherAndIv, iv.length, encrypted.length);
    return cipherAndIv;
  }

  private static String decrypt(byte[] cipherAndIv, byte[] keyBytes) throws NoSuchPaddingException,
      NoSuchAlgorithmException,
      InvalidAlgorithmParameterException,
      InvalidKeyException,
      IllegalBlockSizeException,
      BadPaddingException {
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    byte[] iv = new byte[12];
    System.arraycopy(cipherAndIv, 0, iv, 0, iv.length);
    byte[] encrypted = new byte[cipherAndIv.length - iv.length];
    System.arraycopy(cipherAndIv, iv.length, encrypted, 0, encrypted.length);
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), new GCMParameterSpec(GCM_TAG_LENGTH, iv));
    byte[] decrypted = cipher.doFinal(encrypted);
    return new String(decrypted, StandardCharsets.UTF_8);
  }
}