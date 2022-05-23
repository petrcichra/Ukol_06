package com.engeto.Ukol_06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfCountry {
    List<Country> listOfCountry = new ArrayList<>();

    // Import data from file
    public static ListOfCountry importDataFromFile(String filename, String delimiter) throws CountryException {
        // initialize variables
        String shortCountryName = "";
        String longCountryName = "";
        Double basicDph = 0.0;
        Double reducedDph = 0.0;
        Boolean useSpecialDph = false;
        int lineNumber = 0;
        String nextLine = "";
        String[] dataItems = new String[1];

        ListOfCountry importedCountryData = new ListOfCountry();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){

            while (scanner.hasNextLine()) {
                lineNumber++;
                nextLine = scanner.nextLine();
                dataItems = nextLine.split(delimiter);
                //System.out.println(dataItems[0] +" "+ dataItems[1] +" "+ dataItems[3] +" "+ dataItems[4]);
                shortCountryName = dataItems[0];
                longCountryName = dataItems[1];
                basicDph = Double.parseDouble(dataItems[2].replace(",","."));
                reducedDph = Double.parseDouble(dataItems[3].replace(",","."));
                useSpecialDph = Boolean.parseBoolean(dataItems[4]);
                //System.out.println(shortCountryName +" "+ longCountryName +" "+ basicDph +" "+ reducedDph +" "+ useSpecialDph);
                importedCountryData.addCountry(
                        new Country(shortCountryName, longCountryName, basicDph, reducedDph, useSpecialDph));
            }

        } catch (FileNotFoundException e) {
            throw new CountryException("Soubor nenalezen"+"\n"+e.getLocalizedMessage());
        }

        return importedCountryData;
    }

    public void addCountry(Country country) {
        listOfCountry.add(country);
    };

    public void print() {
        for (Country country : listOfCountry) {
            System.out.println(country);
        }
    };
}
