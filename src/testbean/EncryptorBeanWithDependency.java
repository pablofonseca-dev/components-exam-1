package testbean;

import encryptor.IEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptorBeanWithDependency {
    public IEncrypt encryptor;

    @Autowired
    public void setEncryptor(IEncrypt pEncryptor){
        this.encryptor = pEncryptor;
    }

    public void run(){
        String sampleString = "Hello World, I would like to eat 10 pizzas!";
        System.out.println("Original text: " + sampleString);
        String encryptedText = encryptor.encrypt(sampleString);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + encryptor.decrypt(encryptedText));
    }
}
