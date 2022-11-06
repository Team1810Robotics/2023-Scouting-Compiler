package org.usd232.robotics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** BEANS!!1! */
@Data
@AllArgsConstructor
@NoArgsConstructor
// FIXME WHEN UPDATING: change whole class
public class ScoutingData {
    private String matchId;
    private String teamId;
    private String allianceColor;
    private String autoLow;
    private String autoHigh;
    private String autoHeld;
    private String autoTaxi;
    private String teleOpLow;
    private String teleOpHigh;
    private String teleOpColorSensor;
    private String teleOpClimbSpot;
    private String won;

    /** prints the beans in a semi nice way? */
    public String toString() {
        return String.format("MatchID = %s; TeamID = %s; Color = %s; autoLow = %s; autoHigh = %s; autoHeld = %s; autoTaxi = %s; teleOpLow = %s; teleOpHigh = %s; colorSensor = %s; climb = %s; won = %s", 
            matchId, teamId, allianceColor, autoLow, autoHigh, autoHeld, autoTaxi, teleOpLow, teleOpHigh, teleOpColorSensor, teleOpClimbSpot, won);
    }

    /** getters */
    public String getMatchId() { return matchId; }
    public String getTeamId() { return teamId; }
    public String getAllianceColor() { return allianceColor; }
    public String getAutoLow() { return autoLow; }
    public String getAutoHigh() { return autoHigh; }
    public String getAutoHeld() { return autoHeld; }
    public String getAutoTaxi() { return autoTaxi; }
    public String getTeleOpLow() { return teleOpLow; }
    public String getTeleOpHigh() { return teleOpHigh; }
    public String getTeleOpClimbSpot() { return teleOpClimbSpot; }
    public String getWon() { return won; }
    public String getTeleOpColorSensor() { return teleOpColorSensor; }

}