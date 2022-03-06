package encryptor;

public class CaesarCipher implements IEncrypt {

    private int shift;

    public CaesarCipher(int shift){
        this.shift = shift;
    }

    /**
     * Encrypts a sequence of characters.
     *
     * @param value sequence of characters to encrypt.
     * @return encrypted result.
     */
    @Override
    public String encrypt(String value) {
        char[] charSequence = value.toCharArray();
        StringBuilder encryptedSequence = new StringBuilder();

        for(char character: charSequence){
            if(Character.isAlphabetic(character)){
                character = this.shiftChar(character);
            }
            encryptedSequence.append(character);
        }

        return encryptedSequence.toString();
    }

    /**
     * Specifies the value of the shift.
     * @return the shift value.
     */
    public int getShift() {
        return shift;
    }

    /**
     * Modifies the state of the shift value.
     * @param shift The new state of the shift value.
     */
    public void setShift(int shift) {
        this.shift = shift;
    }

    /**
     * Shifts a character position in the alphabet.
     * @param character The character to shift.
     * @return The shifted character.
     */
    private char shiftChar(char character) {
        boolean isUpper = (character >= 'A' && character <= 'Z');

        int characterIndex = this.parseAsciiToAlphabeticalIndex(character);

        characterIndex = (characterIndex + this.shift) % 26;

        return this.parseAlphabeticalIndexToAscii(characterIndex, isUpper);
    }

    /**
     * Unshift a character position in the alphabet.
     * @param character The character to unshift.
     * @return The new character.
     */
    private char unshiftChar(char character) {
        boolean isUpper = (character >= 'A' && character <= 'Z');

        int characterIndex = this.parseAsciiToAlphabeticalIndex(character);

        int conversion = characterIndex - this.shift;

        /*
            Because Java Modulo operation is not a "true" modulo operation as in Python but is
            a reminder modulo operation we should use Math.floorMod to replicate the same effect
            that a common modulo operation has when using negative numbers.
        */
        characterIndex = Math.floorMod(conversion, 26);

        return this.parseAlphabeticalIndexToAscii(characterIndex, isUpper);
    }

    /**
     * Parses an ASCII code to an alphabetical index.
     * Alphabetical index is the number of the letter position in the alphabet starting with 0.
     * @param character The ASCII letter to parse.
     * @return The alphabetical index.
     */
    private int parseAsciiToAlphabeticalIndex(char character){
        int parseOperation;

        if(character >= 'A' && character <= 'Z') {
            parseOperation = (int) character - 65;
        }else{
            parseOperation = (int) character - 97;
        }

        return parseOperation;
    }

    /**
     * Parses an alphabetical index position to the alphabetical code in ASCII.
     * @param index The alphabetical index of the character.
     * @param isUpper If the character is uppercase should be true.
     * @return The ASCII code of the specified character index.
     */
    private char parseAlphabeticalIndexToAscii(int index, boolean isUpper){
        int parseOperation;

        if(isUpper) {
            parseOperation = index + 65;
        }else{
            parseOperation = index + 97;
        }

        return (char) parseOperation;
    }

    /**
     * Decrypts a sequence of characters.
     *
     * @param value sequence of characters to decrypt.
     * @return decrypted result.
     */
    @Override
    public String decrypt(String value) {
        char[] charSequence = value.toCharArray();

        StringBuilder encryptedSequence = new StringBuilder();

        for(char character: charSequence){
            if(Character.isAlphabetic(character)){
                character = this.unshiftChar(character);
            }
            encryptedSequence.append(character);
        }

        return encryptedSequence.toString();
    }
}
