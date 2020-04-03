package com.politecnicomalaga.algoritmos;

import java.security.NoSuchAlgorithmException;

public interface IAlgoritmo {

    public String getPasswordHash(String password, String salt) throws NoSuchAlgorithmException;
    public boolean verifyPassword(String password, String passwordHash, String salt) throws NoSuchAlgorithmException;
    public String getSalt();
}
