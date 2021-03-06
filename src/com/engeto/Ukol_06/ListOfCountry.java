package com.engeto.Ukol_06;

import java.io.*;
import java.util.*;

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

    // export data to new file
    public void exportDataToFile (String delimiter) {



        String filename; // default value
        String dph;
        Double dphNum = 20.0; //default value
        Scanner input = new Scanner(System.in);
        System.out.print("Zadej n??zev, kter?? se pou??ije pro v??stupn?? export: ");
        filename = input.nextLine();
        //System.out.println("\n");
        System.out.print("Zadej sazbu DPH: ");
        dph = input.nextLine();

        // filename and dph
        if ((!filename.equals("")) && (!dph.equals("") )) {
            dphNum = Double.parseDouble(dph.replace(",","."));
            int intDph = dphNum.intValue();
            filename = ""+filename+"-over-"+intDph+".txt";
            System.out.println("N??zev souboru se jmenuje podle toho n??zvu souboru a sazby DPH. N??zev souboru: " + filename);
        } else {
            int intDph = dphNum.intValue();
            filename = "vat-over-"+intDph+".txt";
            System.out.println("Zm????kl si enter! N??zev souboru a dph maj?? vychoz?? hodnoty: " + filename + " | "+ intDph);
        }

        // vytvo??en?? kolekce
        System.out.println("=================LIST====================");
        Collections.sort(listOfCountry);
        List<Country> otherCountry = new ArrayList<>();
        for (Country country : listOfCountry) {
            if (country.getBasicDph() >= dphNum) {
                System.out.println(country);
            } else {
                otherCountry.add(country);
            }
        }
        System.out.println("------------------------------------");
        System.out.print("Sazba VAT "+dph+" % nebo ni?????? nebo pou????vaj?? speci??ln?? sazbu: ");
        otherCountry.forEach(state -> System.out.print(state.getShortCountryName()+", "));
        System.out.println("\n"+"=================END OF LIST====================");

        // export do souboru
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Country country : listOfCountry) {
                writer.println(
                        // verze, ktera zapise vsechna data oddelene tabulatorem
                        /*
                        country.getShortCountryName()
                        +delimiter
                        +country.getLongCountryName()
                        +delimiter
                        +country.getBasicDph()
                        +delimiter
                        +country.getReducedDph()
                        +delimiter
                        +country.getUseSpecialDph()
                         */

                        // verze kdy se data zapisi tak jako na obrazovku
                        country.getLongCountryName()
                        +" ("+ country.getShortCountryName() +"):"
                        +delimiter
                        +country.getBasicDph() + '%'
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add object into list
    public void addCountry(Country country) {
        listOfCountry.add(country);
    };

    // print all country and dph
    public void printAllCountry() {
        for (Country country : listOfCountry) {
            System.out.println(country);
        }
    }

    // print sorted list, dph >= 20
    public  void printCountrySorted20DPH(int dph) {
        Collections.sort(listOfCountry);
        List<Country> otherCountry = new ArrayList<>();
        for (Country country : listOfCountry) {
            if (country.getBasicDph() >= dph) {
                System.out.println(country);
            } else {
                otherCountry.add(country);
            }
        }
        System.out.println("=====================================");
        System.out.print("Sazba VAT " + dph + " % nebo ni?????? nebo pou????vaj?? speci??ln?? sazbu: ");
        otherCountry.forEach(state -> System.out.print(state.getShortCountryName()+", "+"\n"));
    }


}
