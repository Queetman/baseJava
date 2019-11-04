package com.company.ru.javawebinar.javawebinar.basejava;
import com.company.ru.javawebinar.javawebinar.basejava.storage.ArrayStorage;
import com.company.ru.javawebinar.javawebinar.basejava.model.Resume;

public class MainTestArrayStorage {

    public static void main(String[] args) {

        Resume resumeOne = new Resume();
        Resume resumeTwo = new Resume();
        Resume resumeThree = new Resume();
        Resume resumeFour = new Resume();

        System.out.println("ResumeOneUUID " + resumeOne.getUuid());
        System.out.println("ResumeTwoUUID " + resumeTwo.getUuid());
        System.out.println("ResumeThreeUUID " + resumeThree.getUuid());
        System.out.println("ResumeThreeUUID " + resumeFour.getUuid());

        ArrayStorage arrayStorage = new ArrayStorage();

        System.out.println("StorageSize=" + arrayStorage.size());
        arrayStorage.save(resumeOne);
        arrayStorage.save(resumeTwo);
        arrayStorage.save(resumeThree);

        System.out.println("Storage size=" + arrayStorage.size());

        System.out.println("Get uuid: " + arrayStorage.get(resumeOne.getUuid()));
        System.out.println("Get uuid: " + arrayStorage.get(resumeTwo.getUuid()));
        System.out.println("Get uuid: " + arrayStorage.get(resumeThree.getUuid()));

        arrayStorage.delete(resumeOne.getUuid());
        System.out.println("Storage size after delete=" + arrayStorage.size());
        System.out.println("GetAllResumesUUid:");

        for (Resume res : arrayStorage.getAll()) {
            System.out.println("ResumeUUID=" + res);
        }

        arrayStorage.clear();
        System.out.println("Size after clear:" + arrayStorage.size());

        System.out.println("Check unexist resume");
        arrayStorage.get(resumeThree.getUuid());

        System.out.println("Checking for adding existing resume");
        arrayStorage.save(resumeOne);
        arrayStorage.save(resumeOne);
        arrayStorage.save(resumeTwo);
        arrayStorage.save(resumeThree);

        System.out.println("Check for deleting unexist resume");
        arrayStorage.delete(resumeFour.getUuid());

        System.out.println("Checking fot update");
        arrayStorage.update(resumeOne);
        System.out.println("Update successful");

        System.out.println("Checking for updating not exist resume");
        arrayStorage.update(resumeFour);

    }
}
