package com.bridgelabz.iplcensusanalyser.exception;

public class IplAnalyserException extends Exception {
    public enum ExceptionType  {
        CENSUS_FILE_PROBLEM,NO_CENSUS_DATA
    }

    public ExceptionType type;

    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IplAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);

    }
}
