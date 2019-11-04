package com.company.ru.javawebinar.javawebinar.basejava.storage;

import com.company.ru.javawebinar.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.UUID;

public class ArrayStorage {

    private int size;
    private Resume[] storage = new Resume[10000];

    public ArrayStorage() {
    }

    public void clear() {

        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index == -1) {
            System.out.println("Resume does not exist");
        } else storage[index] = resume;
    }

    public void save(Resume resume) {

        int index = getIndex(resume.getUuid());
        if (index == -1) {
            storage[size] = resume;
            size++;
        }
        if (size == storage.length - 1) {
            System.out.println("Хранилище переполнено");
        } else System.out.println("this resume already in base");
    }

    public Resume get(UUID uuid) {

        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("NotExistResume");
            return null;
        } else {
            return storage[getIndex(uuid)];
        }
    }

    public void delete(UUID uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("This resume dont exist in this base");
        } else {
            storage[index] = storage[size() - 1];
            storage[size() - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] storNotNull = new Resume[size()];

        System.arraycopy(storage, 0, storNotNull, 0, size);
        return storNotNull;
    }

    public int size() {

        return size;
    }

    private int getIndex(UUID uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}

