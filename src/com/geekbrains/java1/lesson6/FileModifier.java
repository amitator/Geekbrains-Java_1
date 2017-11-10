package com.geekbrains.java1.lesson6;

import java.io.*;
import java.util.Scanner;

public class FileModifier {

    protected Scanner scanner1;
    protected Scanner scanner2;
    protected Scanner scanner3;
    protected PrintStream printStream;
    protected StringBuilder sb;
    protected StringBuilder fileSB = new StringBuilder();

    public FileModifier(String fInName1, String fInName2, String fOutName) throws FileNotFoundException{
        scanner1 = new Scanner(new FileInputStream(fInName1));
        scanner2 = new Scanner(new FileInputStream(fInName2));
        printStream = new PrintStream((new FileOutputStream(fOutName)));
        sb = new StringBuilder();
    }

    protected void glueFiles1and2(){
        while (scanner1.hasNext()) {
            sb.append(scanner1.nextLine());
            sb.append("\n");
        }

        while (scanner2.hasNext()) {
            sb.append(scanner2.nextLine());
            sb.append("\n");
        }

        printStream.print(sb.toString());
    }

    protected boolean isContains(String key){
        return sb.toString().contains(key);
    }

    protected boolean isContains(StringBuilder sb, String key){
        return sb.toString().contains(key);
    }

    protected File[] readDirectory(String dirName){
        File folder = new File(dirName);
        File[] listOfFiles = folder.listFiles();

        return listOfFiles;
    }

    protected StringBuilder readAllFiles(File[] filesArr) throws FileNotFoundException{
        for (File file : filesArr) {
            if (file.isFile()) {
                readFile(file);
            }
        }

        return fileSB;
    }

    protected void readFile(File file)throws FileNotFoundException{
        scanner3 = new Scanner(new FileInputStream(file.getName()));

        while (scanner3.hasNext()){
            fileSB.append(scanner3.nextLine());
            fileSB.append("/n");
        }
        scanner3.close();
    }
}

//TODO
//isContains(key) should include sb where to search