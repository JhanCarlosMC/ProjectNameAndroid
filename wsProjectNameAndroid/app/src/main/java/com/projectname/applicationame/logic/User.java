package com.projectname.applicationame.logic;

import java.io.Serializable;

public class User implements Serializable {
    private String nameUser;
    private String password;

    public User() {
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
