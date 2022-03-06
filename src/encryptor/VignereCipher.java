package encryptor;

public class VignereCipher implements IEncrypt {
    private String key;

    public VignereCipher(String key){
        this.key = key;
    }
    /**
     * Encrypts a sequence of characters.
     *
     * @param value sequence of characters to encrypt.
     * @return encrypted result.
     */
    @Override
    public String encrypt(String value) {
        StringBuilder res = new StringBuilder();
        value= value.toUpperCase();
        for (int i = 0, j = 0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }

    /**
     * Decrypts a sequence of characters.
     *
     * @param value sequence of characters to decrypt.
     * @return decrypted result.
     */
    @Override
    public String decrypt(String value) {
        StringBuilder res = new StringBuilder();
        value = value.toUpperCase();
        for (int i = 0, j = 0; i < value.length(); i++)
        {
            char c = value.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }
}

