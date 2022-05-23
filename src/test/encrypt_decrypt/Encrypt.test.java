import org.junit.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;


class EncryptTest {
    @Test
    void newEncrypt_instantiates_correctly() {
        Encrypt newEncrypt = new Encrypt("message from user", 12);
        assertTrue(newEncrypt instanceof Encrypt);
    }

    //Test wth shift of 20
    @Test
    public void testEncryptWithShift20() {
        Encrypt newEncrypt = new Encrypt("Hello world", 20);
        String expectedResultMessage = "BYFFI QILFX";
        String actualResultMessage = newEncrypt.encryptMessage();
        assertEquals(expectedResultMessage, actualResultMessage);
    }

    //Tes with a negative shift value
    @Test
    public void testEncryptWithShift_16() {
        Encrypt newEncrypt = new Encrypt("Hello world", -16);
        String expectedResultMessage = "ROVVY GYBVN";
        String actualResultMessage = newEncrypt.encryptMessage();
        assertEquals(expectedResultMessage, actualResultMessage);
    }

    //Test of input with punctuation
    @Test
    public void testEncryptWithPuntuation() {
        Encrypt newEncrypt = new Encrypt("Hello, world!", 1);
        String expectedResultMessage = "IFMMP XPSME";
        String actualResultMessage = newEncrypt.encryptMessage();
        assertEquals(expectedResultMessage, actualResultMessage);
    }


}