package com.bridgelabz.iplcensusanalyser.service;

import com.bridgelabz.csvbuilder.service.CsvBuilderFactory;
import com.bridgelabz.csvbuilder.service.ICsvBuilder;
import com.bridgelabz.iplcensusanalyser.exception.IplAnalyserException;
import com.bridgelabz.iplcensusanalyser.model.IplBattingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplBowlingCsv;
import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class LoadIplCensusData {

    public Map<String, IplCensusDao> loadCsvData(IplCensusAnalyser.IPL ipl,
                                                 String csvFilePath) throws IplAnalyserException {

        if(ipl.equals(IplCensusAnalyser.IPL.BATTING_DATA))
            return loadCsvData(IplBattingCsv.class, csvFilePath);
        else if(ipl.equals(IplCensusAnalyser.IPL.BOWLING_DATA))
            return loadCsvData(IplBowlingCsv.class, csvFilePath);
        else
           return null;
    }


    public <E> Map loadCsvData(Class<E> IplCensusCsvData, String... csvFilePath) throws IplAnalyserException {
        Map<String, IplCensusDao> censusMap = new HashMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICsvBuilder csvBuilder = CsvBuilderFactory.createCsvBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplCensusCsvData);
            Iterable<E> CensusCsv = () -> csvFileIterator;
            String className = IplCensusCsvData.getSimpleName();
            if (className.equalsIgnoreCase("IplBattingCsv")) {
                StreamSupport.stream(CensusCsv.spliterator(), false)
                        .map(IplBattingCsv.class::cast)
                        .forEach(csvCensus -> censusMap.put(csvCensus.playerName, new IplCensusDao(csvCensus)));
                return censusMap;
            } else if (className.equalsIgnoreCase("IplBowlingCsv")) {
                StreamSupport.stream(CensusCsv.spliterator(), false)
                        .map(IplBowlingCsv.class::cast)
                        .forEach(csvCensus1 -> censusMap.put(csvCensus1.playerName, new IplCensusDao(csvCensus1)));
                return censusMap;
            }

        } catch (Exception e) {
            throw new IplAnalyserException(e.getMessage(),
                    IplAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        return null;
    }
}
