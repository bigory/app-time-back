package com.example.demo.entity;

import java.util.NoSuchElementException;

public enum Role {

    USER(1), ADMIN(2);

    private final int id;

    Role(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public static Role valueOfId(int id) {
        if (id == 1) {
            return Role.USER;
        } else if (id == 2) {
            return Role.ADMIN;
        } else {
            throw new NoSuchElementException();
        }
    }
}
