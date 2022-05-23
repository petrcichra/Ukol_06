package com.engeto.Ukol_06;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String DELIMITER = "\t";
    public static final String FILENAME = "vat-eu.csv";
    public static final int STATUS_CANNOT_READ_FILE = -1;

    public static void main(String[] args) {

       ListOfCountry countries = null;

        try {
            countries = ListOfCountry.importDataFromFile(FILENAME, DELIMITER);
        } catch (CountryException e) {
            System.err.println(
                    "Chyba při ančtení souboru. " + FILENAME + "\n"
                    + e.getLocalizedMessage());
            System.exit(STATUS_CANNOT_READ_FILE);
        }

    }
}
