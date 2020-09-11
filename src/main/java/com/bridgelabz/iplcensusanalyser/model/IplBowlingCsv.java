package com.bridgelabz.iplcensusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IplBowlingCsv {
    @CsvBindByName(column =  "POS", required = true)
    public int slNo;
    @CsvBindByName(column =  "PLAYER", required = true)
    public String playerName;

    @Override
    public String toString() {
        return "IplBattingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
