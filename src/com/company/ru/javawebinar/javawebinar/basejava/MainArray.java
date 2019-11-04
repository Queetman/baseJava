package com.company.ru.javawebinar.javawebinar.basejava;

import com.company.ru.javawebinar.javawebinar.basejava.model.Resume;

public class MainArray {

    private static Resume[] storage = new Resume[10000];

    public static Resume[] getStorage() {
        return storage;
    }
}
