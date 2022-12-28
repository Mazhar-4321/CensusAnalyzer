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

    @Test
    public void givenIncorrectFileFormat_ShouldReturnCustomException() {
        String expectedResult = "Incorrect File Format";
        String observedResult = null;
        try {
            CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
            int numOfRecords = censusAnalyzer.loadIndianCensusData("D:\\abcd.json");
        } catch (CensusAnalyzerException e) {
            observedResult = e.getMessage();
        }
        Assert.assertEquals(expectedResult,observedResult);
    }
    @Test
    public void givenIncorrectDelimeter_ShouldReturnCustomException() {
        String expectedResult = "Incorrect Delimeter";
        String observedResult = null;
        try {
            CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
            int numOfRecords = censusAnalyzer.loadIndianCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            observedResult = e.getMessage();
        }
        Assert.assertEquals(expectedResult,observedResult);
    }
}
