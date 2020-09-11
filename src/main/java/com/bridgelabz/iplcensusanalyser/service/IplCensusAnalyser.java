package com.bridgelabz.iplcensusanalyser.service;

import com.bridgelabz.iplcensusanalyser.exception.IplAnalyserException;
import com.bridgelabz.iplcensusanalyser.model.IplBattingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplBowlingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;
import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplCensusAnalyser {
    Map<String, IplCensusDao> censusMap;
    public IplCensusAnalyser() {
        this.censusMap = new HashMap<>();
    }


    public int LoadIplBattingData(String csvFilePath) throws IplAnalyserException {
        censusMap =  new LoadIplCensusData().loadCsvData(csvFilePath, IplBattingCsv.class);
        return censusMap.size();
    }

    public int LoadIplBowlingData(String csvFilePath) throws IplAnalyserException {
        censusMap =  new LoadIplCensusData().loadCsvData(csvFilePath, IplBowlingCsv.class);
        return censusMap.size();
    }
    public void checkNull() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
    }

    /**
     * for checking best batting avg
     * @return
     * @throws IplAnalyserException
     */
    public String getBestBattingAvg() throws IplAnalyserException {
        this.checkNull();
        Comparator<IplCensusDao> censusComparator = Comparator.comparing(census -> census.avg);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    /**
     * for checking best batting SR
     * @return
     * @throws IplAnalyserException
     */
    public String getBestBattingSR() throws IplAnalyserException {
        this.checkNull();
        Comparator<IplCensusDao> censusComparator = Comparator.comparing(census -> census.sr);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    /**
     * for checking highest 6s
     * @return
     * @throws IplAnalyserException
     */
    public String getHighest6s() throws IplAnalyserException {
        this.checkNull();
        Comparator<IplCensusDao> censusComparator = Comparator.comparing(census -> census.highest6s);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    /**
     * for checking highest 4s
     * @return
     * @throws IplAnalyserException
     */
    public String getHighest4s() throws IplAnalyserException {
        this.checkNull();
        Comparator<IplCensusDao> censusComparator = Comparator.comparing(census -> census.Highest4s);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }

    private List sort(Comparator<IplCensusDao> censusComparator) {
        List sortedResult = censusMap.values().stream().sorted(censusComparator).collect(Collectors.toList());
        return sortedResult;
    }
}
