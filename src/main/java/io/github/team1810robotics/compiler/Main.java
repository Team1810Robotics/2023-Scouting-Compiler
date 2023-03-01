package io.github.team1810robotics.compiler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final int FILE_DEPTH = 1;
    private static final String COMPILED_FILE_NAME = "compiled";

    private static List<String[]> data = new ArrayList<String[]>();

    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Need to give a path to the folder of csv files\n" +
                "run with:\n\tgradlew run --args=\"path/to/folder\"");
            return;
        }

        try {
            // read into data list
            Reader.readFiles(data, getFilePaths(args[0]));

            // write from the data list to the compiled csv
            Writer.writeFile(data, args[0] + "/" + COMPILED_FILE_NAME + ".csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path paths of csv files to be compiled
     * @return a list populated with dirs to csv files
     */
    private static List<String> getFilePaths(String path) throws Exception {
        Stream<Path> walk = Files.walk(Paths.get(path), FILE_DEPTH);
        List<String> result = walk
                .filter(p -> !Files.isDirectory(p))   // not a directory
                .map(p -> p.toString().toLowerCase()) // convert path to string
                .filter(f -> f.endsWith("csv"))       // check end with
                .collect(Collectors.toList());        // collect all matched to a List
        walk.close();

        return result;
    }
}
