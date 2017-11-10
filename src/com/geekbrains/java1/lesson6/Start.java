package com.geekbrains.java1.lesson6;

import java.io.FileNotFoundException;

public class Start {
    public static void main(String[] args) {
        String key = "JAVA";
        String dirKey = "OAK";
        String dirName = "./resources";
        StringBuilder fileSB;

        try {
            FileModifier fileModifier = new FileModifier("file1.txt",
                    "file2.txt",
                    "file3.txt");

            fileModifier.glueFiles1and2();

            String keyExist = fileModifier.isContains(key)?" exist ":" does not exist ";
            System.out.println("Key word " + key + keyExist + "in file");

//            fileModifier.readDirectory("./resources");

//            fileSB = fileModifier.readAllFiles(fileModifier.readDirectory(dirName));
//            keyExist = fileModifier.isContains(fileSB, key)?" exist ":" does not exist ";
//            System.out.println("Key word " + key + keyExist + "in file");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}


