package com.bridgelabz.iplcensusanalyser.utility;

import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;

import java.util.Comparator;

public enum EnumSort {

    TOP_BAT_AVG {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> census.avg);
            return IplCensusComparator;
        }
    },
    TOP_BAT_SR {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> census.sr);
            return IplCensusComparator;
        }
    },
    MAX_6s_4s {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> (census.Highest4s + census.highest6s));
            return IplCensusComparator;
        }
    },
    TOP_BAT_AVG_WITH_BEST_SR {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> (census.sr + census.avg));
            return IplCensusComparator;
        }
    },
    TOP_RUNS_OF_PLAYER {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> census.runs);
            return IplCensusComparator;
        }
    },
    BEST_BOWL_AVG {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> census.avg);
            return IplCensusComparator;
        }
    },
    BEST_BOWL_SR {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplCensusComparator = Comparator.comparing(census -> census.sr);
            return IplCensusComparator;
        }
    };
    public abstract Comparator<IplCensusDao> sortData();
    }
