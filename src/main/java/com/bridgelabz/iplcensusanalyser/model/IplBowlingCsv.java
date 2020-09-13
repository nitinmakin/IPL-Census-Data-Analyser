package com.bridgelabz.iplcensusanalyser.model;

import com.opencsv.bean.CsvBindByName;
//POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
public class IplBowlingCsv {
    @CsvBindByName(column =  "POS", required = true)
    public int slNo;
    @CsvBindByName(column =  "PLAYER", required = true)
    public String playerName;
    @CsvBindByName(column =  "Avg", required = true)
    public double avg;
    @CsvBindByName(column =  "SR", required = true)
    public double sr;
    @CsvBindByName(column =  "Econ", required = true)
    public double ecNo;

    @Override
    public String toString() {
        return "IplBowlingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg=" + avg +
                ", sr=" + sr +
                ", Econ=" + ecNo +
                '}';
    }
}
