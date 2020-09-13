package com.bridgelabz.iplcensusanalyser.utility;

import com.bridgelabz.iplcensusanalyser.model.IplCensusDao;

import java.util.Comparator;

public enum EnumSort {

    TOP_BAT_AVG {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplcensusComparator = Comparator.comparing(census -> census.avg);
            return IplcensusComparator;
        }
    },
    TOP_BAT_SR {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplcensusComparator = Comparator.comparing(census -> census.sr);
            return IplcensusComparator;
        }
    },
    MAX_6s_4s {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplcensusComparator = Comparator.comparing(census -> (census.Highest4s + census.highest6s));
            return IplcensusComparator;
        }
    },
    TOP_BAT_AVG_WITH_BEST_SR {
        @Override
        public Comparator<IplCensusDao> sortData() {
            Comparator<IplCensusDao> IplcensusComparator = Comparator.comparing(census -> (census.sr + census.avg));
            return IplcensusComparator;
        }
    };
    public abstract Comparator<IplCensusDao> sortData();
    }
