package com.engeto.Ukol_06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfCountry {
    List<Country> listOfCoutry = new ArrayList<>();

    // Import data from file
    public static ListOfCountry importDataFromFile(String filename, String delimiter) throws CountryException {
        // initialize variables
        String shortCountryName = "";
        String longCountryName = "";
        double basicDph = 0.0;
        double reducedDph = 0.0;
        boolean useSpecialDph = false;
        int lineNumber = 0;
        String nextLine = "";
        String[] dataItems = new String[1];

        ListOfCountry importedCountryData = new ListOfCountry();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){

            while (scanner.hasNextLine()) {
                lineNumber++;
                nextLine = scanner.nextLine();
                dataItems = nextLine.split(delimiter);
                System.out.println(dataItems[0] +" "+ dataItems[1] +" "+ dataItems[3] +" "+ dataItems[4]);
                shortCountryName = dataItems[0];
                longCountryName = dataItems[1];
                basicDph = dataItems[2];
                reducedDph = dataItems[3];
                useSpecialDph = dataItems[4];
            }

        } catch (FileNotFoundException e) {
            throw new CountryException("Soubor nenalezen"+"\n"+e.getLocalizedMessage());
        }

        return importedCountryData;
    }

}
