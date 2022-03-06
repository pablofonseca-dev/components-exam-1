package encryptor;

public interface IEncrypt {
    /**
     * Encrypts a sequence of characters.
     * @param value sequence of characters to encrypt.
     * @return encrypted result.
     */
    public String encrypt(String value);

    /**
     * Decrypts a sequence of characters.
     * @param value sequence of characters to decrypt.
     * @return decrypted result.
     */
    public String decrypt(String value);
}
