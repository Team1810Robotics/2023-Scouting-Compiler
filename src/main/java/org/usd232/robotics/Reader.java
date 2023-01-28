package org.usd232.robotics;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;


@SuppressWarnings({"rawtypes", "unchecked"})
public class Reader {

    private File file;
    private List<ScoutingData> list;

    /** i dont anticipate needing this */
    public Reader() {
        this.file = null;
        this.list = null;
    }

    /**
     * constructor that calls {@code setList}
     * @param filePath what csv file to read from
     */
    public Reader(String filePath) throws Exception {
        setList(filePath);
    }

    /**
     * Reads the csv file and binds it to beans
     * @param filePath what csv file to read from
     */
    public void setList(String filePath) throws Exception {
        this.file = new File(filePath);
        CSVReader csvReader = new CSVReader(new FileReader(file));

        CsvToBean csv = new CsvToBean();
        csv.setCsvReader(csvReader);
        csv.setMappingStrategy(setColumMapping());

        this.list = csv.parse();
    }

    /** get list */
    public List getList() {
        return list;
    }

    /** print out the data */
    public void print() {
        for (ScoutingData data : list) {
            System.out.println(data.toString());
        }
    }

    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(ScoutingData.class);
        // FIXME WHEN UPDATING: make these match the object names in ScoutingData
        String[] columns = new String[] { "MatchId", "TeamId", "Color", "AutoLowCone","AutoLowCube","AutoMidCone","AutoMidCube","AutoHighCone","AutoHighCube","AutoLeftComm","AutoDocked","AutoEngaged","TeleOpLowCone","TeleOpLowCube","TeleOpMidCone","TeleOpMidCube","TeleOpHighCone","TeleOpHighCube","TeleOpInComm","TeleOpDocked","TeleOpEngaged","TeleOpTeamRole","TeleOpDirtyPlay","EndGameNotes","Won" };
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
