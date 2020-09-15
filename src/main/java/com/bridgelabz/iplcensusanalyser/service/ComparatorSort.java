package com.bridgelabz.iplcensusanalyser.service;

import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;
import com.bridgelabz.iplcensusanalyser.utility.EnumSort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorSort {
    static Map<EnumSort, Comparator> map = new HashMap<>();

    public Comparator<IplCensusDao> getSortedData(EnumSort fields) {

        Comparator<IplCensusDao> max100 = Comparator.comparing(census -> census.max100);
        Comparator<IplCensusDao> max50 = Comparator.comparing(census -> census.max50);
        Comparator<IplCensusDao> wickets = Comparator.comparing(census -> census.wickets);
        Comparator<IplCensusDao> avg = Comparator.comparing(census -> census.avg);
        Comparator<IplCensusDao> sr = Comparator.comparing(census -> census.sr);
        Comparator<IplCensusDao> highest4W5W = Comparator.comparing(census -> (census.highest4W + census.highest5W));
        Comparator<IplCensusDao> ecNo = Comparator.comparing(census -> census.ecNo);
        Comparator<IplCensusDao> runs = Comparator.comparing(census -> census.runs);
        Comparator<IplCensusDao> highest6S = Comparator.comparing(census -> census.highest6s);
        Comparator<IplCensusDao> highest4S = Comparator.comparing(census -> census.Highest4s);
        Comparator<IplCensusDao> bestBatAvgWithBestSr = Comparator.comparing(census -> (census.avg + census.sr));
        Comparator<IplCensusDao> bestBowlAvgWithBestSr = Comparator.comparing(census -> (census.avg + census.sr));
        Comparator<IplCensusDao> zero50zero100 = Comparator.comparing(census -> (census.max50 + census.max100));


        map.put(EnumSort.BEST_BOWL_4W_5W, highest4W5W.reversed());
        map.put(EnumSort.BEST_BOWL_AVG, avg);
        map.put(EnumSort.TOP_BAT_AVG, avg.reversed());
        map.put(EnumSort.TOP_BAT_SR, sr.reversed());
        map.put(EnumSort.MAX_6s_4s, highest4S.reversed());
        map.put(EnumSort.MAX_6s_4s, highest6S.reversed());
        map.put(EnumSort.TOP_BAT_AVG_WITH_BEST_SR, bestBatAvgWithBestSr.reversed());
        map.put(EnumSort.TOP_RUNS_OF_PLAYER, runs.reversed());
        map.put(EnumSort.BEST_BOWL_SR, sr);
        map.put(EnumSort.BEST_BOWL_ECON, ecNo);
        map.put(EnumSort.BEST_BOWL_AVG_AND_BEST_SR, bestBowlAvgWithBestSr);
        map.put(EnumSort.HIGHEST_WICKETS, wickets.reversed());
        map.put(EnumSort.MAX50, max50.reversed());
        map.put(EnumSort.MAX100, max100.reversed());
        map.put(EnumSort.BEST_BOWL_AVG_AND_BEST_SR, bestBowlAvgWithBestSr);
        map.put(EnumSort.ZERO50s_ZERO100s, zero50zero100);

        Comparator<IplCensusDao> sortField = map.get(fields);

        return sortField;
    }

    public  Comparator<IplCensusDao> sortData(EnumSort enumSorting) {
        return getSortedData(enumSorting);
    }

}
