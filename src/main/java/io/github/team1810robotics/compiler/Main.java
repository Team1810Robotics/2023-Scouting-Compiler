package io.github.team1810robotics.compiler;

import java.io.FileReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {
    private static final int FILE_DEPTH = 1;
    private static final String COMPILED_FILE_NAME = "compiled";
    private static String outputPath;

    private static List<String[]> data = new ArrayList<String[]>();

    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Need to give a path to the folder of csv files\n" +
                "run with:\n\tgradlew run --args=\"path/to/folder\"");
            return;
        }

        outputPath = args[0] + "/" + COMPILED_FILE_NAME + ".csv";

        try {
            // list of file paths
            List<String> filePaths = getFiles(args[0]);

            readFiles(filePaths); // read into data list
            writeFile();          // write from the data list

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path paths of csv files to be compiled
     * @return a list populated with dirs to csv files
     */
    private static List<String> getFiles(String path) throws Exception {
        Stream<Path> walk = Files.walk(Paths.get(path), FILE_DEPTH);
        List<String> result = walk
                .filter(p -> !Files.isDirectory(p))   // not a directory
                .map(p -> p.toString().toLowerCase()) // convert path to string
                .filter(f -> f.endsWith("csv"))       // check end with
                .collect(Collectors.toList());        // collect all matched to a List
        walk.close();

        return result;
    }

    /**
     * reads files given by {@code filePaths}
     * and puts them into the 2d list {@code data}
     * @param filePaths list of strings of paths to the csv files to compile
     */
    private static void readFiles(List<String> filePaths) throws Exception {
        // iterate through the paths reading into the data 2d list
        for (var path : filePaths) {
            // make reader for current file
            CSVReader reader = new CSVReader(new FileReader(path));

            // add read data to the data list
            addToList(reader);
        }
    }

    /**
     * adds the strings read by {@code reader} to data list
     * @param reader CSVReader for the current file
     * @throws Exception
     */
    private static void addToList(CSVReader reader) throws Exception {
        String values[] = null;
        // read data of current file and add it to the data list
        while ((values = reader.readNext()) != null) {
            // assumes all headers are the same and stops any being printed again
            if (!data.isEmpty() && values[0].equals(data.get(0)[0])) continue;

            data.add(values);
        }
    }

    /**
     * writes the data in {@code data} to a new csv file
     * @throws Exception
     */
    private static void writeFile() throws Exception {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeAll(data);
        csvWriter.close();

        Files.write(Paths.get(outputPath), writer.toString().getBytes(), StandardOpenOption.CREATE);
    }
}
