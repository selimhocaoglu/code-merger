package com.selimhocaoglu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeCodeFiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Write your project path: ");
        String directory = sc.nextLine();
//        String directory = "source_code_directory";  // write your source code path
        String targetExtension = ".java";
        String desktopPath = System.getProperty("user.home").concat("/Desktop/");
        String outputFile = desktopPath.concat("merged_code.txt");

        try {
            mergeFiles(directory, targetExtension, outputFile);
            System.out.println("All " + targetExtension + " files have been merged into " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeFiles(String directory, String targetExtension, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            try (Stream<Path> filePathStream = Files.walk(Paths.get(directory))) {
                List<Path> files = filePathStream
                        .filter(Files::isRegularFile)
                        .filter(p -> p.toString().endsWith(targetExtension))
                        .toList();

                for (Path filePath : files) {
                    writer.write("// File: " + filePath.toString() + "\n");
                    List<String> lines = Files.readAllLines(filePath);
                    for (String line : lines) {
                        writer.write(line + "\n");
                    }
                    writer.write("\n\n");
                }
            }
        }
    }
}
