package com.company;

import java.util.UUID;

public class ArrayStorage {

    private int size;
    private Resume[] storage;

    public ArrayStorage(Resume[] storage) {
        this.storage = storage;
    }

    public void save(Resume resume) {

        storage[size()] = resume;
        size++;
    }

    public Resume get(UUID uuid) {

        return storage[getIndex(uuid)];
    }

    public void delete(UUID uuid) {

        storage[getIndex(uuid)] = storage[size() - 1];
        storage[size() - 1] = null;
        size--;
    }

    public int size() {

        return size;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public Resume[] getAll() {
        Resume[] storNotNull = new Resume[size()];

        System.arraycopy(storage, 0, storNotNull, 0, size);
        return storNotNull;
    }

    private int getIndex(UUID uuid) {
        int i = 0;

        while (uuid != storage[i].getUuid()) {
            i++;
        }
        return i;
    }
}
