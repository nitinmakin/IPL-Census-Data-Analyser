package com.bridgelabz.iplcensusanalyser.model;

public class IplCensusDao {
    public int slNO;
    public String playerName;
    public double avg;

    public IplCensusDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
    }

    public IplCensusDao(IplBowlingCsv iplBowlingCsv){
        slNO = iplBowlingCsv.slNo;
        playerName = iplBowlingCsv.playerName;
    }
}
