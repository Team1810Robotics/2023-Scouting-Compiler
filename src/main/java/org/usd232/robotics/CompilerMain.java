package org.usd232.robotics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompilerMain {
    private static final int FILE_DEPTH = 1;

    public static void main(String args[]) {
        // needs to have an argv telling it where to look for the files
        if (args.length == 0) {
            System.err.println("Need to give a path to the folder of csv files\n" +
                "run with\n\tgradlew run --args=\"path/to/folder\"");
            return;
        }

        try {
            // list of file paths
            List<String> filePaths = getFiles(args[0]);

            // iterate through the paths reading then writing to the compiled file
            // the reason we dont use a for each loop is for the header
            for (int i = 0; i < filePaths.size(); i++) {
                Reader csv = new Reader(filePaths.get(i));
                Writer.fileWriter(args[0] + "/compiled.csv", csv.getList(), (i == 0) ? true : false);
            }

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
}
