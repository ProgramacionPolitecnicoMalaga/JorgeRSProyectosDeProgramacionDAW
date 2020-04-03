package com.politecnicomalaga.algoritmos;

import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AlgoritmoSHA3_512 implements IAlgoritmo {

    MessageDigest messageDigest;
    public AlgoritmoSHA3_512() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA3-512");
    }

    @Override
    public String getSalt() {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return Hex.encodeHexString(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Salt!";
        }
    }

    @Override
    public String getPasswordHash(String password, String salt) throws NoSuchAlgorithmException {
            if (messageDigest == null)
                throw new NoSuchAlgorithmException("No existe el algoritmo de hash");
                        messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(password.getBytes());
            return new String(Hex.encodeHex(bytes));
    }

    @Override
    public boolean verifyPassword(String password, String passwordHash, String salt) throws NoSuchAlgorithmException {
            String nuevoHash = getPasswordHash(password,salt);
            return nuevoHash.equals(passwordHash);
    }
}
