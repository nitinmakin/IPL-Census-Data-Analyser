package com.bridgelabz.iplcensusanalyser.model;

public class IplCensusDao {
    public int slNO;
    public String playerName;
    public double avg;
    public double sr;
    public int highest6s;
    public int Highest4s;
    public int runs;

    public IplCensusDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
        sr = iplBattingCsv.sr;
        highest6s = iplBattingCsv.highest6s;
        Highest4s = iplBattingCsv.highest4s;
        runs = iplBattingCsv.runs;

    }

    public IplCensusDao(IplBowlingCsv iplBowlingCsv) {
        slNO = iplBowlingCsv.slNo;
        playerName = iplBowlingCsv.playerName;
    }
}
