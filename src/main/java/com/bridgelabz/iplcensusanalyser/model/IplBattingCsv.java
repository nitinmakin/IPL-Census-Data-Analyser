package com.bridgelabz.iplcensusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IplBattingCsv {
    //POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s

    @CsvBindByName(column = "POS", required = true)
    public int slNo;
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;
    @CsvBindByName(column = "Avg", required = true)
    public double avg;
    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @Override
    public String toString() {
        return "IplBattingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg=" + avg +
                ", sr=" + sr +
                '}';
    }
}

