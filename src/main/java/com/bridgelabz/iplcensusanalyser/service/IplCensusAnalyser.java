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

    public enum IPL {
        BATTING_DATA,BOWLING_DATA
    }

    public IplCensusAnalyser() {
        this.censusMap = new HashMap<>();
    }

    /**
     * load Ipl data
     * @param csvFilePath
     * @return
     * @throws IplAnalyserException
     */
    public int LoadIplData(IPL ipl, String csvFilePath) throws IplAnalyserException {
        censusMap = new LoadIplCensusData().loadCsvData(ipl, csvFilePath);
        return censusMap.size();
    }


    /**
     *  sort IPL data
     * @param sortVariable
     * @return
     * @throws IplAnalyserException
     */
    public String getIplSortedData(EnumSort sortVariable) throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        ComparatorSort comparatorSort = new ComparatorSort();
        Comparator<IplCensusDao> censusComparator = comparatorSort.sortData(sortVariable);
        List sortedResult = censusMap.values().stream().sorted(censusComparator).collect(Collectors.toList());
        return new Gson().toJson(sortedResult);
    }


}
