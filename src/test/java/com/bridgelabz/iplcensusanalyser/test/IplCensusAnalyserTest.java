package com.bridgelabz.iplcensusanalyser.test;

import com.bridgelabz.iplcensusanalyser.exception.IplAnalyserException;
import com.bridgelabz.iplcensusanalyser.model.IplBattingCsv;
import com.bridgelabz.iplcensusanalyser.service.IplCensusAnalyser;
import com.bridgelabz.iplcensusanalyser.utility.EnumSort;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IplCensusAnalyserTest {
    private final String IPL_BATTING_FILE_PATH = "D:\\fellowship\\IPL-Census-Data-Analyser\\" +
            "src\\test\\resources\\IplMostRuns.csv";
    private final String IPL_BOWLING_FILE_PATH = "D:\\fellowship\\IPL-Census-Data-Analyser" +
            "\\src\\test\\resources\\IplMostWik.csv";

    @Test
    public void IplBattingDataShouldReturnCorrectRecords() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            int numOfEntries = iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            Assert.assertEquals(100, numOfEntries);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void IplBowlingDataShouldReturnCorrectRecords() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            int numOfEntries = iplCensusAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            Assert.assertEquals(99, numOfEntries);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIplBestBattingAvgDataShouldReturnCorrectResult() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplCensusAnalyser.getIplSortingDataInDescending(EnumSort.TOP_BAT_AVG);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("MS Dhoni", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplBestBattingSRDataShouldReturnCorrectResult() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplCensusAnalyser.getIplSortingDataInDescending(EnumSort.TOP_BAT_SR);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplHighestBoundariesDataShouldReturnCorrectResult() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplCensusAnalyser.getIplSortingDataInDescending(EnumSort.MAX_6s_4s);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBestAvgWithBestSrShouldReturnCorrectResult() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplCensusAnalyser.getIplSortingDataInDescending(EnumSort.TOP_BAT_AVG_WITH_BEST_SR);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplPlayerWithBestRunsShouldReturnCorrectResult() {
        try {
            IplCensusAnalyser iplCensusAnalyser = new IplCensusAnalyser();
            iplCensusAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplCensusAnalyser.getIplSortingDataInDescending(EnumSort.TOP_RUNS_OF_PLAYER);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("David Warner ", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
