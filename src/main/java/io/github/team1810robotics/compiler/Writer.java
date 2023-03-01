package io.github.team1810robotics.compiler;

import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.opencsv.CSVWriter;

public class Writer {

    /**
     * writes the data in {@code data} to a new csv file
     * @throws Exception
     */
    public static void writeFile(List<String[]> data, String outputPath) throws Exception {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeAll(data);
        csvWriter.close();

        Files.write(Paths.get(outputPath), writer.toString().getBytes(), StandardOpenOption.CREATE);
    }
}
