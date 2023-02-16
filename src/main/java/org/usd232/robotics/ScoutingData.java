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
    public static final String getTeleOpHighCube = null;
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
    private String teleOpLeftComm;
    private String teleOpDocked;
    private String teleOpEngaged;
    private String teleOpTeamRole;
    private String teleOpDirtyPlay;
    private String endGameNotes;
    private String won;

    /** prints the beans in a semi nice way? */
    public String toString() {
        return String.format("MatchID = %s; TeamID = %s; Color = %s; autoLowCone = %s; autoLowCube = %s; autoMidCone = %s; autoMidCube = %s; autoHighCone = %s; autoHighCube = %s; autoLeftComm = %s; autoDocked = %s; autoEngaged = %s; teleOpLowCone = %s; teleOpLowCube = %s; teleOpMidCone = %s; teleOpMidCube = %s; teleOpHighCone = %s; teleOpHighCube = %s; teleOpLeftComm = %s; teleOpDocked = %s; teleOpEngaged = %s; teleOpTeamRole = %s; teleOpDirtyPlay = %s; endGameNotes = %s; won = %s", 
            "MatchId, TeamId, AllianceColor, AutoLowCone, AutoLowCube, AutoMidCone, AutoMidCube, AutoHighCone, AutoHighCube, AutoLeftComm, AutoDocked, AutoEngaged, TeleOpLowCone, TeleOpLowCube, TeleOpMidCone, TeleOpMidCube, TeleOpHighCone, TeleOpHighCube, TeleOpLeftComm, TeleOpDocked, TeleOpEngaged, TeleOpTeamRole, TeleOpDirtyPlay, EndGameNotes, Won");
    }

    /** getters */
    public String getMatchId() { return matchId; }
    public String getTeamId() { return teamId; }
    public String getAllianceColor() { return allianceColor; }
    public String getAutoLowCone() { return autoLowCone; }
    public String getAutoLowCube() { return autoLowCube; }
    public String getAutoMidCone() { return autoMidCone; }
    public String getAutoMidCube() { return autoMidCube; }
    public String getAutoHighCone() { return autoHighCone; }
    public String getAutoHighCube() { return autoHighCube; }
    public String getAutoLeftComm() { return autoLeftComm; }
    public String getWon() { return won; }
    public String getAutoDocked() { return autoDocked; }
    public String getAutoEngaged() { return autoEngaged; }
    public String getTeleOpLowCone() { return teleOpLowCone; }
    public String getTeleOpLowCube() { return teleOpLowCube; }
    public String getTeleOpMidCone() { return teleOpMidCone; }
    public String getTeleOpMidCube() { return teleOpMidCube; }
    public String getTeleOpHighCone() { return teleOpHighCone; }
    public String getTeleOpHighCube() { return teleOpHighCube; }
    public String getTeleOpLeftComm() { return teleOpLeftComm; }
    public String getTeleOpDocked() { return teleOpDocked; }
    public String getTeleOpEngaged() { return teleOpEngaged; }
    public String getTeleOpTeamRole() { return teleOpTeamRole; }
    public String getTeleOpDirtyPlay() { return teleOpDirtyPlay; }
    public String getEndGameNotes() { return endGameNotes; }
    
}