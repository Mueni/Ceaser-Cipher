import org.junit.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;
class DecryptTest {
    @Test
    void newDecrypt_instantiates_correctly() {
        Decrypt newDecrypt = new Decrypt("message from user", 12);
        assertTrue(newDecrypt instanceof Decrypt);
    }

    @Test
    public void testDecryptWithShift20() {
        Decrypt newDecrypt = new Decrypt("BYFFI QILFX", 20);
        String expectedResultMessage = "Hello world";
        String actualResultMessage = newDecrypt.decryptMessage()

        assertEquals(expectedResultMessage, actualResultMessage);
    }


    @Test
    public void testDecryptWithShift_16() {
        Decrypt newDecrypt = new Decrypt("ROVVY GYBVN", -16);
        String expectedResultMessage = "Hello world";
        String actualResultMessage = newDecrypt.decryptMessage()

        assertEquals(expectedResultMessage, actualResultMessage);
    }

    @Test
    public void testDecryptWithPunctuation(){
        Decrypt newDecrypt = new Decrypt("IFMMP, XPSME!", 1);
        String expectedResultMessage = "Hello world";
        String actualResultMessage = newDecrypt.decryptMessage()

        assertEquals(expectedResultMessage, actualResultMessage);
    }

}