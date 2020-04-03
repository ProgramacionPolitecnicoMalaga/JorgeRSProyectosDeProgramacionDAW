package com.politecnicomalaga.algoritmos;

import org.mindrot.jbcrypt.BCrypt;

public class AlgoritmoBcrypt implements IAlgoritmo {

    @Override
    public String getPasswordHash(String password, String salt) {
        return BCrypt.hashpw(password,getSalt());
    }

    @Override
    public boolean verifyPassword(String password, String passwordHash, String salt) {
        return BCrypt.checkpw(password,passwordHash);
    }

    @Override
    public String getSalt() {
        return BCrypt.gensalt(12);
    }
}
