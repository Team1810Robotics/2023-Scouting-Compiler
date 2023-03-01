package io.github.team1810robotics.compiler;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class Reader {

    /**
     * reads files given by {@code filePaths}
     * and puts them into the 2d list {@code data}
     * @param filePaths list of strings of paths to the csv files to compile
     */
    public static void readFiles(List<String[]> dataDst, List<String> filePaths) throws Exception {
        // iterate through the paths reading into the data 2d list
        for (var path : filePaths) {
            addToList(dataDst, path);
        }
    }

    private static void addToList(List<String[]> dataDst, String pathToFile) throws Exception {
        // make reader for current file
        CSVReader reader = new CSVReader(new FileReader(pathToFile));
        String values[] = null;

        // read data of current file and add it to the data list
        while ((values = reader.readNext()) != null) {
            // assumes all headers are the same and stops any being printed again
            if (!dataDst.isEmpty() && values[0].equals(dataDst.get(0)[0])) continue;

            dataDst.add(values);
        }
    }
}
