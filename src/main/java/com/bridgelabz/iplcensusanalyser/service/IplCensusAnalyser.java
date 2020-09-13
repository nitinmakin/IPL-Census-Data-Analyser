package com.bridgelabz.iplcensusanalyser.service;

import com.bridgelabz.iplcensusanalyser.exception.IplAnalyserException;
import com.bridgelabz.iplcensusanalyser.model.IplBattingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplBowlingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;
import com.bridgelabz.iplcensusanalyser.utility.EnumSort;
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

    public String getIplSortingDataInAscending(EnumSort sortVariable) throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplCensusDao> censusComparator = sortVariable.sortData();
        List sortedResult = this.sort(censusComparator);
        return new Gson().toJson(sortedResult);
    }
    public String getIplSortingDataInDescending(EnumSort sortVariable) throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplCensusDao> censusComparator = sortVariable.sortData();
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }



    private List sort(Comparator<IplCensusDao> censusComparator) {
        List sortedResult = censusMap.values().stream().sorted(censusComparator).collect(Collectors.toList());
        return sortedResult;
    }
}
