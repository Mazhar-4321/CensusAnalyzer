package org.example;

import exceptions.CensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "D:\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() {
        try {
            CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
            int numOfRecords = censusAnalyzer.loadIndianCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyzerException e) {

        }

    }
}
