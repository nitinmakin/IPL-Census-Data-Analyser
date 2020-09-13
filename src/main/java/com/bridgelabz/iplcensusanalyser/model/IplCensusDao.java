package com.bridgelabz.iplcensusanalyser.model;

public class IplCensusDao {
    public int slNO;
    public String playerName;
    public double avg;
    public double sr;
    public int highest6s;
    public int Highest4s;
    public int runs;
    public double ecNo;
    public double highest4W;
    public double highest5W;
    public int wickets;
    public int max100;
    public int max50;


    public IplCensusDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
        sr = iplBattingCsv.sr;
        highest6s = iplBattingCsv.highest6s;
        Highest4s = iplBattingCsv.highest4s;
        runs = iplBattingCsv.runs;
        max50 = iplBattingCsv.max50;
        max100 = iplBattingCsv.max100;
    }

    public IplCensusDao(IplBowlingCsv iplBowlingCsv) {
        slNO = iplBowlingCsv.slNo;
        playerName = iplBowlingCsv.playerName;
        avg = iplBowlingCsv.avg;
        sr = iplBowlingCsv.sr;
        ecNo = iplBowlingCsv.ecNo;
        highest4W = iplBowlingCsv.highest4W;
        highest5W = iplBowlingCsv.highest5W;
        wickets = iplBowlingCsv.wickets;

    }
}
