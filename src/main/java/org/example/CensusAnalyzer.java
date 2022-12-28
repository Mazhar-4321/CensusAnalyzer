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
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(indianCensusCsvFilePath));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new CensusAnalyzerException("Incorrect File Format");
        }
        int count = 1;
        try {
            CsvToBean<CSVStateCensus> csvReader = new
                    CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            String headerRow = reader.readLine();
            String columnNames[] = headerRow.split(",");
            if (!(columnNames[0].equals("State") && columnNames[1].equals("Population") &&
                    columnNames[2].equals("AreaInSqKm") && columnNames[3].equals("DensityPerSqKm"))) {
                throw new CensusAnalyzerException("exception:Invalid Headers");
            }
            Iterator<CSVStateCensus> csvStateCensusIterator = csvReader.iterator();
            while (csvStateCensusIterator.hasNext()) {
                CSVStateCensus csvStateCensus = csvStateCensusIterator.next();
                count++;
            }
        } catch (Exception e) {
            String[] messageArray = e.getMessage().split(":");
            String customExceptionMessage = messageArray[1].trim().equals("Number of data fields does not match number of headers.") ? "Incorrect Delimeter" : messageArray[1].equals("Invalid Headers") ? "Invalid Headers" : "InCorrect File Format";
            throw new CensusAnalyzerException(customExceptionMessage);
        }
        return count;
    }
}
