package com.company;


public class MainTestArrayStorage {

    public static void main(String[] args) {

        Resume resumeOne = new Resume();
        Resume resumeTwo = new Resume();
        Resume resumeThree = new Resume();

        System.out.println("ResumeOneUUID " + resumeOne.getUuid());
        System.out.println("ResumeTwoUUID " + resumeTwo.getUuid());
        System.out.println("ResumeThreeUUID " + resumeThree.getUuid());

        ArrayStorage arrayStorage = new ArrayStorage(MainArray.getStorage());

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
    }
}
