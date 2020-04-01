package com.OpenCsv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String OBJECT_WRITE_FILE_PATH = "/Users/mohansmac/Downloads/users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_WRITE_FILE_PATH));
        ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<CSVUser> csvUsers = new ArrayList<>();
            csvUsers.add(new CSVUser("Mohan","mohan.b6oo@gmail.com","9777037773","India"));
            csvUsers.add(new CSVUser("Geeth","geeth.b6oo@gmail.com","9777027773","India"));
            csvUsers.add(new CSVUser("Niranjan","niranjan.b6oo@gmail.com","9777047773","India"));
            csvUsers.add(new CSVUser("Naveen","naveen.b6oo@gmail.com","9777057773","India"));
            beanToCsv.write(csvUsers);
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }
}