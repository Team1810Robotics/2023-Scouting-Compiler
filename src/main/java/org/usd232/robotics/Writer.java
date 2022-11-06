package org.usd232.robotics;

import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Writer {

    /**
     * writes the csv beans to the a new compiled csv file
     * @param path the path to where compiled csv will be created
     * @param list compiled list of beans
     * @param header if the header for the compiled csv added
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void fileWriter(String path, List list, boolean header) {
        try {
            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer);

            List<String[]> data = toStringArray(list, header);

            csvWriter.writeAll(data);

            csvWriter.close();

            boolean exists = Files.exists(Paths.get(path));

            Files.write(Paths.get(path), writer.toString().getBytes(), (exists) ? StandardOpenOption.APPEND
                                                                                : StandardOpenOption.CREATE);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    /** converts the scouting data 
     * beans back to a string array
     * @param list compiled list of beans
     * @param header if the header for the compiled csv added
     */
    private static List<String[]> toStringArray(List<ScoutingData> list, boolean header) {
		List<String[]> records = new ArrayList<String[]>();

		// adding header
        if (header)
            // FIXME WHEN UPDATING: update header to make sense
		    records.add(new String[] { "MatchId", "TeamId", "AllianceColor", "AutoCargoLower", "AutoCargoOuter", "AutoHeld", "AutoMoves", "TeleOpCargoLower", "TeleOpCargoOuter", "TeleOpCanSeeColor", "GrabBarPosition", "Won"});

        // start index at 1 so we can skip the header 
        // of the file because its added above
		for (int i = 1; i < list.size(); i++) {
            ScoutingData data = list.get(i);
            if (data.getMatchId() != "MatchId") {
                // FIXME WHEN UPDATING: make getters return correct values
                records.add(new String[] { data.getMatchId(), data.getTeamId(), data.getAllianceColor(),
                                        data.getAutoLow(), data.getAutoHigh(), data.getAutoHeld(), data.getAutoTaxi(),
                                        data.getTeleOpLow(), data.getTeleOpHigh(), data.getTeleOpColorSensor(),
                                        data.getTeleOpClimbSpot(), data.getWon() });
            }
		}
		return records;
	}
}
