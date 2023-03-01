package io.github.team1810robotics.compiler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Main {
    private static final int FILE_DEPTH = 1;
    private static final String COMPILED_FILE_NAME = "compiled";

    private static List<String[]> data = new ArrayList<>();

    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Need to give a path to the folder of csv files\n" +
                    "run with:\n\tgradlew run --args=\"path/to/folder\"");
            return;
        }

        try {
            // read into data list
            List<String> filePaths = getFilePaths(args[0]);
            readFiles(data, filePaths);

            // write from the data list to the compiled csv
            String outputFile = args[0] + "/" + COMPILED_FILE_NAME + ".csv";
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {
                csvWriter.writeAll(data);
            }
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
    public static void readFiles(List<String[]> dataDst, List<String> filePaths) throws IOException, CsvValidationException {
        // iterate through the paths reading into the data 2d list
        for (var path : filePaths) {
            addDataToList(dataDst, path);
        }
    }

    private static void addDataToList(List<String[]> dataDst, String pathToFile) throws IOException, CsvValidationException {
        // make reader for current file
        try (CSVReader reader = new CSVReader(new FileReader(pathToFile))) {
            String values[];

            // read data of current file and add it to the data list
            while ((values = reader.readNext()) != null)
                // assumes all headers are the same and stops any being printed again
                if (dataDst.isEmpty() || !values[0].equals(dataDst.get(0)[0]))
                    dataDst.add(values);
        }
    }
}