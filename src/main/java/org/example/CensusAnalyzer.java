package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import exceptions.CensusAnalyzerException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class CensusAnalyzer {
    public int loadIndianCensusData(String indianCensusCsvFilePath) throws CensusAnalyzerException {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(indianCensusCsvFilePath));
        } catch (FileNotFoundException e) {
            throw new CensusAnalyzerException("Incorrect File Format");
        }
        CsvToBean<CSVStateCensus> csvReader = new
                CsvToBeanBuilder(reader)
                .withType(CSVStateCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
       int count=0;
        Iterator<CSVStateCensus> csvStateCensusIterator= csvReader.iterator();
        while (csvStateCensusIterator.hasNext()){
            CSVStateCensus csvStateCensus= csvStateCensusIterator.next();
            count++;
        }
        return count;
    }
}
