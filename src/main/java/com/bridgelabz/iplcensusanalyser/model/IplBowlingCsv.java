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
    @CsvBindByName(column =  "4w", required = true)
    public double highest4W;
    @CsvBindByName(column =  "5w", required = true)
    public double highest5W;

    @Override
    public String toString() {
        return "IplBowlingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg=" + avg +
                ", sr=" + sr +
                ", ecNo=" + ecNo +
                ", highest4W=" + highest4W +
                ", highest5W=" + highest5W +
                '}';
    }
}
