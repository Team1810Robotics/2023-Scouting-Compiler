package io.github.team1810robotics.compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final int FILE_DEPTH = 1;
    private static final String COMPILED_FILE_NAME = "compiled";
    private static String csvFolderPath = "resources";

    private static List<String[]> data = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("\033[33;1;4mWarning!\u001b[0m\n" +
                    "Should give a path to the folder of csv files\n" +
                    "run with:\n\tgradlew run --args=\"path/to/folder\"\nDefaults to \"" + csvFolderPath + "\"");
        } else {
            csvFolderPath = args[0];
        }

        try {
            // read into data list
            List<String> filePaths = getFilePaths(csvFolderPath);
            readFiles(data, filePaths);

            // write from the data list to the compiled csv
            String outputFile = csvFolderPath + "/" + COMPILED_FILE_NAME + ".csv";
            writeToFile(data, outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path paths of csv files to be compiled
     * @return a list populated with dirs to csv files
     */
    private static List<String> getFilePaths(String path) throws IOException {
        return Files.walk(Paths.get(path), FILE_DEPTH)
                .filter(p -> !Files.isDirectory(p) && p.toString().toLowerCase().endsWith("csv"))
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    /**
     * reads files given by {@code filePaths}
     * and puts them into the 2d list {@code dataDst}
     *
     * @param filePaths list of strings of paths to the csv files to compile
     */
    public static void readFiles(List<String[]> dataDst, List<String> filePaths) throws IOException {
        // iterate through the paths reading into the data 2d list
        for (var path : filePaths) {
            addDataToList(dataDst, path);
        }
    }

    private static void addDataToList(List<String[]> dataDst, String pathToFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;

            // read data of current file and add it to the data list
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // assumes all headers are the same and stops any being printed again
                if (dataDst.isEmpty() || !values[0].equals(dataDst.get(0)[0]))
                    dataDst.add(values);
            }
        }
    }

    private static void writeToFile(List<String[]> data, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // write data to file
            for (var row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }
    }
}
