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
    private String autoLowCube;
    private String autoLowCone;
    private String autoMidCone;
    private String autoMidCube;
    private String autoHighCone;
    private String autoHighCube;
    private String autoLeftComm;
    private String autoDocked;
    private String autoEngaged;
    private String teleOpLowCone;
    private String teleOpLowCube;
    private String teleOpMidCone;
    private String teleOpMidCube;
    private String teleOpHighCone;
    private String teleOpHighCube;
    private String teleOpInComm;
    private String teleOpDocked;
    private String teleOpEngaged;
    private String teleOpTeamRole;
    private String teleOpDirtyPlay;
    private String endGameNotes;
    private String won;

    /** prints the beans in a semi nice way? */
    public String toString() {
        return String.format("MatchID = %s; TeamID = %s; Color = %s; autoLowCone = %s; autoLowCube = %s; autoMidCone = %s; autoMidCube = %s; autoHighCone = %s; autoHighCube = %s; autoLeftComm = %s; autoDocked = %s; autoEngaged = %s; teleOpLowCone = %s; teleOpLowCube = %s; teleOpMidCone = %s; teleOpMidCube = %s; teleOpHighCone = %s; teleOpHighCube = %s; teleOpLeftComm = %s; teleOpDocked = %s; teleOpEngaged = %s; teleOpTeamRole = %s; teleOpDirtyPlay = %s; endGameNotes = %s; won = %s", 
            matchId, teamId, allianceColor, autoLowCone, autoLowCube, autoMidCone, autoMidCube, autoHighCone, autoHighCube, autoLeftComm, autoDocked, autoEngaged, teleOpLowCone, teleOpLowCube, teleOpMidCone, teleOpMidCube, teleOpHighCone, teleOpHighCube, teleOpLeftComm, teleOpDocked, teleOpEngaged, teleOpTeamRole, teleOpDirtyPlay, endGameNotes, won);
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