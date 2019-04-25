package aicoder.temp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public void createDirectory(String directoryPath) {
        String path[] = directoryPath.split("\\\\");
        String baseDirPath = "";
        for (String string : path) {
            baseDirPath += string + "\\";
            File directory = new File(String.valueOf(baseDirPath));
            if (!directory.exists()) {
                Path dir = Paths.get(directory.toURI());
                try {
                    Files.createDirectory(dir);
                } catch (IOException e) {
                    System.out.println("Unable to create Directory:" + dir.toString());
                }
            }
        }
    }

    public File createFile(String directoryPath, String fileName) {
        File file = null;
        File directory = new File(String.valueOf(directoryPath));
        if (directory.exists()) {
            file = new File(String.valueOf(directoryPath + fileName));
            if (!file.exists()) {
                Path fileuri = Paths.get(file.toURI());
                try {
                    Files.createFile(fileuri);
                } catch (IOException e) {
                    System.out.println("Unable to create File:" + fileuri.toString());
                }
            }
        } else {
            System.out.println("Directory doesn't exists:" + directoryPath);
        }
        return file;
    }
}